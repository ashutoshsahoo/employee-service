package com.ashu.practice.service;

import java.util.List;

import com.ashu.practice.dto.CreateEmployeeRequest;
import com.ashu.practice.dto.EmployeeDto;
import com.ashu.practice.dto.EmployeeSearchRequest;
import com.ashu.practice.dto.UpdateEmployeeRequest;

public interface EmployeeService {

	EmployeeDto viewById(Long id);

	List<EmployeeDto> getAll();

	EmployeeDto create(CreateEmployeeRequest createEmployee);

	EmployeeDto update(Long id, UpdateEmployeeRequest updateEmployee);

	void delete(Long id);

	List<EmployeeDto> search(EmployeeSearchRequest request);

}
