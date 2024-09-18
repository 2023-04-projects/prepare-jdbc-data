package com.khadri.jdbc.prepare.data.supermarket.dao.model;

public class SuperMarket {

	private String prodName;
	private int prodId;
	private double prodPrice;
	private int prodQty;
	private double totalAmt;

	public SuperMarket(String prodName, int prodId, double prodPrice, int prodQty, double totalAmt) {
		super();
		this.prodName = prodName;
		this.prodId = prodId;
		this.prodPrice = prodPrice;
		this.prodQty = prodQty;
		this.totalAmt = totalAmt;
	}

	public String getProdName() {
		return prodName;
	}

	public int getProdId() {
		return prodId;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public int getProdQty() {
		return prodQty;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

}
