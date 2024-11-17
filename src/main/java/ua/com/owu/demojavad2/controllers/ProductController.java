package ua.com.owu.demojavad2.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.owu.demojavad2.entities.Product;
import ua.com.owu.demojavad2.repository.ProductRepository;
import ua.com.owu.demojavad2.service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts() {
        return ResponseEntity<List<Product>>
    }


}
