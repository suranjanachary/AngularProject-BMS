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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Account {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer account_id;	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Customer customer;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(Integer account_id, Customer customer) {
		super();
		this.account_id = account_id;
		this.customer = customer;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", customer=" + customer + "]";
	}

		
	 
}
