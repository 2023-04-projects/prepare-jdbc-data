package com.khadri.jdbc.prepare.data.driver.types;

public enum DriverTypes {
	EMPLOYEE(1, "employee"), CUSTOMER(2, "customer"), SUPER_MARKET(3, "supermarket"), MOVIE(4, "movie"),
	MOBILE(5, "mobile");

	private Integer id;
	private String name;

	DriverTypes(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
