
package com.khadri.jdbc.prepare.data.employee.processor;

import java.util.List;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.employee.dao.EmployeeDao;
import com.khadri.jdbc.prepare.data.employee.dao.model.Employee;

public class EmployeeDataProcessor {
	public Scanner scanner;
	public EmployeeDao empDao;

	{
		this.empDao = new EmployeeDao();
	}

	public EmployeeDataProcessor(Scanner scanner) {
		this.scanner = scanner;
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

			int result =empDao.insertEmployeeData(emp);
			if (result == 1) {
				System.out.println(result + " Record Inserted..");
			}
		} catch (Exception e) {
			System.out.println("EmployeeDataProssor Exception Occour" + e);
		}
		
	}

	public void selectProcess() {
		try {
			System.out.println("Reading starts");
			List<Employee> listOfEmployees = empDao.selectEmployeeData();

			listOfEmployees.stream().forEach(eachEmployee -> {
				System.out.println(eachEmployee.getId() + " " + eachEmployee.getName() + " "
						+ eachEmployee.getDesigination() + " " + eachEmployee.getSalary());
			});
		} catch (Exception e) {
			System.out.println("EmployeeDataProcesser Exception occours" + e);
		}
	 finally {
		System.out.println("Reading ends ");
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

		int	isUpdated = empDao.employeeUpdateData(emp);

			if (isUpdated==1) {
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

			int isDeleted = empDao.employeeDeleteData(id);

			if (isDeleted==1) {
				System.out.println("employee deleted successfully.");
			} else {
				System.out.println("employee delete failed.");
			}
		} catch (Exception e) {
			System.out.println("DeleteProcessor Exception occurs: " + e);
		}
	}
}
