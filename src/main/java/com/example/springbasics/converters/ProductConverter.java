package com.example.springbasics.converters;

import com.example.springbasics.dto.ProductDto;
import com.example.springbasics.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }

}
