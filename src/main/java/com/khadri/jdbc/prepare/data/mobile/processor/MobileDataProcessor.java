package com.khadri.jdbc.prepare.data.mobile.processor;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.mobile.dao.MobileInsertDao;
import com.khadri.jdbc.prepare.data.mobile.dao.model.Mobile;

public class MobileDataProcessor {

	private Scanner sc;

	private MobileInsertDao<Mobile> insertDao6;

	public MobileDataProcessor(Scanner sc, MobileInsertDao<Mobile> insertDao6) {
		this.sc = sc;
		this.insertDao6 = insertDao6;
	}

	public void process(int recordNumber) throws Exception {

		// System.out.println("===========> MOBILE " + recordNumber + " DATA READING
		// STARTS ===========>");
		System.out.println("Enter MOBILE_ID : ");
		int id = sc.nextInt();

		System.out.println("Enter MOBILE_NAME : ");
		String name = sc.next();

		System.out.println("Enter RAM : ");
		int ram = sc.nextInt();

		System.out.println("Enter ROM : ");
		int rom = sc.nextInt();

		System.out.println("Enter CAMERA : ");
		String camera = sc.next();

		System.out.println("Enter BATTERY_CAPACITY : ");
		int battery = sc.nextInt();

		System.out.println("Enter PRICE : ");
		int price = sc.nextInt();

		// System.out.println("Processing MOBILE DATA");

		// System.out.println("Processing MOBILE DETAILS");

		// System.out.println("<=========== MOBILE " + recordNumber + " DATA READING
		// ENDS <===========");

		// System.out.println("===========> MOBILE" + recordNumber + " DATA WRITING
		// INTO // JDBC File STARTS ===========>"); //
		System.out.println("Processing File Wrting ");

		// System.out.println(); // System.out.println("<=========== MOBILE " +
		// recordNumber + " DATA WRITING // INTO JDBC File ENDS <===========");

		Mobile mb = new Mobile(id, name, ram, rom, camera, battery, price);

		MobileInsertDao insertDao6 = new MobileInsertDao();

		MobileInsertDao.insertData(mb);

	}

}
