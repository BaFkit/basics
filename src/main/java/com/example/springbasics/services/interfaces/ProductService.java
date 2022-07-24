package com.example.springbasics.services.interfaces;

import com.example.springbasics.dto.ProductDto;
import com.example.springbasics.entities.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {

    Page<Product> findAll(Integer minCost, Integer maxCost, String titlePart,  Long categoryId, Integer page);

    Product save(Product product);

    Product update(ProductDto productDto);

    Optional<Product> getById(Long id);

    void deleteById(Long id);
}
