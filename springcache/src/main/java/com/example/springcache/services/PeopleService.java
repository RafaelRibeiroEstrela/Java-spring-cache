package com.example.springcache.services;

import java.util.List;

import com.example.springcache.dtos.EmployeeDTO;

public interface PeopleService {
	
	List<EmployeeDTO> findAll();
	EmployeeDTO findById(Long id);
	EmployeeDTO findByCpfAndRegister(String cpf, String register);
	EmployeeDTO save(EmployeeDTO dto);
	EmployeeDTO update(Long id, EmployeeDTO dto);
	void delete(Long id);
	

}
