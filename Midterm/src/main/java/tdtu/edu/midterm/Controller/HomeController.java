package tdtu.edu.midterm.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tdtu.edu.midterm.Models.Product;
import tdtu.edu.midterm.Models.User;
import tdtu.edu.midterm.Service.UserService;
import tdtu.edu.midterm.Service.ProductService;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public String index(Model model) {
        List<Product> listProducts = productService.getAll();
        model.addAttribute("listProducts",listProducts);
        return "index";
    }



//    @GetMapping("/register")
//    public String register() {
//        return "register";
//    }

//    @PostMapping("/createUser")
//    public String createuser(@ModelAttribute User user, HttpSession session) {
//
//
//
//        boolean f = userService.checkEmail(user.getEmail());
//
//        if (f) {
//            session.setAttribute("msg", "Email Id alreday exists");
//        }
//
//        else {
//            User userDtls = userService.add(user);
//            if (userDtls != null) {
//                session.setAttribute("msg", "Register Sucessfully");
//            } else {
//                session.setAttribute("msg", "Something wrong on server");
//            }
//        }
//
//        return "redirect:/register";
//    }

}
