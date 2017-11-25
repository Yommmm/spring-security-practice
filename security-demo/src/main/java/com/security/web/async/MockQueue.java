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

	public void setPlaceOrder(String placeOrder) throws Exception {
		logger.info("接到下单请求：{}", placeOrder);
		Thread.sleep(1000);
		this.completeOrder = placeOrder;
		logger.info("下单请求处理完毕：{}", placeOrder);
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder;
	}
	
}
