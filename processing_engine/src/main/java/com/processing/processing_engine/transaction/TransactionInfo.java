package com.processing.processing_engine.transaction;
import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class TransactionInfo {
	@JsonInclude(Include.NON_NULL)
	private int id;

	@JsonInclude(Include.NON_NULL)
	private String uuid;
	
	@JsonInclude(Include.NON_NULL)
	private String transaction_type;
	
	@JsonInclude(Include.NON_NULL)	
	private int transaction_account;
	
	@JsonInclude(Include.NON_NULL)	
	private String transaction_account_img;
	
	@JsonInclude(Include.NON_NULL)	
	private double transaction_amount;
	
	@JsonInclude(Include.NON_NULL)	
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

	public String GetAccountImg () {
		return this.transaction_account_img;
	}
	
	public void setAccountImg(String transaction_account_img) {
		this.transaction_account_img = transaction_account_img;
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
}
