package com.processing.processing_engine.transaction;

import java.util.Map;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "transactions")
public class Transaction_POJO implements Serializable {
	@Id
	@SequenceGenerator(name="transactions_ids",sequenceName="transactions_ids", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="transactions_ids")
	@Column(name="id", unique=true, nullable=false)
	private int id;
	
	@SerializedName("transaction_uuid")
	@Column(name = "transaction_uuid")
	private String transaction_uuid;
	
	@SerializedName("transaction_type")
	@Column(name = "transaction_type")
	private String transaction_type;
	
	@SerializedName("transaction_account")
	@Column(name = "transaction_account")
	private int transaction_account;
	
	@SerializedName("transaction_amount")
	@Column(name = "transaction_amount")
	private double transaction_amount;
	
	@SerializedName("transaction_addinfo")
	private Map<String, Object> transaction_addinfo;
	
	@Column(name = "transaction_addinfo")
	private String transaction_addinfo_json;

	@Column(name = "transaction_json")	
	private String transaction_json;

	final Logger logger = LoggerFactory.getLogger(Transaction_POJO.class);

	public int getId() {
		return this.id;
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
	
	public double GetAmount () {
		return this.transaction_amount;
	}
	
	public void setAmount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

    public Map<String, Object> getAddInfo() {
        return this.transaction_addinfo;
    }
    public void setAddInfo(Map<String, Object> transaction_addinfo) {
        this.transaction_addinfo = transaction_addinfo;
    }
    
	public String getContent() {
		return this.transaction_json;
	}

	public void setContent(String transaction_json) {
		this.transaction_json = transaction_json;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
				//"[id=" + this.id + ", transaction_uuid=" + this.transaction_uuid + ", transaction_type=" + this.transaction_type + ", transaction_account=" + this.transaction_account + ", transaction_account_img=" + this.transaction_account_img + ", transaction_amount=" + this.transaction_amount + ", transaction_json=" + this.transaction_json + ", transaction_addinfo=" + this.transaction_addinfo + "]";
	}

	
	public void PrintTransactionPOJO() {
		logger.info("transaction_uuid     : "  +this.transaction_uuid);
		logger.info("transaction_type     : "  +this.transaction_type);
		logger.info("transaction_account  : "  +this.transaction_account);
		logger.info("transaction_amount   : "  +this.transaction_amount);
		logger.info("transaction_addinfo size   : " + this.transaction_addinfo.size());
		for (String property : this.transaction_addinfo.keySet()) {
			logger.info("    key: " + property + " value: " + this.transaction_addinfo.get(property));
		}
	}
}
