package tdtu.edu.vn.lab910.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.lab910.Model.Order;
import tdtu.edu.vn.lab910.Repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(int id, Order updatedOrder) {
        Order existingOrder = getOrderById(id);
        if (existingOrder == null) {
            return null;
        }
        updatedOrder.setId(id);
        return orderRepository.save(updatedOrder);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

}

