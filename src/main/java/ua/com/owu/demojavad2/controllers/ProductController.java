package ua.com.owu.demojavad2.controllers;

import com.mongodb.client.model.vault.RewrapManyDataKeyOptions;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.demojavad2.dto.ProductDTO;
import ua.com.owu.demojavad2.dto.ReviewDTO;
import ua.com.owu.demojavad2.entities.Product;
import ua.com.owu.demojavad2.entities.Review;
import ua.com.owu.demojavad2.repository.ProductRepository;
import ua.com.owu.demojavad2.service.ProductService;

import java.util.List;
import java.util.ResourceBundle;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository   ;
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity <List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addProduct(productDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable ObjectId id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewDTO> createReview(@RequestParam Long productId, @RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(this.productService.createReview(reviewDTO));
    }


}
