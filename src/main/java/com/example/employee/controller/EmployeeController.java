package com.example.employee.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(name = "/{id}", produces = "application/json")
	public Optional<Employee> findEmplyeeById(@NotBlank @PathVariable(name = "id") Integer id) {
		return employeeService.findEmployeeById(id);
	}

	@PostMapping(name = "/add", consumes = "application/json")
	public void addEmplyee(@Valid @NotNull Employee employee) {
		employeeService.saveEmployee(employee);
	}

	@PutMapping(name = "/update/{id}", consumes = "application/json")
	public void updateEmplyee(@NotBlank @PathVariable(name ="id") Integer id, @Valid @NotNull Employee employee) throws EmployeeNotFoundException {
		employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@Valid @NotBlank @PathVariable(name = "id") Integer id) throws EmployeeNotFoundException {
		employeeService.deleteEmployeeById(id);
	}

	@DeleteMapping("/delete")
	public void deleteEmployee(@Valid Employee employee) throws EmployeeNotFoundException {
		employeeService.deleteEmployee(employee);
	}

}
