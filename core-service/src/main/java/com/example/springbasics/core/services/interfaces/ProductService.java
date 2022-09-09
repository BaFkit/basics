package com.example.springbasics.core.services.interfaces;

import com.example.springbasics.api.core.ProductDto;
import com.example.springbasics.core.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();

    Page<Product> findAll(Integer minCost, Integer maxCost, String titlePart,  Long categoryId, Integer page);

    Product save(Product product);

    Product update(ProductDto productDto);

    Optional<Product> getById(Long id);

    void deleteById(Long id);
}
