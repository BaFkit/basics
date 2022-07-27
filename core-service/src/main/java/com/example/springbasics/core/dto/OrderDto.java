package com.example.springbasics.core.dto;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    private Long id;
    private String userName;
    private int totalPrice;
    private String address;
    private String phone;
    private List<OrderItemDto> items;

}
