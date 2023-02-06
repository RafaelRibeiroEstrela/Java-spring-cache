package com.example.springcache.dtos;

import java.io.Serializable;

import com.example.springcache.models.Employee;

public class EmployeeDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	private String register;
	
	public EmployeeDTO() {
		
	}
	
	public EmployeeDTO(Employee emp) {
		this.id = emp.getId();
		this.name = emp.getName();
		this.cpf = emp.getCpf();
		this.register = emp.getRegister();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}
	
	
	
	

}
