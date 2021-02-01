package com.example.employee.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {EmployeeService.class})
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeRepository employeeRepository;

	@Test
	public void testFindById() throws Exception {

		Assertions.assertTrue(employeeService.findEmployeeById(1).isEmpty());

		when(employeeRepository.findById(1)).thenReturn(Optional.of(getEmployee()));

		Employee employee = employeeService.findEmployeeById(1).get();

		Assertions.assertEquals(employee.getId(), 1);
		Assertions.assertEquals(employee.getFirstName(), "Paramasivam");
		Assertions.assertEquals(employee.getLastName(), "Sankar");
		Assertions.assertEquals(employee.getEmail(), "paramsk80@gmail.com");
		Assertions.assertEquals(employee.getPhone(), "6303065552");

	}

	@Test
	public void testsaveEmployee() throws Exception {

		Employee employee = getEmployee();

		when(employeeRepository.save(employee)).thenReturn(employee);

		employeeService.saveEmployee(employee);

		Assertions.assertTrue(true);
	}

	@Test
	public void testUpdateEmployeeNotFoundException() throws Exception {

		Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.updateEmployee(1, getEmployee()));

	}

	@Test
	public void testUpdateEmployeeSuccess() throws Exception {

		when(employeeRepository.findById(1)).thenReturn(Optional.of(getEmployee()));

		employeeService.updateEmployee(1, getEmployee());

		Assertions.assertTrue(true);
	}

	@Test
	public void testDeleteEmployeeByIdEmployeeNotFoundException() throws Exception {

		Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.deleteEmployeeById(1));

	}

	@Test
	public void testDeleteEmployeeByIdSuccess() throws Exception {

		when(employeeRepository.findById(1)).thenReturn(Optional.of(getEmployee()));

		employeeService.deleteEmployeeById(1);

		Assertions.assertTrue(true);
	}

	@Test
	public void testDeleteEmployeeEmployeeNotFoundException() throws Exception {

		Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.deleteEmployee(getEmployee()));

	}

	@Test
	public void testDeleteEmployeeSuccess() throws Exception {

		when(employeeRepository.findById(1)).thenReturn(Optional.of(getEmployee()));

		employeeService.deleteEmployee(getEmployee());

		Assertions.assertTrue(true);
	}

	private Employee getEmployee() {

		Employee employee = new Employee();

		employee.setId(1);
		employee.setFirstName("Paramasivam");
		employee.setLastName("Sankar");
		employee.setEmail("paramsk80@gmail.com");
		employee.setPhone("6303065552");

		return employee;
	}
}
