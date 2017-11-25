package com.security.web.async;

import java.util.concurrent.Callable;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class AsyncController {

	@Autowired
	private MockQueue mockQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);
	
//	@GetMapping("/order")
	public Callable<String> order() throws InterruptedException {
		logger.info("============主线程start===========");
//		Thread.sleep(3000);
		Callable<String> result = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				logger.info("============副线程start===========");
				Thread.sleep(3000);
				logger.info("============副线程finish============");
				return "success";
			}
		};
		logger.info("============主线程finish============");
//		return "success";
		return result;
	}
	
	@GetMapping("/order")
	public DeferredResult<String> orderByDeferred() throws Exception {
		logger.info("============主线程开始===========");
		
		String orderNumber = RandomStringUtils.randomNumeric(8);
		mockQueue.setPlaceOrder(orderNumber);
		DeferredResult<String> result = new DeferredResult<>();
		deferredResultHolder.getMap().put(orderNumber, result);
		
		return result;
	}	
	
}
