package com.ashu.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ashu.practice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

	List<Employee> findByNameIgnoreCaseContainingOrDesignationIgnoreCaseContainingOrDepartmentIgnoreCaseContaining(
			String name, String designation, String department);

	List<Employee> findByNameLike(String name);
}
