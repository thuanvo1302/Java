package tdtu.edu.midterm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tdtu.edu.midterm.Models.Cart;
import tdtu.edu.midterm.Models.Product;
import tdtu.edu.midterm.Service.CartService;
import tdtu.edu.midterm.Service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private HttpSession session;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @RequestMapping("/cart")
    public String renderCart(Model model) {

        Object s = session.getAttribute("user");
        if(s == null) {
            return "redirect:/signin";
        }

        List<Cart> carts = cartService.getCartsByUsername(String.valueOf(s));
        if(carts != null) {
            model.addAttribute("carts", carts);
        }
        return "cart";
    }
    @PostMapping ("/add-cart")
    public @ResponseBody ResponseEntity<String> addCart(Model model, @RequestParam String user, @RequestParam String product_id) {
        System.out.println(user);
        System.out.println(product_id);
        int pid = Integer.parseInt(product_id);
        Product p = productService.get(pid);
        Cart cart = new Cart();
        cart.setUsername(user);
        cart.setQuantity(cart.getQuantity() + 1);
        cart.setProduct_id(pid);
        cart.setProduct_name(p.getName());
        cart.setProduct_price(p.getPrice());
        cart.setProduct_image(p.getImage());
        Cart rs = cartService.add(cart);

        if (rs != null) {
            return new ResponseEntity<String>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("error", HttpStatus.OK);
//            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete-cart")
    public ResponseEntity<String> deleteCart(@RequestParam String id) {
        try {
            cartService.delete(Integer.parseInt(id));
            return new ResponseEntity<String>("success", HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<String>("error", HttpStatus.OK);
        }
    }
}