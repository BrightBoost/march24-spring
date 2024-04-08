package com.oauthdemo.resourceserverexample.controller;

import com.oauthdemo.resourceserverexample.model.Order;
import com.oauthdemo.resourceserverexample.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Additional CRUD endpoints as required.
}
