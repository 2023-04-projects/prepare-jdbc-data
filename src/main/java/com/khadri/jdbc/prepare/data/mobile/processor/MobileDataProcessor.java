package com.khadri.jdbc.prepare.data.mobile.processor;

import java.util.List;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.mobile.dao.MobileDao;
import com.khadri.jdbc.prepare.data.mobile.dao.model.Mobile;

public class MobileDataProcessor {

	private Scanner scanner;

	private MobileDao mobileDao;

	{
		this.mobileDao = new MobileDao();
	}

	public MobileDataProcessor(Scanner scanner) {
		this.scanner = scanner;
	}

	public void insertProcess(int recordNumber) {
		try {

			System.out.println(recordNumber + "Record Reading starts");

			System.out.println("Enter MOBILE_ID : ");
			int id = scanner.nextInt();

			System.out.println("Enter MOBILE_NAME : ");
			String name = scanner.next();

			System.out.println("Enter RAM : ");
			int ram = scanner.nextInt();

			System.out.println("Enter ROM : ");
			int rom = scanner.nextInt();

			System.out.println("Enter CAMERA : ");
			String camera = scanner.next();

			System.out.println("Enter BATTERY_CAPACITY : ");
			int battery = scanner.nextInt();

			System.out.println("Enter PRICE : ");
			int price = scanner.nextInt();

			System.out.println("Processing File Wrting ");

			Mobile mobile = new Mobile(id, name, ram, rom, camera, battery, price);

			int result = mobileDao.insertData(mobile);
			if (result == 1) {
				System.out.println(result + "Record Inserted");
			}

		} catch (Exception e) {
			System.out.println("MobileDataProssor Exception occours" + e);
		}
	}

	public void selectProcess(int recordNumber) {
		try {
			System.out.println(recordNumber + " Record Reading starts!!!");
			List<Mobile> listOfMobile = mobileDao.mobileSelectData();
			listOfMobile.stream().forEach(eachMobile -> {
				System.out.println(eachMobile.getId() + " " + eachMobile.getName() + " " + eachMobile.getRam() + " "
						+ eachMobile.getRom() + " " + eachMobile.getCamera() + " " + eachMobile.getBattery() + " "
						+ eachMobile.getPrice());
				;
			});
		} catch (Exception e) {
			System.out.println("MobileDataProcessor Exception occurs " + e);
		} finally {
			System.out.println(recordNumber + " Record Reading ends...!");

		}
	}

	public void updateProcess() {
		try {
			System.out.println("Record Reading starts!!!!");

			System.out.println("Enter MOBILE_ID : ");
			int id = scanner.nextInt();

			System.out.println("Enter MOBILE_NAME : ");
			String name = scanner.next();

			System.out.println("Enter RAM : ");
			int ram = scanner.nextInt();

			System.out.println("Enter ROM : ");
			int rom = scanner.nextInt();

			System.out.println("Enter CAMERA : ");
			String camera = scanner.next();

			System.out.println("Enter BATTERY_CAPACITY : ");
			int battery = scanner.nextInt();

			System.out.println("Enter PRICE : ");
			int price = scanner.nextInt();
			System.out.println("Record Reading ends!!!!");

			Mobile mobile = new Mobile(id, name, ram, rom, camera, battery, price);
			int updateMobileData = mobileDao.updateMobileData(mobile);
			if (updateMobileData == 1) {
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
			int id = scanner.nextInt();

			int isDeleted = mobileDao.deleteMobileData(id);

			if (isDeleted == 2) {
				System.out.println("Mobile Record Deleted Successfully...!");
			} else {
				System.out.println("Mobile Record Deleting Failed!!!!");
			}

		} catch (Exception e) {
			System.out.println("Delete mobile Exception occurs" + e);

		}
	}

}
