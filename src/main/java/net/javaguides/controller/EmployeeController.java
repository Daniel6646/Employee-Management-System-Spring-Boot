package net.javaguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.model.Employee;
import net.javaguides.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		model.addAttribute("listEmployee", employeeService.getAllEmployees());
		
		return "index";
		
	}
	
	
	@GetMapping("/newEmployeeForm")
	public String showEmployeeForm(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "new_employee" ;
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee (@ModelAttribute("employee")Employee employee) 
	{
		
		employeeService.saveEmploye(employee);
		
		return "redirect:/"; //   redirect to / above / will show homepage
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate (@PathVariable long id, Model model) {
		
		Employee employee =  employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		
		return "update_employee";
		
	}

	
	@GetMapping ("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable long id) {
		
		employeeService.deleteEmployeeById(id);
		
		return "redirect:/";
		
	}
	
}

