/**
 * 
 */
package com.example.springboothibernatemysql.dao;

import java.util.List;

import com.example.springboothibernatemysql.modal.EmpDeptDTO;
import com.example.springboothibernatemysql.modal.Employee;

/**
 * @author Mayank
 *
 */
public interface EmployeeDao {
	
	Employee save(Employee employee, Long deptId);
	
	Employee findById(Long id);
	
	void deleteById(Employee employee);
	
	Employee update(Long id, Employee employee);
	
	List<Employee> allEmployees();
	
	List<Employee> allEmployeesWithSalary(Double salary);
	
	List<EmpDeptDTO> empDeptJoin();
	
}
