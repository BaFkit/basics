package com.example.springbasics.services;

import com.example.springbasics.entities.Order;
import com.example.springbasics.repositories.OrderRepository;
import com.example.springbasics.services.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void saveNewOrder(Order order) {
        orderRepository.save(order);
    }
}
