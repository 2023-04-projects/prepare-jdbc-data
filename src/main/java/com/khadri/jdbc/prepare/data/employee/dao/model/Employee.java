package com.khadri.jdbc.prepare.data.employee.dao.model;

public class Employee {
	public int id;
	public String name;
	public String desigination;
	public double salary;
	public Employee(int id, String name, String desigination, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.desigination = desigination;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDesigination() {
		return desigination;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDesigination(String desigination) {
		this.desigination = desigination;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}