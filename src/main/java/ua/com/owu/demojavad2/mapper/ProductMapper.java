package ua.com.owu.demojavad2.mapper;

import org.springframework.stereotype.Component;
import ua.com.owu.demojavad2.dto.ProductDTO;
import ua.com.owu.demojavad2.entities.Product;

@Component
public class ProductMapper {

    public Product mapToEntity(ProductDTO dto) {
        Product product = new Product();

        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setAvailability(dto.getAvailability());

        if (product.getPrice() < 1){
            throw new RuntimeException("Price is less than 0");
        }
        return product;
    }

    public ProductDTO mapToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        product.setAvailability(product.getAvailability());
        return productDTO;

    }
}
