/**
 * 
 */
package com.example.springboothibernatemysql.service;

import java.util.List;

import com.example.springboothibernatemysql.modal.EmpDeptDTO;
import com.example.springboothibernatemysql.modal.Employee;

/**
 * @author Mayank
 *
 */
public interface EmployeeService {
	
	Employee save(Employee employee, Long deptId);
	
	Employee findById(Long id);
	
	void delete(Employee employee);
	
	Employee update(Long id, Employee employee);
	
	List<Employee> allEmployees();
	
	List<Employee> allEmployeesWithSalary(Double salary);
	
	List<EmpDeptDTO> empDeptJoin();
	
}
