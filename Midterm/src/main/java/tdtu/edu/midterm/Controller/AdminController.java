package tdtu.edu.midterm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tdtu.edu.midterm.Models.Product;
import tdtu.edu.midterm.Models.User;
import tdtu.edu.midterm.Service.ProductService;
import tdtu.edu.midterm.Service.UserService;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

//    @GetMapping("/admin")
//    public String Product(Model model) {
//        List<Product> lp = productService.getAll();
//        List<User> us = userService.getAll();
//        if(lp != null) {
//            model.addAttribute("products", lp);
//            model.addAttribute("users", us);
//        }
//        return "admin";
//    }

}
