package ua.com.owu.demojavad2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.owu.demojavad2.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetween(Double minPrice, Double maxPrice);

//    List<Product> findAllBy (Double price);
}
