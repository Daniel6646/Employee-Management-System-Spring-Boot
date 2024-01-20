package net.javaguides.ServiceImpl;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.model.Employee;
import net.javaguides.repository.EmployeeRepository;
import net.javaguides.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public void saveEmploye(Employee employee) {

		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {

		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;

		if (optional.isPresent()) {

			employee = optional.get();
		}

		else {

			throw new RuntimeException("Employe not found for id ::::" + id);
		}

		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {

		employeeRepository.deleteById(id);
	}

}
