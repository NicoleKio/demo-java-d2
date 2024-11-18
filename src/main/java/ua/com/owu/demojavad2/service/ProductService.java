package ua.com.owu.demojavad2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.owu.demojavad2.dto.ProductDTO;
import ua.com.owu.demojavad2.mapper.ProductMapper;
import ua.com.owu.demojavad2.repository.ProductRepository;
import ua.com.owu.demojavad2.repository.ReviewRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    // getProducts

    public List<ProductDTO> getProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::mapToDto)
                .toList();
    }

    // postProduct

    


    // getProductById


    //

}
