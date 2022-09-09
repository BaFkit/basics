package com.example.springbasics.core.services.interfaces;

import com.example.springbasics.api.core.OrderDetailsDto;
import com.example.springbasics.core.entities.Order;

import java.util.List;

public interface OrderService {

    void createOrder(String username, OrderDetailsDto orderDetailsDto);

    List<Order> findOrdersByUsername(String username);
}
