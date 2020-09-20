/**
 * 
 */
package com.example.springboothibernatemysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboothibernatemysql.dao.EmployeeDao;
import com.example.springboothibernatemysql.modal.EmpDeptDTO;
import com.example.springboothibernatemysql.modal.Employee;

/**
 * @author Mayank
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee save(Employee employee, Long deptId) {
		return employeeDao.save(employee, deptId);
	}

	@Override
	public Employee findById(Long id) {
		return employeeDao.findById(id);
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.deleteById(employee);
	}

	@Override
	public Employee update(Long id, Employee employee) {
		return employeeDao.update(id, employee);
	}

	@Override
	public List<Employee> allEmployees() {
		return employeeDao.allEmployees();
	}

	@Override
	public List<Employee> allEmployeesWithSalary(Double salary) {
		return employeeDao.allEmployeesWithSalary(salary);
	}

	@Override
	public List<EmpDeptDTO> empDeptJoin() {
		return employeeDao.empDeptJoin();
	}

}
