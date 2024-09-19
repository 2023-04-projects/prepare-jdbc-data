package com.khadri.jdbc.prepare.data.mobile.processor;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.mobile.dao.MobileInsertDao;
import com.khadri.jdbc.prepare.data.mobile.dao.model.Mobile;

public class MobileDataProcessor {

	private Scanner sc;

	private MobileInsertDao mobileDao;

	public MobileDataProcessor(Scanner sc, MobileInsertDao mobileDao) {
		this.sc = sc;
		this.mobileDao = mobileDao;
	}

	public void process(int recordNumber) {

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

		System.out.println("Processing File Wrting ");

		Mobile mobile = new Mobile(id, name, ram, rom, camera, battery, price);

		mobileDao.insertData(mobile);

	}
}
