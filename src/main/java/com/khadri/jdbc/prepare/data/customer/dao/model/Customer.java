package com.khadri.jdbc.prepare.data.customer.dao.model;

public class Customer {
	private int id;
	private String name;
	private String address;
	private long phone_Num;

	public Customer(int id, String name, String address, long phone_Num) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone_Num = phone_Num;
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

	public void setPhone_num(long phone_Num) {
		this.phone_Num = phone_Num;
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

	public long getPhone_Num() {
		return phone_Num;
	}

}
