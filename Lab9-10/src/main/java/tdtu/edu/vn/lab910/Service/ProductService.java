package tdtu.edu.vn.lab910.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.lab910.Model.Product;
import tdtu.edu.vn.lab910.Repository.ProductRepository;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProductById(int id) {
        getProductById(id);
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product updatedProduct) {
        return productRepository.save(updatedProduct);
    }

    public Product partiallyUpdateProduct(Product partialProduct) {
        Product product = getProductById(partialProduct.getId());
        if (product == null) {
            return null;
        }
        BeanUtils.copyProperties(partialProduct, product, getNullPropertyNames(partialProduct));
        return productRepository.save(product);
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


}
