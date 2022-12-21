package com.emp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String ename;
	private String eposition;
	private String email;
	private Integer salary;

	public Employee(Integer id, String ename, String eposition, String email, Integer salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.eposition = eposition;
		this.email = email;
		this.salary = salary;
	}

	public Employee() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEposition() {
		return eposition;
	}

	public void setEposition(String eposition) {
		this.eposition = eposition;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", eposition=" + eposition + ", email=" + email + ", salary="
				+ salary + "]";
	}
}
