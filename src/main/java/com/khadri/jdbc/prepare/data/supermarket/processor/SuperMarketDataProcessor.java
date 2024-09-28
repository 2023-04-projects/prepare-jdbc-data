package com.khadri.jdbc.prepare.data.supermarket.processor;

import java.util.List;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.supermarket.dao.SuperMarketDao;
import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;

public class SuperMarketDataProcessor {

	private Scanner scanner;
	private SuperMarketDao superDao;

	{
		this.superDao = new SuperMarketDao();
	}

	public SuperMarketDataProcessor(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void insertSuperMarketProcess(int recordNumber) {

		try {
			
			System.out.println("Record Reading starts");

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

			SuperMarket superMarket = new SuperMarket(prodName, prodId, prodPrice, prodQty, totalAmt);

			int result = superDao.insertSuperMarketData(superMarket);
			
			if (result == 1) {
				System.out.println(result + "Record Inserted Successfully ..!");
			}
		} catch (Exception e) {
			System.out.println("SuperMarketDataProcessor Exception Occour" + e);
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

	public void selectSuperMarketProcess(int recordNumber) {

		try {

			System.out.println(recordNumber + "Record Reading starts");
			List<SuperMarket> listOfSuperMarket = superDao.selectSuperMarketData();
			
			listOfSuperMarket.stream().forEach(eachSuperMarket -> { 
				System.out.println(eachSuperMarket.getProdId()+ " " + eachSuperMarket.getProdName()+
						" " + eachSuperMarket.getProdPrice()+ " " + eachSuperMarket.getProdQty()+" "+
						eachSuperMarket.getTotalAmt());
			});

			System.out.println(recordNumber + "Record Reading end");

		} catch (Exception e) {
			System.out.println("SelectInsertSuperMarketDataProcessor Exception Occour" + e);
		}
	}

	public void updateSuperMarketProcess() {

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

			SuperMarket superMarket = new SuperMarket(prodName, prodId, prodPrice, prodQty, totalAmt);
			int isUpdateSuperMarket = superDao.updateSuperMarketData(superMarket);

			if (isUpdateSuperMarket == 1) {
				System.out.println("SuperMarket Updated Record Successfully..! ");
			} else {
				System.out.println("SuperMarket Updated Record Failed..! ");
			}
		} catch (Exception e) {
			System.out.println("UpdateSuperMarketProcessor Exception occurs: " + e);
		}

	}

	public void deleteSuperMarketProcess() {

		try {
			System.out.println("Enter superMarket PROD_ID: ");
			int prodId = scanner.nextInt();

			int isDeleteSuperMarket = superDao.deleteSuperMarketData(prodId);

			if (isDeleteSuperMarket == 1) {
				System.out.println("SuperMarket Deleted Record Successfully..! ");
			} else {
				System.out.println("SuperMarket Deleted Record Failed..!");
			}
		} catch (Exception e) {
			System.out.println("DeleteSuperMarketProcessor Exception occurs: " + e);
		}
	}

}
