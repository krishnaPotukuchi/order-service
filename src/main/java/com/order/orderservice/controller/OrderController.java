package com.order.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderservice.entity.Order;
import com.order.orderservice.exception.OrderNotFoundException;
import com.order.orderservice.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/order/create")
	public void createOrder(@RequestBody Order order) {
		service.createOrder(order);
	}
	
	@GetMapping("/order/{customerName}")
	public List<Order> getOrderDetails(@PathVariable String customerName)  throws OrderNotFoundException {
		return service.getOrderDetails(customerName);
	}
	
	
}
