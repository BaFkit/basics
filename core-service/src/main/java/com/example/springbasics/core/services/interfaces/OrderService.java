package com.example.springbasics.core.services.interfaces;

import com.example.springbasics.core.dto.OrderDetailsDto;
import com.example.springbasics.core.entities.User;
import com.example.springbasics.core.entities.Order;

import java.util.List;

public interface OrderService {

    void createOrder(User user, OrderDetailsDto orderDetailsDto);

    List<Order> findOrdersByUsername(String username);
}
