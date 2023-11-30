package tdtu.edu.midterm.Service;

import tdtu.edu.midterm.Models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Product save(Product product);
    Product update(Long id, Product product);
    Boolean delete(long id);
    Product get(int id);

}
