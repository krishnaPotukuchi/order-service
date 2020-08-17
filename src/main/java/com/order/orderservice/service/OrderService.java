package com.order.orderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.client.OrderItemBean;
import com.order.orderservice.client.OrderServiceProxy;
import com.order.orderservice.dao.OrderDAO;
import com.order.orderservice.entity.Order;
import com.order.orderservice.exception.OrderNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderDAO dao;
	
	@Autowired
	private OrderServiceProxy proxy;
	
	public void createOrder(Order order) {
		List<OrderItemBean> orderItems = order.getOrderItems();
		orderItems.stream().forEach(orderItem -> proxy.createOrder(orderItem));
		dao.createOrder(order);
	}
	

	public List<Order> getOrderDetails(String customerName) throws OrderNotFoundException {
		List<Order> orders = dao.getOrderDetails(customerName);
		if(orders.isEmpty()) {
				throw new OrderNotFoundException();
		}
		List<OrderItemBean> orderItems;
		List<OrderItemBean> orderItemsFromProxy = new ArrayList<>();
		for (Order order : orders) {
			orderItems = order.getOrderItems();
			for (OrderItemBean orderItem : orderItems) {
				OrderItemBean item = proxy.getOrderItemDetails(orderItem.getProductCode());
				orderItemsFromProxy.add(item);
			}
			order.setOrderItems(orderItemsFromProxy);
		}
		return orders;
	}
}
