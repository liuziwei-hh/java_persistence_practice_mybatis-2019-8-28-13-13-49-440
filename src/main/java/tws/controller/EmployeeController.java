package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.mapper.EmployeeMapper;
import tws.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	@GetMapping
	public List<Employee> getAllEmployeeInPage(@RequestParam(name = "page", required = false) Integer page,
		      @RequestParam(name = "pageSize", required = false) Integer pageSize) {
		return employeeService.getAllEmployeeInPage(page, pageSize);
	}
	@PutMapping
	public List<Employee> updateEmployee(@RequestBody Employee employee){
		return employeeService.updateEmployee(employee);
	}
	@DeleteMapping
    public void deleteEmployee(@RequestBody Employee employee) {
		employeeService.deleteEmployee(employee);
	}

}
