package tdtu.edu.midterm.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import tdtu.edu.midterm.Models.Product;


@Component
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findById(int id);
    Product getProductById(int id);
}
