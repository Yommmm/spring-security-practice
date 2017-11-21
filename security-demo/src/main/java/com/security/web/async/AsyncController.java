package com.security.web.async;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

	private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);
	
	@GetMapping("/order")
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
}
