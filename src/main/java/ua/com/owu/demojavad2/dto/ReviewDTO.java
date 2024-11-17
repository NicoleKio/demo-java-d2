package ua.com.owu.demojavad2.dto;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewDTO {
    private ObjectId id;

    private Long productId;

    private String text;

    private Integer rating;

    private LocalDateTime timestamp;
}
