package com.khadri.jdbc.prepare.data.driver;

import java.util.Arrays;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.driver.types.DriverTypes;
import com.khadri.jdbc.prepare.data.employee.dao.EmployeeInsertDao;
import com.khadri.jdbc.prepare.data.employee.processor.EmployeeDataProcessor;
import com.khadri.jdbc.prepare.data.student.dao.StudentInsertDao;
import com.khadri.jdbc.prepare.data.student.processor.StudentDataProcessor;

public class JdbcDataDriver {

	private Scanner scanner;
	private StudentInsertDao insertDao;
	private EmployeeInsertDao insertDao1;
	{
		scanner = new Scanner(System.in);
		insertDao = new StudentInsertDao();
		insertDao1= new EmployeeInsertDao();
	}

	
	public static void main(String[] args)throws Exception {
		System.out.println("###################### Welocme to Jdbc data Driver  ########################");
		System.out.println("$$$$$$$$$$$$$$ The data procesors $$$$$$$$$$$$$$$$$");

		Arrays.stream(DriverTypes.values()).forEach(each -> {
			System.out.println(each.getId() + " : " + each.getName());
		});

		JdbcDataDriver csvDataDriver = new JdbcDataDriver();
		csvDataDriver.process();
	}

	private void process() throws Exception{
		System.out.println("Please choose the data processor : ");
		int dataProcessId = scanner.nextInt();

		switch (dataProcessId) {
		case 1:

			System.out.println("How many records you want to insert ? : ");
			int recordCount = scanner.nextInt();

			StudentDataProcessor stdProcessor = new StudentDataProcessor(scanner,insertDao);

			for (int i = 0; i < recordCount; i++) {
				stdProcessor.process(dataProcessId);
			}

			break;
		case 2:
			System.out.println("How many records you want to insert ? : ");
			int recordCount1 = scanner.nextInt();
            EmployeeDataProcessor empProcessor= new EmployeeDataProcessor(scanner, insertDao1);
			for (int i = 0; i < recordCount1; i++) {
				empProcessor.process(dataProcessId);
			}
			
			break;

		default:
			break;

		}

	}
}
