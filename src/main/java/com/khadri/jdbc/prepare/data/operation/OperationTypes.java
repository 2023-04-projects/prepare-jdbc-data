package com.khadri.jdbc.prepare.data.operation;

public enum OperationTypes {

	INSERT(1, "INSERT"), SELECT(2, "SELECT"), UPDATE(3, "UPDATE"), DELETE(4, "DELETE");

	private Integer operationType;
	private String operationName;

	private OperationTypes(Integer operationType, String operationName) {
		this.operationType = operationType;
		this.operationName = operationName;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public String getOperationName() {
		return operationName;
	}

}
