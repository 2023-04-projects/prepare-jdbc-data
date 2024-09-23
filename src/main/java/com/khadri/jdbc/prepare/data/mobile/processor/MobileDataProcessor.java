package com.khadri.jdbc.prepare.data.mobile.processor;

import java.sql.SQLException;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.mobile.dao.MobileDao;
import com.khadri.jdbc.prepare.data.mobile.dao.model.Mobile;

public class MobileDataProcessor {

	private Scanner sc;

	private MobileDao mobileDao;

	public MobileDataProcessor(Scanner sc, MobileDao mobileDao) {
		this.sc = sc;
		this.mobileDao = mobileDao;
	}

	public void insertProcess(int recordNumber) {

		try {

			System.out.println(recordNumber + "Record Reading starts");

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

			mobileDao.mobileInsertData(mobile);
		} catch (Exception e) {
			System.out.println("MobileDataProssor Exception occours" + e);
		}
	}

	public void selectProcess(int recordNumber) {
		try {
			System.out.println(recordNumber + " Record Reading starts");
			mobileDao.mobileSelectData();
			System.out.println(recordNumber + " Record Reading ends ");
		} catch (Exception e) {
			System.out.println("MovieDataProcesser Exception occours" + e);
		}
	}

	public void updateProcess() {
		try {

			System.out.println("Record Updating starts");

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

			System.out.println("Updating Record ends!!!");

			Mobile mobile = new Mobile(id, name, ram, rom, camera, battery, price);

			boolean mobileupdatetData = mobileDao.MobileupdatetData(mobile);
		} catch (Exception e) {
			System.out.println("MobileDataProssor Exception occours" + e);
		}
	}

	public void deleteProcess() {
		try {

			System.out.println("Enter MOBILE_ID : ");
			int id = sc.nextInt();

			boolean isDeleted = mobileDao.MobileDeleteData(id);

			if (isDeleted) {
				System.out.println("mobile record deleted successfully!!!!");
			} else {
				System.out.println("mobile deleting is failed...");
			}
		} catch (Exception e) {
			System.out.println("Mobile Deleting Exception occours" + e);
		}
	}

}
