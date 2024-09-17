package com.khadri.jdbc.prepare.data.customer.processor;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.customer.dao.CustomerInsertDao;
import com.khadri.jdbc.prepare.data.customer.dao.model.Customer;
import com.khadri.jdbc.prepare.data.student.dao.model.Student;

public class CustomerDataProcessor {
	private Scanner scanner;
	private CustomerInsertDao custDao;

	public CustomerDataProcessor(Scanner scanner, CustomerInsertDao CustDao) {
		this.scanner = scanner;
		this.custDao = custDao;
	}

	public void process(int recordNumber) throws Exception {

		System.out.println("Enter Customer id : ");
		int id = scanner.nextInt();

		System.out.println("Enter Customer name : ");
		String name = scanner.next();

		System.out.println("Enter  Customer address : ");
		String address = scanner.next();

		System.out.println("Enter Customer phoneNum : ");
		Long phoneNum = scanner.nextLong();

		Customer cust = new Customer(id, name, address, phoneNum);
		CustomerInsertDao custDao = new CustomerInsertDao();

		custDao.insertData(cust);
	}
}
