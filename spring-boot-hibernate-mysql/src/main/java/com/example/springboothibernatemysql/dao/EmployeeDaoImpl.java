/**
 * 
 */
package com.example.springboothibernatemysql.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboothibernatemysql.constants.ConstantsException;
import com.example.springboothibernatemysql.exception.EmployeeNotFoundException;
import com.example.springboothibernatemysql.modal.Department;
import com.example.springboothibernatemysql.modal.EmpDeptDTO;
import com.example.springboothibernatemysql.modal.Employee;

/**
 * @author Mayank
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory factory;
	
	private Session getSession() {
		Session session = factory.getCurrentSession();
		if(session == null)
			session = factory.openSession();
		
		return session;
	}
	
	@Override
	public Employee save(Employee employee, Long deptid) {
		Session session = getSession();
		
		Employee savedEmp = new Employee();
		savedEmp.setName(employee.getName());
		savedEmp.setEmail(employee.getEmail());
		savedEmp.setSalary(employee.getSalary());
		savedEmp.setDoj(employee.getDoj());
		
		Department dept = session.find(Department.class, deptid);
		savedEmp.setDepartment(dept);
		
		session.persist(savedEmp);
		return savedEmp;
	}

	@Override
	public Employee findById(Long id) {
		Session session = getSession();
		Employee emp = session.find(Employee.class, id);
		return emp;
	}

	@Override
	public void deleteById(Employee employee) {
		Session session = getSession();
		session.delete(employee);
	}

	@Override
	public Employee update(Long id, Employee employee) {
		Session session = getSession();
		Employee emp = session.find(Employee.class, id);
		if(emp == null)
			throw new EmployeeNotFoundException(ConstantsException.EMPLOYEE_DOES_NOT_EXIST);
		
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setEmail(employee.getEmail());
		emp.setDoj(employee.getDoj());
		session.update(emp);
		return emp;
	}

	@Override
	public List<Employee> allEmployees() {
		Session session = getSession();
		String hql = "From Employee";
		Query<Employee> query = session.createQuery(hql, Employee.class);
		return query.getResultList();
	}

	@Override
	public List<Employee> allEmployeesWithSalary(Double salary) {
		Session session = getSession();
		String hql = "From Employee Where salary > :empSalary";
		Query<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("empSalary", salary);
		return query.getResultList();
	}

	@Override
	public List<EmpDeptDTO> empDeptJoin() {
		Session session = getSession();
		List<EmpDeptDTO> dtoList = new ArrayList<>();
		String hql = "Select e.name, d.deptName, e.email, e.salary From Employee e Left Join "
				+ "e.department d";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		query.list().forEach(object -> {
			EmpDeptDTO dto = new EmpDeptDTO();
			dto.setEmpName((String)object[0]);
			dto.setDeptName((String)object[1]);
			dto.setEmail((String)object[2]);
			dto.setSalary((Double)object[3]);
			dtoList.add(dto);
		});
		
		return dtoList;
	}

}
