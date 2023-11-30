//package tdtu.edu.midterm.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import tdtu.edu.midterm.Models.User;
//import tdtu.edu.midterm.Repository.UserRepository;
//
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        User user = userRepo.getUserByEmail(email);
//
//        if (user != null) {
//            return new CustomUserDetails(user);
//        }
//
//        throw new UsernameNotFoundException("user not available");
//    }
//
//}