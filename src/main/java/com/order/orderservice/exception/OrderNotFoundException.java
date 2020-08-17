package com.order.orderservice.exception;

public class OrderNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public OrderNotFoundException() {
		super();
	}
	
	public OrderNotFoundException(String errorMessage, Throwable ex) {
		super(errorMessage, ex);
	}
	
	
	
}
