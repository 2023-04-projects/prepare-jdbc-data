package com.khadri.jdbc.prepare.data.mobile.dao.model;

public class Mobile {

	private int id;
	private String name;
	private int ram;
	private int rom;
	private String camera;
	private int battery;
	private int price;

	public Mobile(int id, String name, int ram, int rom, String camera, int battery, int price) {

		this.id = id;
		this.name = name;
		this.ram = ram;
		this.rom = rom;
		this.camera = camera;
		this.battery = battery;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getRam() {
		return ram;
	}

	public int getRom() {
		return rom;
	}

	public String getCamera() {
		return camera;
	}

	public int getBattery() {
		return battery;
	}

	public int getPrice() {
		return price;
	}

}
