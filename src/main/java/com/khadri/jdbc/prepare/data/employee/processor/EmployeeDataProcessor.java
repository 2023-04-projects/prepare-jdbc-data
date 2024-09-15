
package com.khadri.jdbc.prepare.data.employee.processor;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.employee.dao.EmployeeInsertDao;
import com.khadri.jdbc.prepare.data.employee.dao.model.Employee;

public class EmployeeDataProcessor {
	    private Scanner scanner;
		private EmployeeInsertDao insertDao1;
		boolean decision=false;

		public EmployeeDataProcessor(Scanner scanner,EmployeeInsertDao insertDao1) {
			this.scanner = scanner;
			this.insertDao1 = insertDao1;
		}

		public void process( int recordNumber) throws Exception{
			System.out.println("Enter Employee Id : ");
			int id = scanner.nextInt();

			System.out.println("Enter Employee Name : ");
			String name = scanner.next();

			System.out.println("Enter Employee Desigination : ");
			String desigination = scanner.next();

			System.out.println("Enter Employee Salary :");
			Double salary = scanner.nextDouble();
			
			Employee emp=new Employee(id, name, desigination, salary);
			EmployeeInsertDao insertDao1= new EmployeeInsertDao();
			
			insertDao1.insertData(emp);



		}

	}
