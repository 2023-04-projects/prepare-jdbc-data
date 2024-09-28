package com.khadri.jdbc.prepare.data.customer.processor;

import java.util.List;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.customer.dao.CustomerDao;
import com.khadri.jdbc.prepare.data.customer.dao.model.Customer;

public class CustomerDataProcessor {
	private Scanner scanner;
	private CustomerDao custDao;

	{
		this.custDao = new CustomerDao();
	}

	public CustomerDataProcessor(Scanner scanner) {
		this.scanner = scanner;
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

			int result = custDao.insertCustomerData(cust);

			if (result == 1) {
				System.out.println(result + " Record Inserted..");
			}

		} catch (Exception e) {
			System.out.println("CustomerDataProcesser Exception occours" + e);
		}

	}

	public void selectProcess() {
		try {
			System.out.println("Reading starts");
			List<Customer> listOfCustomers = custDao.selectCustomerData();

			listOfCustomers.stream().forEach(eachCustomer -> {
				System.out.println(eachCustomer.getId() + " " + eachCustomer.getName() + " "
						+ eachCustomer.getPhoneNum() + " " + eachCustomer.getAddress());
			});

		} catch (Exception e) {
			System.out.println("CustomerDataProcesser Exception occours" + e);
		} finally {
			System.out.println("Reading ends ");
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

			int isUpdated = custDao.updateCustomerData(cust);

			if (isUpdated==1) {
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

			int isDeleted = custDao.deleteCustomerData(id);

			if (isDeleted==1) {
				System.out.println("Customer deleted successfully.");
			} else {
				System.out.println("Customer delete failed.");
			}
		} catch (Exception e) {
			System.out.println("DeleteProcessor Exception occurs: " + e);
		}
	}
}