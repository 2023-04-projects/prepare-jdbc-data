package com.khadri.jdbc.prepare.data.mobile.processor;

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

			mobileDao.insertData(mobile);

		} catch (Exception e) {
			System.out.println("MobileDataProssor Exception occours" + e);
		}
	}

	public void selectProcess(int recordNumber) {
		try {
			System.out.println(recordNumber + " Record Reading starts!!!");
			mobileDao.mobileSelectData();
			System.out.println(recordNumber + " Record Reading ends...!");
		} catch (Exception e) {
			System.out.println("MobileDataProcessor Exception occurs " + e);
		}
	}

	public void updateProcess() {
		try {
			System.out.println("Record Reading starts!!!!");

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
			System.out.println("Record Reading ends!!!!");

			Mobile mobile = new Mobile(id, name, ram, rom, camera, battery, price);
			boolean updateMobileData = mobileDao.updateMobileData(mobile);
			if (updateMobileData) {
				System.out.println("mobile Data updated successfully!!!");
			} else {
				System.out.println("mobile update failed..!");
			}
		} catch (Exception e) {
			System.out.println("MobileupdateDataProcessor Exception occurs" + e);
		}
	}

	public void deleteProcess() {

		try {
			System.out.println("Enter MOBILE_ID : ");
			int id = sc.nextInt();

			boolean isDeleted = mobileDao.deleteMobileData(id);

			if (isDeleted) {
				System.out.println("Mobile Record Deleted Successfully...!");
			} else {
				System.out.println("Mobile Record Deleting Failed!!!!");
			}

		} catch (Exception e) {
			System.out.println("Delete mobile Exception occurs" + e);

		}
	}

}
