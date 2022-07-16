package com.example.springbasics.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDto {

    private Long productId;
    private Long userId;
    private Long orderId;
    private int quantity;
    private int pricePerProduct;
    private int price;
    private List<OrderItemDto> orderItemDtoList;

}
