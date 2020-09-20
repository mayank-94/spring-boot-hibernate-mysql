/**
 * 
 */
package com.example.springboothibernatemysql.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Mayank
 *
 */
@Entity
@Table(name="department_details")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id")
	private Long deptId;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@Column(name = "dept_location")
	private String deptLocation;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JsonIgnore
	private List<Employee> employees = new ArrayList<>();
	
	
	public Department() {
		super();
	}

	public Department(Long deptId, String deptName, String deptLocation, List<Employee> employees) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLocation = deptLocation;
		this.employees = employees;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLocation() {
		return deptLocation;
	}

	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptLocation=" + deptLocation + "]";
	}
	
}
