
package com.khadri.jdbc.prepare.data.employee.processor;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.employee.dao.EmployeeDao;
import com.khadri.jdbc.prepare.data.employee.dao.model.Employee;

public class EmployeeDataProcessor {
	public Scanner scanner;
	public EmployeeDao empDao;

	public EmployeeDataProcessor(Scanner scanner, EmployeeDao empDao) {
		this.scanner = scanner;
		this.empDao = empDao;
	}

	public void process(int recordNumber) {
		try {
		System.out.println(recordNumber +"record reading starts ");
		System.out.println("Enter Employee Id : ");
		int id = scanner.nextInt();

		System.out.println("Enter Employee Name : ");
		String name = scanner.next();

		System.out.println("Enter Employee Desigination : ");
		String desigination = scanner.next();

		System.out.println("Enter Employee Salary :");
		Double salary = scanner.nextDouble();

		Employee emp = new Employee(id, name, desigination, salary);
		
	  empDao.insertData(emp);
		}catch(Exception e) {
			System.out.println(" EmployeeDataProcessor Exception occurs"+e);
		}
	}
}
