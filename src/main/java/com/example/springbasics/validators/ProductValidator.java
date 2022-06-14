package com.example.springbasics.validators;

import com.example.springbasics.dto.ProductDto;
import com.example.springbasics.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    public void validate(ProductDto productDto) {
        List<String> errors = new ArrayList<>();
        if (productDto.getCost() < 1) {
            errors.add("Price cannot be less than 1");
        }
        if (productDto.getTitle().isBlank()) {
            errors.add("The product cannot be without a title");
        }
        if (!errors.isEmpty()) {
            throw  new ValidationException(errors);
        }
    }
}
