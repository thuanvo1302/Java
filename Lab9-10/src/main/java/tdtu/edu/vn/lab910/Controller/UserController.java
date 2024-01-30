package tdtu.edu.vn.lab910.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tdtu.edu.vn.lab910.Model.User;
import tdtu.edu.vn.lab910.Service.UserService;

@Controller
@RequestMapping("/api/account")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            String token = userService.loginUser(user.getEmail(), user.getPassword());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

}
