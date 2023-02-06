package com.example.springcache.components;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class CacheComponent {
	
	private static Logger logger = LoggerFactory.getLogger(CacheComponent.class);
	
	@Bean
	@Async
	public void verifyClock() throws InterruptedException {
		logger.info("EXECUTANDO O METODO QUE VERIFICA O RELOGIO.");
		while (true) {
			LocalTime time = LocalTime.now();
			int hour = time.getHour();
			int minute = time.getMinute();
			if (hour == 0 && minute == 0) {
				clearCache();
			}
			TimeUnit.MINUTES.sleep(1l);
		}
		
	}
	
	//Colocar todas as tabelas/collections
	@CacheEvict(value = {"employee"}, allEntries = true)
	public void clearCache() {
		logger.info("EXECUTANDO O METODO QUE LIMPA O CACHE - " + LocalTime.now());
	}

	/*
	public void clearCache() {
		logger.info("EXECUTANDO O METODO QUE LIMPA O CACHE - " + LocalTime.now());
		cacheManager.getCacheNames().stream()
			.forEach(cacheName -> cacheManager.getCache(cacheName)
			.clear());
	}
	*/

}
