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
import com.khadri.jdbc.prepare.data.operation.OperationTypes;
import com.khadri.jdbc.prepare.data.supermarket.daos.SuperMarketDao;

public class JdbcDataDriver {

	private Scanner scanner;
	private EmployeeInsertDao empDao;
	private CustomerInsertDao custDao;
	private MovieInsertDao movieDao;
	private MobileInsertDao mobileDao;
	private SuperMarketDao superMarketDao;

	{
		scanner = new Scanner(System.in);
		empDao = new EmployeeInsertDao();
		mobileDao = new MobileInsertDao();
		custDao = new CustomerInsertDao();
		movieDao = new MovieInsertDao();
		superMarketDao = new SuperMarketDao();
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

		case 2:
			System.out.println("How many records do you want to insert ? : ");
			int empCount = scanner.nextInt();

			int empRowCount = 1;
			EmployeeDataProcessor empProcessor = new EmployeeDataProcessor(scanner, empDao);
			for (int i = 0; i < empCount; i++) {
				empProcessor.process(empRowCount);
				empRowCount++;
			}
			break;
		case 3:
			System.out.println("How many records do you want to insert ? : ");
			int custCount = scanner.nextInt();

			CustomerDataProcessor custProcessor = new CustomerDataProcessor(scanner, custDao);
			int custRowCount = 1;
			for (int i = 0; i < custCount; i++) {
				custProcessor.process(custRowCount);
				custRowCount++;
			}
		case 4:

			System.out
					.println("###### " + DriverTypes.SUPER_MARKET.getName().toUpperCase() + " Processor Starts ######");
			Arrays.stream(OperationTypes.values()).forEach(eachOperation -> {
				System.out.println(eachOperation.getOperationType() + " : " + eachOperation.getOperationName());
			});

			System.out.println("Please choose the operation type: ");
			int superMarketOperationType = scanner.nextInt();

			if (superMarketOperationType == 1) {

				System.out.println("How Many Records Do You Want To Insert ? :");
				int superMarketCount = scanner.nextInt();

				MovieDataProcesser movie = new MovieDataProcesser(scanner, movieDao);
				int recordCount = 1;
				for (int i = 0; i < superMarketCount; i++) {
					movie.process(recordCount);
					recordCount++;
				}

			} else if (superMarketOperationType == 2) {

				System.out.println("Fetching SuperMarket DataBase records");
				superMarketDao.selectSuperMarketData();
			}

			System.out.println("###### " + DriverTypes.MOVIE.getName().toUpperCase() + " Processor ends ######");
			break;

		case 5:

			System.out.println("###### " + DriverTypes.MOVIE.getName().toUpperCase() + " Processor Starts ######");

			Arrays.stream(OperationTypes.values()).forEach(eachOperation -> {
				System.out.println(eachOperation.getOperationType() + " : " + eachOperation.getOperationName());
			});

			System.out.println("Please choose the operation type: ");
			int operationType = scanner.nextInt();

			if (operationType == 1) {

				System.out.println("How Many Records you want to insert ? :");
				int movieCount = scanner.nextInt();

				MovieDataProcesser movie = new MovieDataProcesser(scanner, movieDao);
				int recordCount = 1;
				for (int i = 0; i < movieCount; i++) {
					movie.process(recordCount);
					recordCount++;
				}

			} else if (operationType == 2) {

			}

			System.out.println("###### " + DriverTypes.MOVIE.getName().toUpperCase() + " Processor ends ######");
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
