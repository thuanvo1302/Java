package tdtu.edu.vn.lab910.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.vn.lab910.Model.Order;
import tdtu.edu.vn.lab910.Service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order addedOrder = orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
