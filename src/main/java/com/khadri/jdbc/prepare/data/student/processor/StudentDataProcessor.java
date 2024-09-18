package com.khadri.jdbc.prepare.data.student.processor;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.student.dao.StudentInsertDao;
import com.khadri.jdbc.prepare.data.student.dao.model.Student;

public class StudentDataProcessor {

	private Scanner scanner;

	private StudentInsertDao studentInsertDao;

	public StudentDataProcessor(Scanner scanner, StudentInsertDao studentInsertDao) {
		this.scanner = scanner;
		this.studentInsertDao = studentInsertDao;
	}

	public void process(int recordNumber) {

		System.out.println("Enter Student Id : ");
		int id = scanner.nextInt();

		System.out.println("Enter Student Name : ");
		String name = scanner.next();

		System.out.println("Enter Student Subject1 Marks : ");
		int subMarks1 = scanner.nextInt();

		System.out.println("Enter Student Subject2 Marks : ");
		int subMarks2 = scanner.nextInt();

		System.out.println("Enter Student Subject3 Marks : ");
		int subMarks3 = scanner.nextInt();

		System.out.println("Processing Student Total Marks");
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
		int totalMarks = subMarks1 + subMarks2 + subMarks3;
		System.out.println(" : " + totalMarks);

		System.out.println("Processing Student Avg Marks");
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}

		double avg = totalMarks / 3;
		System.out.println(" : " + avg);

		System.out.println("Processing Student Grade ");
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
		char grade = processGrade(avg);
		System.out.println(" : " + grade);
		System.out.println("Processing  JDBC database Wrting ");

		Student std = new Student(id, name, subMarks1, subMarks2, subMarks3, totalMarks, avg, grade);
		studentInsertDao.insertData(std);

		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
		System.out.println();

	}

	private char processGrade(double avg) {

		if (avg >= 90 && avg <= 100) {
			return 'A';
		} else if (avg >= 75 && avg <= 89) {
			return 'B';
		} else if (avg >= 60 && avg <= 74) {
			return 'C';
		} else if (avg >= 45 && avg <= 59) {
			return 'D';
		} else if (avg >= 35 && avg <= 44) {
			return 'P';
		} else {
			return 'F';
		}
	}

}
