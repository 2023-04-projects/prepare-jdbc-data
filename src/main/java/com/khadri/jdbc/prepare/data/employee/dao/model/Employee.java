package com.khadri.jdbc.prepare.data.employee.dao.model;

public class Employee {
	private int Id;
	private String Name;
	private String Desigination;
	private double Salary;
	public Employee(int id, String name, String desigination, double salary) {
		super();
		this.Id = id;
		this.Name = name;
		this.Desigination = desigination;
		this.Salary = salary;
	}
	public int getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public String getDesigination() {
		return Desigination;
	}
	public double getSalary() {
		return Salary;
	}
	
	

}
