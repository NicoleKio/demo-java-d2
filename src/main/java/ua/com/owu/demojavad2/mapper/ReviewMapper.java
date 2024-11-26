package ua.com.owu.demojavad2.mapper;

import org.mapstruct.Mapper;
import ua.com.owu.demojavad2.dto.ReviewDTO;
import ua.com.owu.demojavad2.entities.Review;

    @Mapper
    public interface ReviewMapper {
        ReviewDTO mapToDTO(Review review);
        Review mapToEntity(ReviewDTO dto);
    }

