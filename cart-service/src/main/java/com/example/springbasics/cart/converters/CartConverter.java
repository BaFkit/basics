package com.example.springbasics.cart.converters;

import com.example.springbasics.api.cart.CartDto;
import com.example.springbasics.api.cart.CartItemDto;
import com.example.springbasics.cart.models.Cart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartConverter {
    public CartDto modelToDto(Cart cart) {
        List<CartItemDto> cartItemDtos = cart.getItems().stream().map(it ->
                new CartItemDto(it.getProductId(), it.getProductTitle(), it.getQuantity(), it.getPricePerProduct(), it.getPrice())
        ).collect(Collectors.toList());
        CartDto cartDto = new CartDto(cartItemDtos, cart.getTotalPrice());
        return cartDto;
    }
}
