/**
 * 
 */
package com.example.springboothibernatemysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboothibernatemysql.constants.ConstantsException;
import com.example.springboothibernatemysql.exception.EmployeeNotFoundException;
import com.example.springboothibernatemysql.modal.EmpDeptDTO;
import com.example.springboothibernatemysql.modal.Employee;
import com.example.springboothibernatemysql.service.EmployeeService;

/**
 * @author Mayank
 *
 */
@RestController
@RequestMapping(path = {"/api/"})
public class Resource{
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@PostMapping(path = "employees/department/{deptId}")
	public ResponseEntity<Employee> saveEmployee(@PathVariable Long deptId, @RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.save(employee, deptId), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "employees/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable Long id){
		
		Employee employee = employeeService.findById(id);
		if(employee != null)
			return new ResponseEntity<Employee>(employeeService.findById(id), HttpStatus.OK);
		
		else
			throw new EmployeeNotFoundException(ConstantsException.EMPLOYEE_DOES_NOT_EXIST);
	}
	
	@DeleteMapping(path = "employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeService.findById(id);
		if(employee == null)
			throw new EmployeeNotFoundException(ConstantsException.EMPLOYEE_DOES_NOT_EXIST);
		
		employeeService.delete(employee);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(path = "employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp){
		Employee newEmployee = employeeService.update(id, emp);
		return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
	}
	
	@GetMapping(path = "employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.allEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping(path = "employees/withGreater/{salary}")
	public ResponseEntity<List<Employee>> getEmployeesWithSalaryGreater(@PathVariable Double salary){
		List<Employee> employees = employeeService.allEmployeesWithSalary(salary);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping(path = "employees/deptJoin")
	public ResponseEntity<List<EmpDeptDTO>> getEmployeeDept(){
		List<EmpDeptDTO> list = employeeService.empDeptJoin();
		return new ResponseEntity<List<EmpDeptDTO>>(list, HttpStatus.OK);
	}
	
}
