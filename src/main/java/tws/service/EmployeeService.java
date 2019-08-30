package tws.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import net.bytebuddy.asm.Advice.This;
import tws.controller.Employee;
import tws.mapper.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@PostMapping
	public void addEmployee(@RequestBody Employee employee) {
		employeeMapper.insertEmployee(employee);
	}

//	@GetMapping
//	public List<Employee> searchEmployee() {
//		return employeeMapper.searchEmployees();
//	}

	@PutMapping
	public List<Employee> updateEmployee(@RequestBody Employee employee) {
		return employeeMapper.updateEmployee(employee);
	}

	@DeleteMapping
	public void deleteEmployee(@RequestBody Employee employee) {
		employeeMapper.deleteEmployee();
	}

	public EmployeeService() {
	}

	@GetMapping
	public List<Employee> findAllEmployees() {
		List<Employee> employees = employeeMapper.getAllEmployeeInPage();
		for (Employee employee : employees) {
			String name = employee.getName();
			employee.setName("中原银行-" + name);
		}
		return employees;
	}

	@GetMapping
	public List<Employee> getAllEmployeeInPage(@Param(value = "page") Integer page,
			@Param(value = "pageSize") Integer pageSize) {
		List<Employee> allEmployees = this.findAllEmployees();
		int skippedItemCount = (page - 1) * pageSize;

		List<Employee> result = new ArrayList<Employee>();
		for (int index = skippedItemCount; index < findAllEmployees().size(); index++) {
			result.add(allEmployees.get(index));
		}
		return result;
	}

}
