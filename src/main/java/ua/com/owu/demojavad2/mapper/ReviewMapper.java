package ua.com.owu.demojavad2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.com.owu.demojavad2.dto.ReviewDTO;
import ua.com.owu.demojavad2.entities.Review;

import java.time.LocalDateTime;

@Mapper(imports = LocalDateTime.class)
    public interface ReviewMapper {
        ReviewDTO mapToDTO(Review review);

        @Mapping(target = "timestamp", expression = "java(LocalDateTime.now())")
        Review mapToEntity(ReviewDTO dto);
    }

