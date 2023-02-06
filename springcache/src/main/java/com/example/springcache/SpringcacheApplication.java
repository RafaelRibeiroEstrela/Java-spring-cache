package com.example.springcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.springcache.components.CacheComponent;

@SpringBootApplication
@EnableCaching
public class SpringcacheApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringcacheApplication.class, args);
	}
	
	@Autowired
	private CacheComponent cache;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		cache.clearCache();
	}

}
