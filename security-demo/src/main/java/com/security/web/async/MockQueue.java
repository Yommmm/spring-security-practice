package com.security.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockQueue {

	private static final Logger logger = LoggerFactory.getLogger(MockQueue.class);
	
	private String placeOrder;
	
	private String completeOrder;

	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) {
		logger.info("=================");
		this.placeOrder = placeOrder;
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder;
	}
	
}
