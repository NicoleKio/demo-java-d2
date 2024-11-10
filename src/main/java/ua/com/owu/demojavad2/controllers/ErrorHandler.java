package ua.com.owu.demojavad2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.com.owu.demojavad2.dto.ErrorDTO;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDTO> handleIllegalArgumentError(Exception e) {
        return ResponseEntity
                .badRequest()
                .body(ErrorDTO.builder()
                        .message(e.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build());
    }

}
