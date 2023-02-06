package com.example.springcache.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcache.dtos.EmployeeDTO;
import com.example.springcache.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping(value = "/buscar-cpf-register")
	public ResponseEntity<EmployeeDTO> findByCpfAndRegister(@RequestParam String cpf, @RequestParam String register){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByCpfAndRegister(cpf, register));
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> save(@RequestBody @Valid EmployeeDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @RequestBody @Valid EmployeeDTO dto){
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	

}
