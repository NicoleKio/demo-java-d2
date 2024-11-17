package ua.com.owu.demojavad2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.owu.demojavad2.repository.ProductRepository;
import ua.com.owu.demojavad2.repository.ReviewRepository;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;



}
