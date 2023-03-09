package com.suranjan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.suranjan.dto.CustomerDetailsDTO;
import com.suranjan.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

//	@Query(value = "select * from Customer", nativeQuery = true)
//	public List<Customer> getAllCustomers();
	
	@Query("from Customer")
	public List<Customer> getAllCustomers();
	
	@Query(value = "select * from Customer where account_number = ?1 " , nativeQuery = true)
	public Customer getCustomerByAcNo(Integer accNum);
}
