package com.order.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name="order-item-service", url="localhost:8000")
public interface OrderServiceProxy {
	
	@PostMapping("/order-item/create")
	public void createOrder(@RequestBody OrderItemBean orderItem);
	
	@GetMapping("/order-item/{productCode}")
	public OrderItemBean getOrderItemDetails(@PathVariable("productCode") int productCode);
	
}
