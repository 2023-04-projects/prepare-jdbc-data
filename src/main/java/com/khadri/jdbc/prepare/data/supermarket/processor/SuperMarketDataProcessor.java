package com.khadri.jdbc.prepare.data.supermarket.processor;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;
import com.khadri.jdbc.prepare.data.supermarket.daos.SuperMarketInsertDao;

public class SuperMarketDataProcessor {
	
	private Scanner scanner;
	private SuperMarketInsertDao superMarketInsertDao;

	public SuperMarketDataProcessor(Scanner scanner,  SuperMarketInsertDao superMarketInsertDao) {
		this.scanner = scanner;
		this.superMarketInsertDao = superMarketInsertDao;
	}

	public void process(int recordNumber) throws Exception {

		//System.out.println("===========> SUPERMARKET " + recordNumber + " DATA READING STARTS ===========>");

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

		//System.out.println("<=========== SUPERMARKET " + recordNumber + " DATA READING ENDS <===========");

		//System.out.println("===========> SUPERMARKET " + recordNumber + " DATA WRITING INTO CSV File STARTS ===========>");
		//System.out.println("Processing  JDBC database Wrting ");

		SuperMarket market = new SuperMarket(prodName, prodId, prodPrice, prodQty, totalAmt);
		
		SuperMarketInsertDao superMarketInsertDao = new SuperMarketInsertDao();
		superMarketInsertDao.insertSuperMarketData(market);
		
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
		System.out.println();
		//System.out.println("<=========== SUPERMARKET " + recordNumber + " DATA WRITING INTO CSV File ENDS <===========");
	}


}
