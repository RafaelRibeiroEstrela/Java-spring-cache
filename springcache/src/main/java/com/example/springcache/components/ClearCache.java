package com.example.springcache.components;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class ClearCache {

	private static Logger logger = LoggerFactory.getLogger(CacheComponent.class);

	// Colocar todas as entidades
	@CacheEvict(value = { "employee" }, allEntries = true)
	public void clearAllCache() {
		logger.info("EXECUTANDO O METODO QUE LIMPA TODO O CACHE - " + LocalTime.now());
	}

	// Colocar somente a entidade que será limpa
	@CacheEvict(value = "employee", allEntries = true)
	public void clearEmployeeCache() {
		logger.info("EXECUTANDO O METODO QUE LIMPA O CACHE DE EMPLOYEE - " + LocalTime.now());
	}

}
