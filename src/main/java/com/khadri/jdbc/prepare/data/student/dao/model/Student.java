package com.khadri.jdbc.prepare.data.student.dao.model;

public class Student {

	private int id;
	private String name;
	private int subMarks1;
	private int subMarks2;
	private int subMarks3;
	private int totalMarks;
	private double avg;
	private char grade;

	public Student(int id, String name, int subMarks1, int subMarks2, int subMarks3, int totalMarks, double avg,
			char grade) {
		super();
		this.id = id;
		this.name = name;
		this.subMarks1 = subMarks1;
		this.subMarks2 = subMarks2;
		this.subMarks3 = subMarks3;
		this.totalMarks = totalMarks;
		this.avg = avg;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSubMarks1() {
		return subMarks1;
	}

	public int getSubMarks2() {
		return subMarks2;
	}

	public int getSubMarks3() {
		return subMarks3;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public double getAvg() {
		return avg;
	}

	public char getGrade() {
		return grade;
	}

}
