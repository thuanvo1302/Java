package tdtu.edu.midterm.Service.impl;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.midterm.Models.Product;
import tdtu.edu.midterm.Repository.ProductRepository;
import tdtu.edu.midterm.Service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> getAll(){
        return repo.findAll();
    }

    public Product save(Product product) {
        return repo.save(product);
    }
    public Product update(Long id, Product updatedProduct){
        Product existingProduct = repo.findById(Math.toIntExact(id));

        // Update the existing product with the values from the updatedProduct
        existingProduct.setName(updatedProduct.getName());

        existingProduct.setBrand(updatedProduct.getBrand());
        existingProduct.setColor(updatedProduct.getColor());
        existingProduct.setPrice(updatedProduct.getPrice());


        // Save the updated product
        return repo.save(existingProduct);
    }
    public Boolean delete(long id) {
        Optional<Product> optionalProduct = Optional.ofNullable(repo.findById((int) id));
        if (optionalProduct.isPresent()) {
            repo.deleteById((int) id);
            return true;
        } else {
            return false;
        }
    }
    public Product get(int id) {
        return repo.getProductById(id);
    }
}
