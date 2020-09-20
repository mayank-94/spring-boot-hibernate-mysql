/**
 * 
 */
package com.example.springboothibernatemysql.modal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Mayank
 *
 */
@Entity
@Table(name = "employee_details")
@DynamicUpdate
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="salary", nullable = false)
	private Double salary;
	
	@Column(name="date_of_joining")
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date doj;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	@JsonIgnore
	private Department department;
	
	public Employee() {
		super();
	}

	public Employee(String name, String email, Double salary, Date doj) {
		super();
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.doj = doj;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", salary=" + salary
				+ ", doj=" + doj + "]";
	}
	
}
