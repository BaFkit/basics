package com.example.springbasics.core.validators;

import com.example.springbasics.api.core.ProductDto;
import com.example.springbasics.api.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    public void validate(ProductDto productDto) {
        List<String> errors = new ArrayList<>();
        if (productDto.getPrice() < 1) {
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
