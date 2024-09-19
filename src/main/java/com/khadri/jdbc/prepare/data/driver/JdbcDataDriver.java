package com.khadri.jdbc.prepare.data.driver;

import java.util.Arrays;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.customer.dao.CustomerInsertDao;
import com.khadri.jdbc.prepare.data.customer.processor.CustomerDataProcessor;
import com.khadri.jdbc.prepare.data.driver.types.DriverTypes;
import com.khadri.jdbc.prepare.data.employee.dao.EmployeeInsertDao;
import com.khadri.jdbc.prepare.data.employee.processor.EmployeeDataProcessor;
import com.khadri.jdbc.prepare.data.mobile.dao.MobileInsertDao;
import com.khadri.jdbc.prepare.data.mobile.processor.MobileDataProcessor;
import com.khadri.jdbc.prepare.data.movie.dao.MovieInsertDao;
import com.khadri.jdbc.prepare.data.movie.processer.MovieDataProcesser;
import com.khadri.jdbc.prepare.data.student.dao.StudentInsertDao;
import com.khadri.jdbc.prepare.data.student.processor.StudentDataProcessor;
import com.khadri.jdbc.prepare.data.supermarket.daos.SuperMarketInsertDao;
import com.khadri.jdbc.prepare.data.supermarket.processor.SuperMarketDataProcessor;

public class JdbcDataDriver {

	private Scanner scanner;
	private EmployeeInsertDao empDao;
	private StudentInsertDao stdDao;
	private CustomerInsertDao custDao;
	private MovieInsertDao movieInsertDao;
	private MobileInsertDao mobileDao;
	private SuperMarketInsertDao superMarketDao;
	{
		scanner = new Scanner(System.in);
		stdDao = new StudentInsertDao();
		empDao = new EmployeeInsertDao();
		mobileDao = new MobileInsertDao();
		custDao = new CustomerInsertDao();
		movieInsertDao = new MovieInsertDao();
		superMarketDao = new SuperMarketInsertDao();
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

			StudentDataProcessor stdProcessor = new StudentDataProcessor(scanner, stdDao);
			int count = 1;

			for (int i = 0; i < recordCount; i++) {
				try {
					stdProcessor.process(count);
					count++;
				} catch (Exception e) {
					System.out.println("Exception occours" + e);
				}
			}
			break;
		case 2:
			System.out.println("How many records do you want to insert ? : ");
			int empCount = scanner.nextInt();
			int rCount = 1;
			EmployeeDataProcessor empProcessor = new EmployeeDataProcessor(scanner, empDao);
			for (int i = 0; i < empCount; i++) {
				try {
					empProcessor.process(rCount);
					rCount++;
				} catch (Exception e) {
					System.out.println("Exception occured" + e);
				}
			}
			break;
		case 3:
			System.out.println("How many records do you want to insert ? : ");
			int custCount = scanner.nextInt();
			CustomerDataProcessor custProcessor = new CustomerDataProcessor(scanner, custDao);
			int rowCount = 1;
			for (int i = 0; i < custCount; i++)
				try {
					custProcessor.process(rowCount);
					rowCount++;
				} catch (Exception e) {
					System.out.println("Exception occours:" + e);
				}
		case 4:

			System.out.println("How many records you want to insert ? : ");
			int recordCount3 = scanner.nextInt();

			SuperMarketDataProcessor superMarketDataProcessor = new SuperMarketDataProcessor(scanner, superMarketDao);
			int marketCount = 1;
			for (int i = 0; i < recordCount3; i++) {
				superMarketDataProcessor.process(marketCount);
				marketCount++;
			}

			break;
		case 5:
			System.out.println("How Many Records you want to insert ? :");
			int movieCount = scanner.nextInt();
			MovieDataProcesser movie = new MovieDataProcesser(scanner, movieInsertDao);
			int record1 = 1;
			for (int i = 0; i < movieCount; i++) {
				try {

					movie.process(dataProcessId);
					record1++;
				} catch (Exception e) {
					System.out.println("Exception occours" + e);
				}
			}
			break;

		case 6:

			System.out.println("How many records do you want to insert ? : ");
			int Count = scanner.nextInt();

			MobileDataProcessor mobileDataProcessor = new MobileDataProcessor(scanner, mobileDao);
			int rowcount = 1;
			for (int i = 0; i < Count; i++) {
				mobileDataProcessor.process(rowcount);

				rowcount++;
			}
		default:
			break;
		}

	}
}
