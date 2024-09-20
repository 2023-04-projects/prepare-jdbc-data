package com.khadri.jdbc.prepare.data.supermarket.processor;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.supermarket.dao.SuperMarketDao;
import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;
public class SuperMarketDataProcessor {

	private Scanner scanner;
	private SuperMarketDao superDao;

	public SuperMarketDataProcessor(Scanner scanner, SuperMarketDao superDao) {
		super();
		this.scanner = scanner;
		this.superDao = superDao;
	}

	public void process(int recordNumber) {

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

			SuperMarket market = new SuperMarket(prodName, prodId, prodPrice, prodQty, totalAmt);

			superDao.insertSuperMarketData(market);
		} catch (Exception e) {
			System.out.println("SuperMarketDataProssor Exception Occour" + e);
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

}
