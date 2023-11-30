package tdtu.edu.midterm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.midterm.Models.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> getCartsByUsername(String username);
}
