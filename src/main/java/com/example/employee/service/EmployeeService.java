package com.example.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Optional<Employee> findEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void updateEmployee(Integer id, Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> employee1 = employeeRepository.findById(id);
		if (employee1.isEmpty()) {
			throw new EmployeeNotFoundException("The employee not found with this id " + id);
		}
		employeeRepository.save(employee);
	}

	public void deleteEmployeeById(Integer id) throws EmployeeNotFoundException {
		Optional<Employee> employee1 = employeeRepository.findById(id);
		if (employee1.isEmpty()) {
			throw new EmployeeNotFoundException("The employee not found with this id " + id);
		}
		employeeRepository.deleteById(id);
	}

	public void deleteEmployee(Employee employee) throws EmployeeNotFoundException {
		Integer id = employee.getId();
		Optional<Employee> employee1 = employeeRepository.findById(id);
		if (employee1.isEmpty()) {
			throw new EmployeeNotFoundException("The employee not found with this id " + id);
		}
		employeeRepository.delete(employee);
	}

}
