package com.example.springbasics.core.controllers;

import com.example.springbasics.core.converters.ProductConverter;
import com.example.springbasics.core.exceptions.ResourceNotFoundException;
import com.example.springbasics.core.services.interfaces.ProductService;
import com.example.springbasics.core.validators.ProductValidator;
import com.example.springbasics.core.dto.ProductDto;
import com.example.springbasics.core.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    @GetMapping
    public Page<ProductDto> getAllProducts(
            @RequestParam(name = "min_cost", required = false) Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost,
            @RequestParam(name = "title_part", required = false) String titlePart,
            @RequestParam(name = "category", required = false) Long categoryId,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(minCost, maxCost, titlePart, categoryId, page).map(p -> productConverter.entityToDto(p));
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        Product product = productService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return productConverter.entityToDto(product);
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        product = productService.save(product);
        return productConverter.entityToDto(product);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productService.update(productDto);
        return productConverter.entityToDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
