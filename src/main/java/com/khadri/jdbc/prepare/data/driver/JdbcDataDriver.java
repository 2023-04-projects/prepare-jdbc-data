package com.khadri.jdbc.prepare.data.driver;

import java.util.Arrays;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.customer.dao.CustomerDao;
import com.khadri.jdbc.prepare.data.customer.processor.CustomerDataProcessor;
import com.khadri.jdbc.prepare.data.driver.types.DriverTypes;
import com.khadri.jdbc.prepare.data.employee.dao.EmployeeDao;
import com.khadri.jdbc.prepare.data.employee.processor.EmployeeDataProcessor;
import com.khadri.jdbc.prepare.data.mobile.dao.MobileInsertDao;
import com.khadri.jdbc.prepare.data.mobile.processor.MobileDataProcessor;
import com.khadri.jdbc.prepare.data.movie.dao.MovieDao;
import com.khadri.jdbc.prepare.data.movie.processer.MovieDataProcesser;
import com.khadri.jdbc.prepare.data.operation.OperationTypes;
import com.khadri.jdbc.prepare.data.supermarket.dao.SuperMarketInsertDao;
import com.khadri.jdbc.prepare.data.supermarket.processor.SuperMarketDataProcessor;

public class JdbcDataDriver {

	private Scanner scanner;


	private EmployeeDao empDao;

	

	private CustomerDao custDao;

	private MovieDao movieDao;
	private MobileDao mobileDao;
	private SuperMarketDao superMarketDao;

