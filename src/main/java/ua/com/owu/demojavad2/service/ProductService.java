package ua.com.owu.demojavad2.service;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import ua.com.owu.demojavad2.dto.ProductDTO;
import ua.com.owu.demojavad2.dto.ReviewDTO;
import ua.com.owu.demojavad2.entities.Product;
import ua.com.owu.demojavad2.entities.Review;
import ua.com.owu.demojavad2.mapper.ProductMapper;
import ua.com.owu.demojavad2.mapper.ReviewMapper;
import ua.com.owu.demojavad2.repository.ProductRepository;
import ua.com.owu.demojavad2.repository.ReviewRepository;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    private final ReviewMapper reviewMapper;
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
    public ProductDTO addProduct(ProductDTO addedProduct) {
        Product product = productMapper.mapToEntity(addedProduct);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToDto(savedProduct);
    }

    // getProductById

    public ProductDTO getById(ObjectId id) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
        return productMapper.mapToDto(product);
    }


    //-------------------------------------------------------------------------------

    public ReviewDTO createReview(Long productId, ReviewDTO newReviewDTO) {
        Review review = reviewMapper.mapToEntity(newReviewDTO);
        review.setProductId(productId);
        return reviewMapper.mapToDTO(reviewRepository.save(review));
    }

}
