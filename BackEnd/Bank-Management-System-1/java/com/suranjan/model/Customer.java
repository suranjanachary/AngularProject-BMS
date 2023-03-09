package com.suranjan.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;


//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	private String customerName;
	
	private String customerEmail;
	
	
	private String customerPhone;

	private String customerUserName;
	
	private String customerPassword;
	
	private String customerAddress;
	
	
	private Integer accountNumber;
	
	private Float accountBalance;
	
	private String accountDescription;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	List<Transaction> all_transactions =  new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
	@JsonIgnore
	private Account account;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "accountnumber")
	@JsonIgnore
	private List<Transaction> allTrasactions = new ArrayList<Transaction>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, String customerName, String customerEmail, String customerPhone,
			String customerUserName, String customerPassword, String customerAddress, Integer accountNumber,
			Float accountBalance, String accountDescription, Account account, List<Transaction> allTrasactions) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerUserName = customerUserName;
		this.customerPassword = customerPassword;
		this.customerAddress = customerAddress;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.accountDescription = accountDescription;
		this.account = account;
		this.allTrasactions = allTrasactions;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Transaction> getAllTrasactions() {
		return allTrasactions;
	}

	public void setAllTrasactions(List<Transaction> allTrasactions) {
		this.allTrasactions = allTrasactions;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPhone=" + customerPhone + ", customerUserName=" + customerUserName
				+ ", customerPassword=" + customerPassword + ", customerAddress=" + customerAddress + ", accountNumber="
				+ accountNumber + ", accountBalance=" + accountBalance + ", accountDescription=" + accountDescription
				+ ", account=" + account + ", allTrasactions=" + allTrasactions + "]";
	}

	
	
	
	
}
