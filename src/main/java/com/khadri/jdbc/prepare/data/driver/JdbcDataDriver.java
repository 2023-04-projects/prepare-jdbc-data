package com.khadri.jdbc.prepare.data.driver;

import java.util.Arrays;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.driver.types.DriverTypes;
import com.khadri.jdbc.prepare.data.mobile.dao.MobileInsertDao;
import com.khadri.jdbc.prepare.data.mobile.processor.MobileDataProcessor;
import com.khadri.jdbc.prepare.data.student.dao.StudentInsertDao;
import com.khadri.jdbc.prepare.data.student.processor.StudentDataProcessor;

public class JdbcDataDriver {

	private Scanner scanner;
	private StudentInsertDao studentInsertDao;
	private MobileInsertDao mobileInsertDao;
	{
		scanner = new Scanner(System.in);
		studentInsertDao = new StudentInsertDao();
		mobileInsertDao = new MobileInsertDao();
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

			StudentDataProcessor stdProcessor = new StudentDataProcessor(scanner,studentInsertDao);

			for (int i = 0; i < recordCount; i++) {
				stdProcessor.process(dataProcessId);
			}

			break;

		case 6:

			System.out.println("How many records do you want to insert ? : ");
			int Count = scanner.nextInt();

			MobileDataProcessor mobileDataProcessor = new MobileDataProcessor(scanner,mobileInsertDao);
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
