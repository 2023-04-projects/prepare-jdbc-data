package com.khadri.jdbc.prepare.data.customer.processor;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.customer.dao.CustomerDao;
import com.khadri.jdbc.prepare.data.customer.dao.model.Customer;

public class CustomerDataProcessor {
	private Scanner scanner;
	private CustomerDao custDao;

	public CustomerDataProcessor(Scanner scanner, CustomerDao custDao) {
		this.scanner = scanner;
		this.custDao = custDao;
	}

	public void process(int recordNumber) {
		try {
			System.out.println(recordNumber + " Record Reading starts");

			System.out.println("Enter Customer id : ");
			int id = scanner.nextInt();

			System.out.println("Enter Customer name : ");
			String name = scanner.next();

			System.out.println("Enter  Customer address : ");
			String address = scanner.next();

			System.out.println("Enter Customer phoneNum : ");
			Long phoneNum = scanner.nextLong();

			Customer cust = new Customer(id, name, address, phoneNum);

			custDao.insertData(cust);
		} catch (Exception e) {
			System.out.println("CustomerDataProcesser Exception occours" + e);

		}
	}

}