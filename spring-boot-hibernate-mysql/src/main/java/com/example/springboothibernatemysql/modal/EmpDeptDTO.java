/**
 * 
 */
package com.example.springboothibernatemysql.modal;

/**
 * @author Mayank
 *
 */
public class EmpDeptDTO {

	private String empName;
	private String deptName;
	private String email;
	private Double salary;
	
	public EmpDeptDTO() {
		super();
	}
	
	public EmpDeptDTO(String empName, String deptName, String email, Double salary) {
		super();
		this.empName = empName;
		this.deptName = deptName;
		this.email = email;
		this.salary = salary;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
	
	@Override
	public String toString() {
		return "EmpDeptDTO [empName=" + empName + ", deptName=" + deptName + ", email=" + email + ", salary=" + salary
				+ "]";
	}
	
}
