package com.khadri.jdbc.prepare.data.customer.dao.model;

public class Customer {
	private int id;
	private String name;
	private String address;
	private long phone_num;

	public Customer(int id, String name, String address, long phone_num) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone_num = phone_num;
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

	public void setPhone_num(long phone_num) {
		this.phone_num = phone_num;
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

	public long getPhone_num() {
		return phone_num;
	}

}
