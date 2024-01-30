package tdtu.edu.vn.lab910.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.vn.lab910.Model.Product;
import tdtu.edu.vn.lab910.Service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        updatedProduct.setId(id);
        Product savedProduct = productService.updateProduct(updatedProduct);
        return ResponseEntity.ok(savedProduct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> partiallyUpdateProduct(@PathVariable int id, @RequestBody Product partialProduct) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        partialProduct.setId(id);
        Product savedProduct = productService.partiallyUpdateProduct(partialProduct);
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}