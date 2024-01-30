package tdtu.edu.vn.lab910.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.vn.lab910.Model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}