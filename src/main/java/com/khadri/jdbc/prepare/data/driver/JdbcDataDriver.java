package com.khadri.jdbc.prepare.data.driver;

import java.util.Arrays;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.customer.dao.CustomerInsertDao;
import com.khadri.jdbc.prepare.data.customer.processor.CustomerDataProcessor;
import com.khadri.jdbc.prepare.data.driver.types.DriverTypes;
import com.khadri.jdbc.prepare.data.student.dao.StudentInsertDao;
import com.khadri.jdbc.prepare.data.student.processor.StudentDataProcessor;

public class JdbcDataDriver {

	public Scanner scanner;
	public StudentInsertDao insertDao;
	public CustomerInsertDao custDao;
	{
		scanner = new Scanner(System.in);
		insertDao = new StudentInsertDao();
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

			StudentDataProcessor stdProcessor = new StudentDataProcessor(scanner, insertDao);

			for (int i = 0; i < recordCount; i++) {
				stdProcessor.process(dataProcessId);
			}
			break;
		case 3:
			System.out.println("How many records do you want to insert ? : ");
			int count = scanner.nextInt();

			CustomerDataProcessor custProcessor = new CustomerDataProcessor(scanner, custDao);
			int rowCount = 1;
			for (int i = 0; i < count; i++)
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
