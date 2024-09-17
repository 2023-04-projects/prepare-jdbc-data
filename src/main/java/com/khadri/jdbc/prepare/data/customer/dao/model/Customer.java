package com.khadri.jdbc.prepare.data.customer.dao.model;

public class Customer {
	private int id;
	private String name;
	private String address;
	private long phoneNum;

	public Customer(int id, String name, String address, long phoneNum) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

}
