package com.ashu.practice.controller;

import com.ashu.practice.dto.CreateEmployeeRequest;
import com.ashu.practice.dto.EmployeeDto;
import com.ashu.practice.dto.EmployeeSearchRequest;
import com.ashu.practice.dto.UpdateEmployeeRequest;
import com.ashu.practice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto create(@RequestBody @Valid CreateEmployeeRequest createEmployee) {
        log.debug("Create employee");
        return employeeService.create(createEmployee);
    }

    @GetMapping
    public List<EmployeeDto> viewAll() {
        log.debug("All Employees");
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeDto viewById(@PathVariable(name = "id") Long id) {
        log.debug("View employee- ID: {}", id);
        return employeeService.viewById(id);
    }

    @PutMapping("/{id}")
    public EmployeeDto update(@PathVariable(name = "id") Long id,
                              @RequestBody @Valid UpdateEmployeeRequest updateEmployee) {
        log.debug("update employee- ID: {}", id);
        return employeeService.update(id, updateEmployee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        log.debug("Delete employee- ID: {}", id);
        employeeService.delete(id);
    }

    @GetMapping("/search")
    public List<EmployeeDto> search(@Valid EmployeeSearchRequest request) {
        log.debug("Search employee with query");
        return employeeService.search(request);
    }

}