	{
		scanner = new Scanner(System.in);
		empDao = new EmployeeDao();
		mobileDao = new MobileInsertDao();
		custDao = new CustomerDao();
		movieDao = new MovieDao();
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

		case 1:


			System.out.println("###### " + DriverTypes.EMPLOYEE.getName().toUpperCase() + " Processor Starts ######");


			System.out.println("##### " + DriverTypes.EMPLOYEE.getName().toUpperCase() + "Processor Starts #####");


			Arrays.stream(OperationTypes.values()).forEach(eachOperation -> {
				System.out.println(eachOperation.getOperationType() + " : " + eachOperation.getOperationName());
			});
			System.out.println("Please choose the operation type: ");
			int operationTypeEmployee = scanner.nextInt();

			if (operationTypeEmployee == 1) {

				System.out.println("How Many Records do you want to insert ? :");
				int employeeCount = scanner.nextInt();

				EmployeeDataProcessor emp = new EmployeeDataProcessor(scanner, empDao);
				int empCount = 1;
				for (int i = 0; i < employeeCount; i++) {
					emp.process(empCount);
					empCount++;
				}


				System.out.println(employeeCount + "records inserted sucessfully");

				System.out.println(employeeCount +"records inserted sucessfully");


				System.out.println(employeeCount + "records inserted sucessfully");

			} else if (operationTypeEmployee == 2) {
				System.out.println("fetching employee records from the database");
				empDao.employeeSelectData();
			}
			System.out.println("###### " + DriverTypes.EMPLOYEE.getName().toUpperCase() + " Processor ends ######");

			break;

		case 2:
			System.out.println("##### " + DriverTypes.CUSTOMER.getName().toUpperCase() + "Processor Starts #####");
			Arrays.stream(OperationTypes.values()).forEach(eachOperation -> {
				System.out.println(eachOperation.getOperationType() + " : " + eachOperation.getOperationName());
			});
			System.out.println("Please choose the Operation type :");
			int operationTypeCustomer = scanner.nextInt();
			if (operationTypeCustomer == 1) {

				System.out.println("How many records do you want to insert ? : ");
				int custCount = scanner.nextInt();

				CustomerDataProcessor custProcessor = new CustomerDataProcessor(scanner, custDao);
				int custRowCount = 1;
				for (int i = 0; i < custCount; i++) {
					custProcessor.process(custRowCount);
					custRowCount++;
				}
			} else if (operationTypeCustomer == 2) {
				System.out.println("fetching customer records from the database...");
				custDao.customerSelectData();
			}

			System.out.println("###### " + DriverTypes.CUSTOMER.getName().toUpperCase() + " Processor ends ######");
			break;

		case 3:
			System.out.println("#### " + DriverTypes.SUPER_MARKET.getName().toUpperCase() + " Processor Starts #####");
			Arrays.stream(OperationTypes.values()).forEach(eachOperation -> {
				System.out.println(eachOperation.getOperationType() + " : " + eachOperation.getOperationName());
			});
			System.out.println("Please choose the Operation type: ");
			int operationTypeSuperMarket = scanner.nextInt();
			if (operationTypeSuperMarket == 1) {

				System.out.println("How many records do you want to insert ? : ");
				int recordCount3 = scanner.nextInt();

				SuperMarketDataProcessor superMarketDataProcessor = new SuperMarketDataProcessor(scanner,
						superMarketDao);
				int marketCount = 1;
				for (int i = 0; i < recordCount3; i++) {
					superMarketDataProcessor.process(marketCount);
					marketCount++;
				}
			} else if (operationTypeSuperMarket == 2) {

			}
			System.out.println("###### " + DriverTypes.SUPER_MARKET.getName().toUpperCase() + "processor ends #######");

			break;
		case 4:

			System.out.println("###### " + DriverTypes.MOVIE.getName().toUpperCase() + " Processor Starts ######");

			Arrays.stream(OperationTypes.values()).forEach(eachOperation -> {
				System.out.println(eachOperation.getOperationType() + " : " + eachOperation.getOperationName());
			});

			System.out.println("Please choose the operation type: ");
			int operationType = scanner.nextInt();

			if (operationType == 1) {

				System.out.println("How Many Records do you want to insert ? :");
				int movieCount = scanner.nextInt();

				MovieDataProcesser movie = new MovieDataProcesser(scanner, movieDao);
				int recordCount = 1;
				for (int i = 0; i < movieCount; i++) {
					movie.process(recordCount);
					recordCount++;
				}

			} else if (operationType == 2) {
				System.out.println("freching movie databace records");
				movieDao.movieSelectData();
			}

			System.out.println("###### " + DriverTypes.MOVIE.getName().toUpperCase() + " Processor ends ######");
			break;

		case 5:

			System.out.println("##### " + DriverTypes.MOBILE.getName().toUpperCase() + "Processor Starts  ######");
			Arrays.stream(OperationTypes.values()).forEach(eachOperation -> {
				System.out.println(eachOperation.getOperationType() + " : " + eachOperation.getOperationName());
			});

			System.out.println("Please choose the operation type: ");
			int operationTypeMobile = scanner.nextInt();

			if (operationTypeMobile == 1) {

				System.out.println("##### " + DriverTypes.MOBILE.getName().toUpperCase() + "Processor Starts  ######");
				Arrays.stream(OperationTypes.values()).forEach(eachOperation -> {
					System.out.println(eachOperation.getOperationType() + " : " + eachOperation.getOperationName());
				});

				System.out.println("Please choose the operation type: ");
				int operationTypeMobiles = scanner.nextInt();

				if (operationTypeMobile == 1) {

					System.out.println("How many records do you want to insert ? : ");
					int Count = scanner.nextInt();

					MobileDataProcessor mobileDataProcessor = new MobileDataProcessor(scanner, mobileDao);
					int rowcount = 1;
					for (int i = 0; i < Count; i++) {
						mobileDataProcessor.process(rowcount);
						rowcount++;
					}
				} else if (operationTypeMobile == 2) {
					System.out.println("fetching mobile records from database!!!!");
					mobileDao.mobileSelectData();
				}

				System.out.println("How many records do you want to insert ? : ");
				int Count = scanner.nextInt();

				MobileDataProcessor mobileDataProcessor = new MobileDataProcessor(scanner, mobileDao);
				int rowcount = 1;
				for (int i = 0; i < Count; i++) {
					mobileDataProcessor.process(rowcount);
					rowcount++;
				}
			} else if (operationTypeMobile == 2) {

			}
			System.out.println("###### " + DriverTypes.MOBILE.getName().toUpperCase() + "Processor ends ######");
		default:

			break;

		}
	}
}
