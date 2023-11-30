package tdtu.edu.midterm.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.midterm.Models.Product;
import tdtu.edu.midterm.Models.User;
import tdtu.edu.midterm.Repository.UserRepository;
import tdtu.edu.midterm.Service.ProductService;
import tdtu.edu.midterm.Service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @Autowired
    private ProductService productService;
    @Autowired
    private HttpSession session;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;



    public String redirectUserRole(String url) {
        Object role = session.getAttribute("user_role");
        Object s = session.getAttribute("user");
        if(s != null && role != null) {
            if(role.toString().equals("admin")) {
                return "redirect:/admin";
            }
            return "redirect:/";
        }
        return url;
    }

    @GetMapping("/admin")
    public String Product(Model model) {
        List<Product> lp = productService.getAll();
        if(lp != null) {
            model.addAttribute("products", lp);
        }
        return "admin";
    }


    @GetMapping("/signin")
    public String login() {
        return redirectUserRole("login");
    }
    @PostMapping("/login")
    public String signIn(Model model, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        System.out.println("post login: "+email+", "+password);
        String errMessage = "";

        if(email.trim().isEmpty()) {
            errMessage = "Username is empty";
        } else if(password.trim().isEmpty()) {
            errMessage = "Password is empty";
        } else if(password.trim().length() < 6) {
            errMessage = "Password must be at least 6 characters";
        }

        if(!errMessage.isEmpty()) {
            model.addAttribute("alert", errMessage);
            model.addAttribute("input_username", email);
            model.addAttribute("input_password", password);
            return "login";
        } else {
            User u = userService.get(email);
            if(u == null) {
                errMessage = "User not exits";
            } else {
                boolean flag = passwordEncoder.matches(password, u.getPassword());
                if(!flag) {
                    errMessage = "Wrong password";
                }
            }

            if(!errMessage.isEmpty()) {
                model.addAttribute("input_username", email);
                model.addAttribute("input_password", password);
                model.addAttribute("alert", errMessage);
                return "login";
            } else {
                session.setAttribute("user", u.getEmail());
                session.setAttribute("user_role", u.getRole());
                if(u.getRole().equals("admin")) {
                    return "redirect:/admin";
                } else {
                    return "redirect:/";
                }
            }
        }
    }
    @RequestMapping("/signup")
    public String register(Model model) {
        return redirectUserRole("register");
    }

    @PostMapping("/signup")
    public String signUp(Model model, @RequestParam(name = "fullname") String name, @RequestParam(name = "address") String address,
                         @RequestParam(name = "email") String email,
                         @RequestParam(name = "password") String pwd, @RequestParam(name = "confirm-password") String pwd_confirm) {

        String errMessage = "";
        User new_user = userService.get(email);
        if(name.trim().isEmpty()) {
            errMessage = "Name is empty";
        }
        else if(address.trim().isEmpty()) {
            errMessage = "Username is empty";
        }
        else if(email.trim().isEmpty()) {
            errMessage = "Email is empty";
        } else if(pwd.trim().isEmpty()) {
            errMessage = "Password is empty";
        } else if(pwd.trim().length() < 6) {
            errMessage = "Password must be at least 6 characters";
        } else if(!pwd_confirm.equals(pwd)) {
            errMessage = "Confirm password is not match";
        } else if(new_user != null) {
            errMessage = "This username already exists";
        }

        if(!errMessage.isEmpty()) {
            model.addAttribute("alert", errMessage);
            model.addAttribute("input_name", name);
            model.addAttribute("input_username", email);
            model.addAttribute("input_password", pwd);
            model.addAttribute("input_re_password", pwd_confirm);
            return "register";
        } else {
            User u = new User();
            u.setFullName(name);
            u.setEmail(email);
            u.setAddress(address);
            u.setRole("user");
            u.setPassword(passwordEncoder.encode(pwd));
            userService.add(u);
            session.setAttribute("user", u.getEmail());
            session.setAttribute("user_role", u.getRole());
            return "redirect:/";
        }
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session) {
        // Clear session attributes or perform other logout-related actions
        session.removeAttribute("user");
        session.removeAttribute("user_role");
        session.invalidate(); // Invalidate the session

        return "redirect:/login";
    }
//    @ModelAttribute
//    private void userDetails(Model m, Principal p) {
//        String email = p.getName();
//        User user = userRepo.findByEmail(email);
//
//        m.addAttribute("user", user);
//
//    }
//
//    @GetMapping("/")
//    public String home() {
//        return "user/home";
//    }

}
