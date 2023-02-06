package com.example.springcache.components;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class CacheComponent {
	
	private static Logger logger = LoggerFactory.getLogger(CacheComponent.class);
	
	@Autowired
	private ClearCache clearCache;
	
	@Bean
	@Async
	public void verifyClock() throws InterruptedException {
		logger.info("EXECUTANDO O METODO QUE VERIFICA O RELOGIO.");
		while (true) {
			LocalTime time = LocalTime.now();
			int hour = time.getHour();
			int minute = time.getMinute();
			if (hour == 0 && minute == 0) {
				clearCache.clearAllCache();
			}
			TimeUnit.MINUTES.sleep(1l);
		}
		
	}
	
	public void clearCache(String entity) {
		if (entity.equals("employee")) {
			clearCache.clearEmployeeCache();
		}
	}
	
	
	
	

}
