
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

	public void insertProcess(int recordNumber) {
		try {
			System.out.println(recordNumber + "Record Reading starts");

			System.out.println("Enter Employee Id : ");
			int id = scanner.nextInt();

			System.out.println("Enter Employee Name : ");
			String name = scanner.next();

			System.out.println("Enter Employee Desigination : ");
			String desigination = scanner.next();

			System.out.println("Enter Employee Salary :");
			Double salary = scanner.nextDouble();

			Employee emp = new Employee(id, name, desigination, salary);

			empDao.insertEmployeeData(emp);
		} catch (Exception e) {
			System.out.println("EmployeeDataProssor Exception Occour" + e);
		}

	}
	public void selectProcess(int recordNumber) {
		try {
			System.out.println(recordNumber + " Record Reading starts");
			empDao.selectEmployeeData();
			System.out.println(recordNumber + " Record Reading ends ");
		} catch (Exception e) {
			System.out.println("EmployeeDataProcesser Exception occours" + e);
		}
	}

	
	public void updateProcess() {

		try {
			System.out.println("Enter employee id to update: ");
			int id = scanner.nextInt();

			System.out.println("Enter new employee name: ");
			String name = scanner.next();

			System.out.println("Enter new employee desigination: ");
			String desigination = scanner.next();

			System.out.println("Enter new employee salary: ");
			Double salary = scanner.nextDouble();

			Employee emp = new Employee(id, name, desigination, salary);

			boolean isUpdated = empDao.employeeUpdateData(emp);

			if (isUpdated) {
				System.out.println("employee updated successfully.");
			} else {
				System.out.println("employee update failed.");
			}
		} catch (Exception e) {
			System.out.println("UpdateProcessor Exception occurs: " + e);
		}
	}


	public void deleteProcess() {
		try {
			System.out.println("Enter employee id to delete: ");
			int id = scanner.nextInt();

			boolean isDeleted = empDao.employeeDeleteData(id);

			if (isDeleted) {
				System.out.println("employee deleted successfully.");
			} else {
				System.out.println("employee delete failed.");
			}
		} catch (Exception e) {
			System.out.println("DeleteProcessor Exception occurs: " + e);
		}
	}
}


