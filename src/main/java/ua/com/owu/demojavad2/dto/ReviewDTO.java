package ua.com.owu.demojavad2.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewDTO {

    private String text;

    private Integer rating;

    private LocalDateTime timestamp;
}
