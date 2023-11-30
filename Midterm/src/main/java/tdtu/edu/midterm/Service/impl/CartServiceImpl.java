package tdtu.edu.midterm.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.midterm.Models.Cart;
import tdtu.edu.midterm.Repository.CartRepository;
import tdtu.edu.midterm.Service.CartService;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public List<Cart> getCartsByUsername(String username) {
        return cartRepository.getCartsByUsername(username);
    }

    public Cart add(Cart cart) {
        return cartRepository.save(cart);
    }

    public void delete(int id) {
        cartRepository.deleteById(id);
    }
}
