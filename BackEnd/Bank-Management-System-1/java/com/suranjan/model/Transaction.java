package com.suranjan.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Transaction {
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private  Customer accountnumber;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transaction_id;
	@NotNull(message = "Format should be dd/mm/yyyy ")
	private  LocalDateTime transaction_date;
	@NotNull
	private String transaction_type;
	@NotNull
	private Float transaction_amount;
	@NotNull
	private Float remaining_balance;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Customer accountnumber, Integer transaction_id,
			@NotNull(message = "Format should be dd/mm/yyyy ") LocalDateTime transaction_date,
			@NotNull String transaction_type, @NotNull Float transaction_amount, @NotNull Float remaining_balance) {
		super();
		this.accountnumber = accountnumber;
		this.transaction_id = transaction_id;
		this.transaction_date = transaction_date;
		this.transaction_type = transaction_type;
		this.transaction_amount = transaction_amount;
		this.remaining_balance = remaining_balance;
	}

	public Customer getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Customer accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Integer getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}

	public LocalDateTime getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(LocalDateTime transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public Float getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(Float transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public Float getRemaining_balance() {
		return remaining_balance;
	}

	public void setRemaining_balance(Float remaining_balance) {
		this.remaining_balance = remaining_balance;
	}

	@Override
	public String toString() {
		return "Transaction [accountnumber=" + accountnumber + ", transaction_id=" + transaction_id
				+ ", transaction_date=" + transaction_date + ", transaction_type=" + transaction_type
				+ ", transaction_amount=" + transaction_amount + ", remaining_balance=" + remaining_balance + "]";
	}

	
	
	
}
