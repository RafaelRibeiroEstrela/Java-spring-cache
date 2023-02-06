package com.example.springcache.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcache.components.CacheComponent;

@RestController
@RequestMapping(value = "/cache")
public class CacheResource {
	
	@Autowired
	private CacheComponent cache;
	
	@GetMapping(value = "/clear")
	public ResponseEntity<Void> clearCache(@RequestParam String entity){
		cache.clearCache(entity);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
