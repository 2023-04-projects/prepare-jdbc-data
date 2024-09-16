package com.khadri.jdbc.prepare.data.driver;

import java.util.Arrays;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.driver.types.DriverTypes;
import com.khadri.jdbc.prepare.data.mobile.dao.MobileInsertDao;
import com.khadri.jdbc.prepare.data.mobile.dao.model.Mobile;
import com.khadri.jdbc.prepare.data.mobile.processor.MobileDataProcessor;
import com.khadri.jdbc.prepare.data.student.dao.StudentInsertDao;
import com.khadri.jdbc.prepare.data.student.processor.StudentDataProcessor;

public class JdbcDataDriver {

	private Scanner scanner;
	private StudentInsertDao insertDao;
	private MobileInsertDao<Mobile> insertDao6;
	{
		scanner = new Scanner(System.in);
		insertDao = new StudentInsertDao();
		insertDao6 = new MobileInsertDao();
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

			System.out.println("How many records you want to insert ? : ");
			int recordCount = scanner.nextInt();

			StudentDataProcessor stdProcessor = new StudentDataProcessor(scanner, insertDao);

			for (int i = 0; i < recordCount; i++) {
				stdProcessor.process(dataProcessId);
			}

			break;

		case 6:

			System.out.println("How many records you want to insert ? : ");
			int Count = scanner.nextInt();

			MobileDataProcessor mbProcessor = new MobileDataProcessor(scanner, insertDao6);
			int rowcount = 1;
			for (int i = 0; i < Count; i++) {
				mbProcessor.process(rowcount);

				rowcount++;
			}
		default:
			break;
		}

	}
}
