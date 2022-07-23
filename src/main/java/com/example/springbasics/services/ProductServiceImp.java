package com.example.springbasics.services;

import com.example.springbasics.dto.ProductDto;
import com.example.springbasics.entities.Product;
import com.example.springbasics.exceptions.ResourceNotFoundException;
import com.example.springbasics.repositories.ProductRepository;
import com.example.springbasics.repositories.specifications.ProductsSpecifications;
import com.example.springbasics.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAll(Integer minCost, Integer maxCost, String titlePart, Long categoryId, Integer page) {
        Specification<Product> spec = Specification.where(null);
        if (minCost != null) {
            spec = spec.and(ProductsSpecifications.costGreaterOrEqualsThan(minCost));
        }
        if (maxCost != null) {
            spec = spec.and(ProductsSpecifications.costLessOrEqualsThan(maxCost));
        }
        if (categoryId != null) {
            spec = spec.and(ProductsSpecifications.equalCategory(categoryId));
        }
        if (titlePart != null) {
            spec = spec.and(ProductsSpecifications.titleLike(titlePart));
        }
        return productRepository.findAll(spec, PageRequest.of(page - 1, 7));
    }

    @Override
    @Transactional
    public Product save(Product product) {
       return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product update(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Unable to update product, not found in database, id: " + productDto.getId()));
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        return product;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
