package com.example.springcache.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springcache.dtos.EmployeeDTO;
import com.example.springcache.models.Employee;
import com.example.springcache.repositories.EmployeeRepository;
import com.example.springcache.services.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService{
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findAll() {
		return repository.findAll().stream()
				.map(obj -> new EmployeeDTO(obj))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(key = "#id", value = "employee")
	public EmployeeDTO findById(Long id) {
		Employee people = repository.findById(id).orElseThrow(() -> new RuntimeException("Não foi encontrado um registro com id = " + id));
		return new EmployeeDTO(people);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(key = "{#cpf,#register}", value = "employee")
	public EmployeeDTO findByCpfAndRegister(String cpf, String register) {
		Employee people = repository.findByCpfAndRegister(cpf, register);
		if (people == null) {
			return null;
		}
		return new EmployeeDTO(people);
	}

	@Override
	public EmployeeDTO save(EmployeeDTO dto) {
		Employee people = new Employee();
		copyDtoToEntity(dto, people);
		people = repository.save(people);
		return new EmployeeDTO(people);
	}

	@Override
	@CachePut(key = "#id", value = "employee")
	public EmployeeDTO update(Long id, EmployeeDTO dto) {
		Employee people = repository.findById(id).orElseThrow(() -> new RuntimeException("Não foi encontrado um registro com id = " + id));
		copyDtoToEntity(dto, people);
		people = repository.save(people);
		return new EmployeeDTO(people);
	}

	@Override
	@CacheEvict(key = "#id", value = "employee")
	public void delete(Long id) {
		repository.findById(id).orElseThrow(() -> new RuntimeException("Não foi encontrado um registro com id = " + id));
		try {
			repository.deleteById(id);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void copyDtoToEntity(EmployeeDTO dto, Employee entity) {
		
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setRegister(dto.getRegister());
	}


	

}
