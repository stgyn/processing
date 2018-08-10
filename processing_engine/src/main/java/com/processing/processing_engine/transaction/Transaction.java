package com.processing.processing_engine.transaction;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
	@Id
	@SequenceGenerator(name="transactions_ids",sequenceName="transactions_ids", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="transactions_ids")
	@Column(name="id", unique=true, nullable=false)
	private int id;
	
	@Column(name = "transaction_uuid")
	private String transaction_uuid;
	
	@Column(name = "transaction_type")
	private String transaction_type;
	
	@Column(name = "transaction_account")	
	private int transaction_account;
	
	@Column(name = "transaction_account_img")	
	private String transaction_account_img;
	
	@Column(name = "transaction_amount")	
	private double transaction_amount;
	
	@Column(name = "transaction_json")	
	private String transaction_json;

	@Column(name = "transaction_addinfo")
	private String transaction_addinfo;
	
	Transaction() {		
	}
	
	public Transaction(String transaction_uuid, String transaction_type, int transaction_account, String transaction_account_img, double transaction_amount, String transaction_json, String transaction_addinfo) {		
		this.transaction_uuid = transaction_uuid;
		this.transaction_type = transaction_type;
		this.transaction_account = transaction_account;
		this.transaction_account_img = transaction_account_img;
		this.transaction_amount = transaction_amount;
		this.transaction_json = transaction_json;
		this.transaction_addinfo = transaction_addinfo;
	}
	
	
	public int getID () {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getUUID() {
		return this.transaction_uuid;
	}

	public void setUUID(String transaction_uuid) {
		this.transaction_uuid = transaction_uuid;
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

	public void setAddInfo(String transaction_addinfo) {
		this.transaction_addinfo = transaction_addinfo;
	}

	public String getAddInfo() {
		return this.transaction_addinfo;
	}
	
	@Override
	public String toString() {
		return "[id=" + this.id + ", transaction_uuid=" + this.transaction_uuid + ", transaction_type=" + this.transaction_type + ", transaction_account=" + this.transaction_account + ", transaction_account_img=" + this.transaction_account_img + ", transaction_amount=" + this.transaction_amount + ", transaction_json=" + this.transaction_json + ", transaction_addinfo=" + this.transaction_addinfo + "]";
	}
}
