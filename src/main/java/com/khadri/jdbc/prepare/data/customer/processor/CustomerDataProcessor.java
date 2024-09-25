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

	public void insertProcess(int recordNumber) {
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

			custDao.insertCustomerData(cust);
		} catch (Exception e) {
			System.out.println("CustomerDataProcesser Exception occours" + e);
		}
	}

	public void selectProcess(int recordNumber) {
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

			custDao.selectCustomerData();
		} catch (Exception e) {
			System.out.println("CustomerDataProcesser Exception occours" + e);

		}

	}

	public void updateProcess() {

		try {
			System.out.println("Enter Customer id to update: ");
			int id = scanner.nextInt();

			System.out.println("Enter new Customer name: ");
			String name = scanner.next();

			System.out.println("Enter new Customer address: ");
			String address = scanner.next();

			System.out.println("Enter new Customer phoneNum: ");
			Long phoneNum = scanner.nextLong();

			Customer cust = new Customer(id, name, address, phoneNum);

			boolean isUpdated = custDao.updateCustomerData(cust);

			if (isUpdated) {
				System.out.println("Customer updated successfully.");
			} else {
				System.out.println("Customer update failed.");
			}
		} catch (Exception e) {
			System.out.println("UpdateProcessor Exception occurs: " + e);
		}
	}

	public void deleteProcess() {
		try {
			System.out.println("Enter Customer id to delete: ");
			int id = scanner.nextInt();

			boolean isDeleted = custDao.deleteCustomerData(id);

			if (isDeleted) {
				System.out.println("Customer deleted successfully.");
			} else {
				System.out.println("Customer delete failed.");
			}
		} catch (Exception e) {
			System.out.println("DeleteProcessor Exception occurs: " + e);
		}
	}
}