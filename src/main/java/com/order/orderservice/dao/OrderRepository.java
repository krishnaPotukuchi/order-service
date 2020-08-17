package com.order.orderservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.orderservice.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Integer> {
	
		List<Order> findByCustomerName(String customerName);
}

