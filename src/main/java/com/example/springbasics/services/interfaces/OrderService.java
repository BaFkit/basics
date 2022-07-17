package com.example.springbasics.services.interfaces;

import com.example.springbasics.dto.OrderDetailsDto;
import com.example.springbasics.entities.Order;
import com.example.springbasics.entities.User;

import java.util.List;

public interface OrderService {

    void createOrder(User user, OrderDetailsDto orderDetailsDto);

    List<Order> findOrdersByUsername(String username);
}
