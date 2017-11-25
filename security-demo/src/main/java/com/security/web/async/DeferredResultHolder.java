package com.security.web.async;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.context.request.async.DeferredResult;

public class DeferredResultHolder {

	private Map<String, DeferredResult<String>> map = new HashMap<String, DeferredResult<String>>();

	public Map<String, DeferredResult<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, DeferredResult<String>> map) {
		this.map = map;
	}
	
}
