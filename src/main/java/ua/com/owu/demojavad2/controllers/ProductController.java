package ua.com.owu.demojavad2.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.demojavad2.entities.Product;
import ua.com.owu.demojavad2.entities.Review;
import ua.com.owu.demojavad2.repository.ProductRepository;
import ua.com.owu.demojavad2.service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

//    @GetMapping()
//    public List<Product> getAllProducts() {
//        return ResponseEntity<List<Product>>
//    }
    // to-do дописать все методы и логику в сервисе


    @PostMapping("/{id}/reviews")
    public ResponseEntity<Review> addReview(@PathVariable int id, @RequestBody Review review) {
        return ResponseEntity.ok()
    }


}
