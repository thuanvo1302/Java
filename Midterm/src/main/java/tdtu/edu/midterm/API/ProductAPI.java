package tdtu.edu.midterm.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.midterm.Models.Product;
import tdtu.edu.midterm.Service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/product")
public class ProductAPI {
    @Autowired
    private ProductService productService;

    //CRUD
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException  {
        Optional<Product> product = Optional.ofNullable(productService.get(Math.toIntExact(id)));
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product p = productService.save(product);
        return ResponseEntity.ok(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.update(id,product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok("Xóa sản phẩm thành công");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sản phẩm với ID = " + id);
        }
    }
}
