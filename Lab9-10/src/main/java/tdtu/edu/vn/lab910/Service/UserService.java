package tdtu.edu.vn.lab910.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.lab910.Exception.EmailAlreadyExistsException;
import tdtu.edu.vn.lab910.Exception.InvalidPasswordException;
import tdtu.edu.vn.lab910.Exception.UserNotFoundException;
import tdtu.edu.vn.lab910.Model.User;
import tdtu.edu.vn.lab910.Repository.UserRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Value("${jwt.secret}")
    private String jwtSecret;

    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public String loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setIssuedAt(new Date())
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean isAuthorized(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getUserIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return Integer.parseInt(claims.getSubject());
    }
}
