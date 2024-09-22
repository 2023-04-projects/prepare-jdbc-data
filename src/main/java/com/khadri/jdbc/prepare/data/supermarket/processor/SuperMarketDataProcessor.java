package com.khadri.jdbc.prepare.data.supermarket.processor;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.supermarket.dao.SuperMarketDao;
import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;

public class SuperMarketDataProcessor {

	private Scanner scanner;
	private SuperMarketDao superDao;
	private SuperMarket superMarket;

	public SuperMarketDataProcessor(Scanner scanner, SuperMarketDao superDao) {
		super();
		this.scanner = scanner;
		this.superDao = superDao;
	}

	public void insertProcess(int recordNumber) {

		try {

			System.out.println(recordNumber + "Record Reading starts");

			System.out.println("Please Enter PROD_NAME : ");
			String prodName = scanner.next();

			System.out.println("Please Enter PROD_ID ");
			int prodId = scanner.nextInt();

			System.out.println("Please Enter PROD_PRICE ");
			double prodPrice = scanner.nextDouble();

			System.out.println("Please Enter PROD_QTY ");
			int prodQty = scanner.nextInt();

			System.out.println("Processing Product Total Amount");

			double totalAmt = prodPrice * prodQty;
			System.out.println("TOTAL_AMT : " + totalAmt);
			try {
				for (int i = 0; i < 1; i++) {
					Thread.sleep(1000);
					System.out.print("=>");
				}
			} catch (Exception e) {
				System.out.println("never comes");
			}

			superMarket = new SuperMarket(prodName, prodId, prodPrice, prodQty, totalAmt);

			superDao.insertSuperMarketData(superMarket);
		} catch (Exception e) {
			System.out.println("InsertSuperMarketDataProcessor Exception Occour" + e);
		}

		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
		System.out.println();
	}

	public void selectProcess(int recordNumber) {

		try {

			System.out.println(recordNumber + "Record Reading starts");

			System.out.println("Please Enter PROD_NAME : ");
			String prodName = scanner.next();

			System.out.println("Please Enter PROD_ID ");
			int prodId = scanner.nextInt();

			System.out.println("Please Enter PROD_PRICE ");
			double prodPrice = scanner.nextDouble();

			System.out.println("Please Enter PROD_QTY ");
			int prodQty = scanner.nextInt();

			System.out.println("Processing Product Total Amount");

			double totalAmt = prodPrice * prodQty;
			System.out.println("TOTAL_AMT : " + totalAmt);

			superMarket = new SuperMarket(prodName, prodId, prodPrice, prodQty, totalAmt);

			superDao.selectSuperMarketData();

		} catch (Exception e) {
			System.out.println("SelectInsertSuperMarketDataProcessor Exception Occour" + e);
		}
	}

	public void updateProcess() {

		try {
			System.out.println("Enter SuperMarket Update PROD_ID : ");
			int prodId = scanner.nextInt();

			System.out.println("Enter Your Update PROD_NAME :");
			String prodName = scanner.next();

			System.out.println("Please Enter PROD_PRICE ");
			double prodPrice = scanner.nextDouble();

			System.out.println("Enter Your Update PROD_QTY : ");
			int prodQty = scanner.nextInt();

			double totalAmt = prodPrice * prodQty;
			System.out.println("TOTAL_AMT : " + totalAmt);

			superMarket = new SuperMarket(prodName, prodId, prodPrice, prodQty, totalAmt);
			boolean isUpdateSuperMarket = superDao.updateSuperMarketData(superMarket);

			if (isUpdateSuperMarket) {
				System.out.println("SuperMarket Updated Record Successfully..! ");
			} else {
				System.out.println("SuperMarket Updated Record Failed..! ");
			}
		} catch (Exception e) {
			System.out.println("UpdateSuperMarketProcessor Exception occurs: " + e);
		}

	}

	public void deleteProcess() {

		try {
			System.out.println("Enter superMarket PROD_ID: ");
			int prodId = scanner.nextInt();

			boolean isDeleteSuperMarket = superDao.deleteSuperMarketData(prodId);

			if (isDeleteSuperMarket) {
				System.out.println("SuperMarket Deleted Record Successfully..! ");
			} else {
				System.out.println("SuperMarket Updated Record Failed..!");
			}
		} catch (Exception e) {
			System.out.println("DeleteSuperMarketProcessor Exception occurs: " + e);
		}
	}

}
