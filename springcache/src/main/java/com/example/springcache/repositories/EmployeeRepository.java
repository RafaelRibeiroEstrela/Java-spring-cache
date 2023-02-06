package com.example.springcache.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springcache.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Employee findByCpfAndRegister(String cpf, String register);

}
