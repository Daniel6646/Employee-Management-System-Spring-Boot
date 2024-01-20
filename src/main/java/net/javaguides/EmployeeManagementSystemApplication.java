package net.javaguides;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.model.Employee;
import net.javaguides.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagementSystemApplication  {

	//implements CommandLineRunner
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		Employee employee = new Employee(0, "danny", "quadras", "danny@gmail.com");
//		employeeRepository.save(employee);
//		
//	}

}
