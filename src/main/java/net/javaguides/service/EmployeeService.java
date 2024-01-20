package net.javaguides.service;

import java.util.List;

import net.javaguides.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public void saveEmploye(Employee employee);
	
	Employee getEmployeeById (long id);
	
	public void deleteEmployeeById(long id);
	
}
