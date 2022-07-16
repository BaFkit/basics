package com.example.springbasics.controllers;

import com.example.springbasics.converters.OrderConverter;
import com.example.springbasics.dto.OrderDto;
import com.example.springbasics.services.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderConverter orderConverter;

    @PostMapping
    public void saveNewOrder(@RequestBody OrderDto orderDto) {

    }

}
