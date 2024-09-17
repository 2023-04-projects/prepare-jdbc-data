package com.khadri.jdbc.prepare.data.driver;

import java.util.Arrays;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.customer.dao.CustomerInsertDao;
import com.khadri.jdbc.prepare.data.customer.processor.CustomerDataProcessor;
import com.khadri.jdbc.prepare.data.driver.types.DriverTypes;
import com.khadri.jdbc.prepare.data.student.dao.StudentInsertDao;
import com.khadri.jdbc.prepare.data.student.processor.StudentDataProcessor;
import com.khadri.jdbc.prepare.data.supermarket.daos.SuperMarketInsertDao;
import com.khadri.jdbc.prepare.data.supermarket.processor.SuperMarketDataProcessor;

public class JdbcDataDriver {


	private Scanner scanner;
	private StudentInsertDao insertDao;
	private SuperMarketInsertDao superMarketInsertDao;
	{
		scanner = new Scanner(System.in);
		insertDao = new StudentInsertDao();
		superMarketInsertDao = new SuperMarketInsertDao();

	public Scanner scanner;
	public StudentInsertDao stdDao;
	public CustomerInsertDao custDao;
	{
		scanner = new Scanner(System.in);
		stdDao = new StudentInsertDao();
		custDao = new CustomerInsertDao();


	}

	public static void main(String[] args) throws Exception {
		System.out.println("###################### Welocme to Jdbc data Driver  ########################");
		System.out.println("$$$$$$$$$$$$$$ The data procesors $$$$$$$$$$$$$$$$$");

		Arrays.stream(DriverTypes.values()).forEach(each -> {
			System.out.println(each.getId() + " : " + each.getName());
		});

		JdbcDataDriver csvDataDriver = new JdbcDataDriver();

		csvDataDriver.process();
	}

	private void process() throws Exception {
		System.out.println("Please choose the data processor : ");
		int dataProcessId = scanner.nextInt();

		switch (dataProcessId) {
		case 1:

			System.out.println("How many records do you want to insert ? : ");
			int recordCount = scanner.nextInt();


			StudentDataProcessor stdProcessor = new StudentDataProcessor(scanner, insertDao);

			StudentDataProcessor stdProcessor = new StudentDataProcessor(scanner,stdDao);
			int count = 1;

			for (int i = 0; i < recordCount; i++) {
				stdProcessor.process(count);
				count++;
			}
			break;
		case 3:
			System.out.println("How many records do you want to insert ? : ");
			int custCount = scanner.nextInt();


		case 4:

			System.out.println("How many records you want to insert ? : ");
			int recordCount3 = scanner.nextInt();

			SuperMarketDataProcessor superMarketDataProcessor = new SuperMarketDataProcessor(scanner,
					superMarketInsertDao);
			int rowcount =1;
			for (int i = 0; i < recordCount3; i++) {
				superMarketDataProcessor.process(rowcount);
				rowcount++;
			}

			break;


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
