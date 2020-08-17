package com.order.orderservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.order.orderservice.entity.Order;

@Repository
public class OrderDAO {

	@Autowired
	private OrderRepository repository;
	
	public void createOrder(Order order) {
		 repository.save(order);
	}
	
	public List<Order> getOrderDetails(String customerName) {
		return repository.findByCustomerName(customerName);
	}
	
}
