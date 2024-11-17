package ua.com.owu.demojavad2.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.owu.demojavad2.entities.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

    List<Review> findAllByProductId(Long productId);

}
