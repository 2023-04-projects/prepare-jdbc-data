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

		System.out.println("Enter Cust_Id : ");
		int id = scanner.nextInt();

		System.out.println("Enter Customer Name : ");
		String name = scanner.next();

		System.out.println("Enter  Customer Address : ");
		String address = scanner.next();

		System.out.println("Enter Customer Phone_Num : ");
		Long phone_Num = scanner.nextLong();

		Customer cust = new Customer(id, name, address, phone_Num);
		CustomerInsertDao CustDao = new CustomerInsertDao();

		CustDao.insertData(cust);
	}
}
