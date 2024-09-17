package com.khadri.jdbc.prepare.data.driver;

import java.util.Arrays;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.customer.dao.CustomerInsertDao;
import com.khadri.jdbc.prepare.data.customer.processor.CustomerDataProcessor;
import com.khadri.jdbc.prepare.data.driver.types.DriverTypes;
import com.khadri.jdbc.prepare.data.employee.dao.EmployeeInsertDao;
import com.khadri.jdbc.prepare.data.employee.processor.EmployeeDataProcessor;
import com.khadri.jdbc.prepare.data.student.dao.StudentInsertDao;
import com.khadri.jdbc.prepare.data.student.processor.StudentDataProcessor;

public class JdbcDataDriver {

	public Scanner scanner;
	public StudentInsertDao stdDao;
	public EmployeeInsertDao empDao;
	public CustomerInsertDao custDao;
	{
		scanner = new Scanner(System.in);
		stdDao = new StudentInsertDao();
		empDao= new EmployeeInsertDao();
		custDao = new CustomerInsertDao();
	}
	public static void main(String[] args) {
		System.out.println("###################### Welocme to Jdbc data Driver  ########################");
		System.out.println("$$$$$$$$$$$$$$ The data procesors $$$$$$$$$$$$$$$$$");

		Arrays.stream(DriverTypes.values()).forEach(each -> {
		System.out.println(each.getId() + " : " + each.getName());
		});

		JdbcDataDriver csvDataDriver = new JdbcDataDriver();

		csvDataDriver.process();
	}

	private void process() {
		System.out.println("Please choose the data processor : ");
		int dataProcessId = scanner.nextInt();

		switch (dataProcessId) {
		case 1:

			System.out.println("How many records do you want to insert ? : ");
			int recordCount = scanner.nextInt();

			StudentDataProcessor stdProcessor = new StudentDataProcessor(scanner,stdDao);
			int count = 1;
			for (int i = 0; i < recordCount; i++) {
				stdProcessor.process(count);
				count++;
			}
			break;
		case 2:
			System.out.println("How many records do you want to insert ? : ");
			int empCount=scanner.nextInt();
			int rCount =1;
            EmployeeDataProcessor empProcessor= new EmployeeDataProcessor(scanner,empDao);
			for (int i = 0; i < empCount; i++) {
				try {
					empProcessor.process(rCount);
					rCount++;
				} catch (Exception e) {
					System.out.println("Exception occured"+e);
				}
			}
			break;
		case 3:
			System.out.println("How many records do you want to insert ? : ");
			int custCount = scanner.nextInt();

			CustomerDataProcessor custProcessor = new CustomerDataProcessor(scanner,custDao);
			int rowCount = 1;
			for (int i = 0; i < custCount; i++)
				try {
					custProcessor.process(rowCount);
					rowCount++;
				} catch (Exception e) {
					System.out.println("Exception occours:" + e);
				}
			break;
		default:
			break;
		}
	}
}
