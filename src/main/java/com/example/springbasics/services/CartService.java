package com.example.springbasics.services;

import com.example.springbasics.dto.Cart;
import com.example.springbasics.entities.Product;
import com.example.springbasics.exceptions.ResourceNotFoundException;
import com.example.springbasics.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;
    private Cart cart;

    @PostConstruct
    public void init() {
        cart = new Cart();
    }

    public Cart getCurrentCart() {
        return cart;
    }

    public void addProductByIdToCart(Long productId) {
        if (!getCurrentCart().addProduct(productId)) {
            Product product = productService.getById(productId).orElseThrow(() -> new ResourceNotFoundException("Unable to add product to cart. Product not found, id: " + productId));
            getCurrentCart().addProduct(product);
        }
    }

    public void clear() {
        getCurrentCart().clear();
    }
}
