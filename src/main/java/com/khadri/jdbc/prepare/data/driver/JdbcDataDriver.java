package com.khadri.jdbc.prepare.data.driver;

import java.util.Arrays;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.customer.dao.CustomerDao;
import com.khadri.jdbc.prepare.data.customer.processor.CustomerDataProcessor;
import com.khadri.jdbc.prepare.data.driver.types.DriverTypes;
import com.khadri.jdbc.prepare.data.employee.dao.EmployeeDao;
import com.khadri.jdbc.prepare.data.employee.processor.EmployeeDataProcessor;
import com.khadri.jdbc.prepare.data.mobile.dao.MobileDao;
import com.khadri.jdbc.prepare.data.mobile.processor.MobileDataProcessor;
import com.khadri.jdbc.prepare.data.movie.dao.MovieDao;
import com.khadri.jdbc.prepare.data.movie.processer.MovieDataProcesser;
import com.khadri.jdbc.prepare.data.operation.OperationTypes;
import com.khadri.jdbc.prepare.data.supermarket.dao.SuperMarketDao;
import com.khadri.jdbc.prepare.data.supermarket.processor.SuperMarketDataProcessor;

public class JdbcDataDriver {
	private Scanner scanner;

	private CustomerDataProcessor custDataProcessor;
	private EmployeeDao empDao;
	private CustomerDao custDao;
	private MobileDao mobileDao;
	private SuperMarketDao superMarketDao;
	private MovieDataProcesser movieDataProcesser;
	private MovieDao movieDao;
	private EmployeeDataProcessor employeeDataProcessor;
	private SuperMarketDataProcessor superMarketDataProcessor;
	{
		scanner = new Scanner(System.in);
		empDao = new EmployeeDao();
		mobileDao = new MobileDao();
		custDao = new CustomerDao();
		movieDao = new MovieDao();
		superMarketDataProcessor = new SuperMarketDataProcessor(scanner, superMarketDao);
		custDataProcessor = new CustomerDataProcessor(scanner, custDao);
		movieDataProcesser = new MovieDataProcesser(scanner, movieDao);
		employeeDataProcessor = new EmployeeDataProcessor(scanner, empDao);

		superMarketDao = new SuperMarketDao();
		movieDao = new MovieDao();
		custDataProcessor = new CustomerDataProcessor(scanner, custDao);
		movieDataProcesser = new MovieDataProcesser(scanner, movieDao);
		employeeDataProcessor = new EmployeeDataProcessor(scanner, empDao);
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

			Arrays.stream(OperationTypes.values()).forEach(eachOperation -> {
				System.out.println(eachOperation.getOperationType() + " : " + eachOperation.getOperationName());
			});
			System.out.println("Please choose the operation type: ");
			int operationTypeEmployee = scanner.nextInt();

			if (operationTypeEmployee == 1) {
				System.out.println("How Many Records do you want to insert ? :");
				int employeeCount = scanner.nextInt();

				int empCount = 1;
				for (int i = 0; i < employeeCount; i++) {
					employeeDataProcessor.insertProcess(empCount);
					empCount++;
				}

			} else if (operationTypeEmployee == 2) {
				System.out.println("fetching employee records from the database");
				employeeDataProcessor.selectProcess(operationTypeEmployee);

			} else if (operationTypeEmployee == 3) {
				System.out.println("Updating employee records...");
				employeeDataProcessor.updateProcess();

			} else if (operationTypeEmployee == 4) {
				System.out.println("Deleting employee records...");
				employeeDataProcessor.deleteProcess();
			} else {
				System.out.println("Invalid operation type selected.");
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

				int custRowCount = 1;
				for (int i = 0; i < custCount; i++) {
					custDataProcessor.insertProcess(custRowCount);
					custRowCount++;
				}
			} else if (operationTypeCustomer == 2) {
				System.out.println("fetching customer records from the database...");
				custDataProcessor.selectProcess(operationTypeCustomer);
			} else if (operationTypeCustomer == 3) {
				System.out.println("Updating customer records...");
				custDataProcessor.updateProcess();
			} else if (operationTypeCustomer == 4) {
				System.out.println("Deleting customer records...");
				custDataProcessor.deleteProcess();
			} else {
				System.out.println("Invalid operation type selected.");
				 custDataProcessor.selectProcess(operationTypeCustomer);
			}else if (operationTypeCustomer == 3) {  
			    System.out.println("Updating customer records...");
			   custDataProcessor.updateProcess();
			} else if (operationTypeCustomer == 4) {  
			    System.out.println("Deleting customer records...");
			    custDataProcessor.deleteProcess();
			} else {
			    System.out.println("Invalid operation type selected.");
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

				int marketCount = 1;
				for (int i = 0; i < recordCount3; i++) {
					superMarketDataProcessor.insertSuperMarketProcess(marketCount);
					marketCount++;
				}
			} else if (operationTypeSuperMarket == 2) {
				System.out.println("Fetching SuperMarket Database Records ..! ");
				superMarketDataProcessor.selectSuperMarketProcess(operationTypeSuperMarket);

			} else if (operationTypeSuperMarket == 3) {
				System.out.println("Update SuperMarket Record  ..!");
				superMarketDataProcessor.updateSuperMarketProcess();

			} else if (operationTypeSuperMarket == 4) {
				System.out.println("Delete SuperMarket Record Into DataBase ..!");
				superMarketDataProcessor.deleteSuperMarketProcess();

			} else {
				System.out.println("Invalid Operation ..!");
			}

			System.out.println("###### " + DriverTypes.SUPER_MARKET.getName().toUpperCase() + " Processor ends ######");
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
				int recordCount = 1;
				for (int i = 0; i < movieCount; i++) {
					movieDataProcesser.insertProcess(recordCount);
					recordCount++;
				}
			} else if (operationType == 2) {
				System.out.println("freching movie databace records");
				movieDataProcesser.selectProcess(operationType);
			} else if (operationType == 3) {
				System.out.println("updating movie databace records");
				movieDataProcesser.updateProcess();
			} else if (operationType == 4) {
				System.out.println("Delete movie data records");
				movieDataProcesser.deleteProcess();
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
				System.out.println("How Many Records do you want to insert ? :");
				int Count = scanner.nextInt();
				MobileDataProcessor mobileDataProcessor = new MobileDataProcessor(scanner, mobileDao);
				int rowcount = 1;
				for (int i = 0; i < Count; i++) {
					mobileDataProcessor.process(rowcount);
					rowcount++;
				}

				} else if (operationTypeMobile == 2) {
					System.out.println("fetching mobile records from database!!!!");
					mobileDao.SelectData();
				}
			System.out.println("###### " + DriverTypes.MOBILE.getName().toUpperCase() + "Processor ends ######");
			break;
				
		}
	}
}