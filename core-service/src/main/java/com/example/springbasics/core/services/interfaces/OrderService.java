package com.example.springbasics.core.services.interfaces;

import com.example.springbasics.core.dto.OrderDetailsDto;
import com.example.springbasics.core.entities.Order;

import java.util.List;

public interface OrderService {

    void createOrder(String username, OrderDetailsDto orderDetailsDto);

    List<Order> findOrdersByUsername(String username);
}
