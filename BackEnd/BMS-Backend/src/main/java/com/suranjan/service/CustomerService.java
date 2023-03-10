package com.suranjan.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.suranjan.exception.CustomerException;
import com.suranjan.model.Customer;
import com.suranjan.model.PaginationCriteria;


public interface CustomerService {

	public Customer insertCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Integer customerId, Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId) throws CustomerException;
	
	public List<Customer> getAllCustomers () throws CustomerException;

	public List<Customer> viewCustomer(PaginationCriteria paginationCriteria) throws CustomerException;
	
	public Customer viewCustomer(Integer customerId) throws CustomerException;
	
	public Customer findCustomerByAccountNumber(Integer accNum) throws CustomerException;
	
	public List<Customer> findCustomerWithSorting(String field) throws CustomerException;
	
	public Page <Customer> findCustomerWithPagination(int offset, int pageSize) throws CustomerException;
	
	public Page <Customer> findCustomerWithPaginationAndSorting(int offset, int pageSize, String field) throws CustomerException;
}
