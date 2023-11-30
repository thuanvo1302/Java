package tdtu.edu.midterm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.midterm.Models.Cart;
import tdtu.edu.midterm.Repository.CartRepository;

import java.util.List;

@Service
public interface CartService {

    List<Cart> getAll();

    List<Cart> getCartsByUsername(String username);

    Cart add(Cart cart);

    void delete(int id);
}
