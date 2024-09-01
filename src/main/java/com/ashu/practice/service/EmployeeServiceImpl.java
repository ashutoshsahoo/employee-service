package com.ashu.practice.service;

import com.ashu.practice.dto.CreateEmployeeRequest;
import com.ashu.practice.dto.EmployeeDto;
import com.ashu.practice.dto.EmployeeSearchRequest;
import com.ashu.practice.dto.UpdateEmployeeRequest;
import com.ashu.practice.exception.EmployeeNotFoundException;
import com.ashu.practice.model.Employee;
import com.ashu.practice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository empRepo;

    @Override
    public EmployeeDto create(CreateEmployeeRequest createEmployee) {
        Employee employeeRequest = new Employee();
        BeanUtils.copyProperties(createEmployee, employeeRequest);
        Employee employee = empRepo.saveAndFlush(employeeRequest);
        return mapModelToDto(employee);
    }

    @Override
    public EmployeeDto viewById(Long id) {
        Employee employee = findById(id);
        return mapModelToDto(employee);
    }

    @Override
    public List<EmployeeDto> getAll() {
        return empRepo.findAll().stream().map(this::mapModelToDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto update(Long id, UpdateEmployeeRequest updateEmployee) {
        Employee employee = findById(id);
        BeanUtils.copyProperties(updateEmployee, employee);
        employee = empRepo.save(employee);
        return mapModelToDto(employee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = findById(id);
        empRepo.delete(employee);
    }

    @Override
    public List<EmployeeDto> search(EmployeeSearchRequest request) {

//		List<Employee> employees = empRepo
//				.findByNameIgnoreCaseContainingOrDesignationIgnoreCaseContainingOrDepartmentIgnoreCaseContaining(
//						request.getName(), request.getDesignation(), request.getDepartment());

//		Specification<Employee> specification = EmployeeSpecifications.withDynamicQuery(request.getName(),
//				request.getDesignation(), request.getDepartment());
//		List<Employee> employees = employees = empRepo.findAll(specification);
//		log.debug("employees by Specification" + employees.size());
//		employees = empRepo.findByNameLike(request.getName());

        Employee employee = new Employee(request.getName(), request.getDesignation(), request.getDepartment());
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase()
                .withMatcher("name", GenericPropertyMatcher::contains)
                .withMatcher("designation", GenericPropertyMatcher::contains)
                .withMatcher("department", GenericPropertyMatcher::contains);
        Example<Employee> example = Example.of(employee, matcher);
        List<Employee> employees = empRepo.findAll(example);
        return employees.stream().map(this::mapModelToDto).toList();
    }

    private Employee findById(Long id) {
        Optional<Employee> isEmployee = empRepo.findById(id);
        if (isEmployee.isPresent()) {
            return isEmployee.get();
        }
        log.debug("Employee not found for requested id={}", id);
        throw new EmployeeNotFoundException(id);
    }

    private EmployeeDto mapModelToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }

}
