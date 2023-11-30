package tdtu.edu.midterm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tdtu.edu.midterm.Models.Product;
import tdtu.edu.midterm.Service.impl.ProductServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/products")
public class ProductController {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images";
    @Autowired
    ProductServiceImpl productService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> listProducts = productService.getAll();
        model.addAttribute("listProducts",listProducts);
        return "admin";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }
    @PostMapping("/save")
    public String postProAdd(@ModelAttribute("productDTO") Product productDTO,
                             @RequestParam("productImage") MultipartFile fileProductImage,

                             @RequestParam("imgName") String imgName) throws IOException {

        Product product = new Product();
        product = productService.get((product.getId()));

        //convert dto > entity
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setBrand(productDTO.getBrand());
        product.setColor(productDTO.getColor());
        String imageUUID;
        if(!fileProductImage.isEmpty()){
            imageUUID = fileProductImage.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, fileProductImage.getBytes());
        }else {
            imageUUID = imgName;
        }//save image
        product.setImage(imageUUID);

        productService.save(product);
        return "redirect:/admin";
    }

//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public String saveProduct(@ModelAttribute("product") Product product) {
//        productService.save(product);
//        return "redirect:/admin";
//    }
    @GetMapping("/edit/{productId}")
    public String showEditProductPage(@PathVariable Long productId, Model model) {
        // Retrieve the existing product from the database
        Optional<Product> optionalProduct = Optional.ofNullable(productService.get(Math.toIntExact(productId)));

        if (optionalProduct.isPresent()) {
            // Product found, populate the model and return the edit page
            model.addAttribute("product", optionalProduct.get());
            return "edit_product";
        } else {
            // Product not found, handle accordingly (e.g., redirect to an error page)
            return "redirect:/admin"; // Adjust the redirect URL as needed
        }
    }

    @PostMapping("/edit/{productId}/save")
    public String postEditProduct(@PathVariable Long productId,
                                  @ModelAttribute("product") Product updatedProduct,
                                  @RequestParam("productImage") MultipartFile fileProductImage,
                                  @RequestParam("imgName") String imgName) throws IOException {

        Optional<Product> optionalProduct = Optional.ofNullable(productService.get(Math.toIntExact(productId)));

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setBrand(updatedProduct.getBrand());
            existingProduct.setColor(updatedProduct.getColor());

            String imageUUID;
            if (!fileProductImage.isEmpty()) {
                imageUUID = fileProductImage.getOriginalFilename();
                Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
                Files.write(fileNameAndPath, fileProductImage.getBytes());
            } else {
                imageUUID = imgName;
            }
            existingProduct.setImage(imageUUID);

            productService.save(existingProduct);

            return "redirect:/admin";
        } else {
            // Product not found, handle accordingly (e.g., redirect to an error page)
            return "redirect:/admin"; // Adjust the redirect URL as needed
        }
    }



    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productService.delete(id);
        return "redirect:/admin";
    }



}
