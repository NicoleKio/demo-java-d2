package ua.com.owu.demojavad2.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.owu.demojavad2.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {

    List<Product> findAllByPriceBetween(Double minPrice, Double maxPrice);

    List<Product> findAllByPriceGreaterThan(Double minPrice);
    List<Product> findAllByPriceLessThan(Double maxPrice);


}
