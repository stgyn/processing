package com.processing.engine.model;

public class TransactionClass {
	private int id;
	private String uuid;
	private String transaction_type;
	private int transaction_account;
	private double transaction_amount;
	private String transaction_json;

	public int getID () {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getUUID() {
		return this.uuid;
	}

	public void setUUID(String uuid) {
		this.uuid = uuid;
	}

	public String getType() {
		return this.transaction_type;
	}

	public void setType(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public int GetAccount () {
		return this.transaction_account;
	}
	
	public void setAccount(int transaction_account) {
		this.transaction_account = transaction_account;
	}

	public double GetAmount () {
		return this.transaction_amount;
	}
	
	public void setAmount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	
	public String getContent() {
		return this.transaction_json;
	}

	public void setContent(String transaction_json) {
		this.transaction_json = transaction_json;
	}
	
	@Override
	public String toString() {
		return "[id=" + this.id + ", uuid=" + this.uuid + ", transaction_type=" + this.transaction_type + ", transaction_account=" + this.transaction_account + ", transaction_amount=" + this.transaction_amount + ", transaction_json=" + this.transaction_json + "]";
	}
}
