package com.suranjan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.suranjan.exception.CustomerException;
import com.suranjan.model.Customer;
import com.suranjan.model.CustomerPage;
import com.suranjan.model.CustomerSearchCriteria;
import com.suranjan.model.PaginationCriteria;
import com.suranjan.repository.CustomerCriteriaRepository;
import com.suranjan.repository.CustomerCustomDao;
import com.suranjan.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao  customerDao;
	
	 @Autowired
	private CustomerCustomDao  customerCustomDao;
	 
	 @Autowired
	private CustomerCriteriaRepository customerCriteriaRepository;
	
	@Override
	public Customer insertCustomer(Customer customer) throws CustomerException {
		Customer cust = customerDao.save(customer);
		return cust;
	}

	@Override
	public Customer updateCustomer(Integer customerId, Customer customer) throws CustomerException {
		
		Optional<Customer> optional = customerDao.findById(customer.getCustomerId());
		
		if(optional.isPresent()) {
			
			Customer updatedCustomer = customerDao.save(customer);
			
			updatedCustomer.setCustomerUserName(customer.getCustomerUserName());
			updatedCustomer.setCustomerPassword(customer.getCustomerPassword());
			updatedCustomer.setCustomerName(customer.getCustomerName());
			updatedCustomer.setCustomerAddress(customer.getCustomerAddress());
			updatedCustomer.setCustomerPhone(customer.getCustomerPhone()); 
			updatedCustomer.setCustomerEmail(customer.getCustomerEmail()); 
			updatedCustomer.setAccountBalance(customer.getAccountBalance()); 
			updatedCustomer.setAccountDescription(customer.getAccountDescription()); 
			
			return updatedCustomer;
		
		}
		else {
			throw new CustomerException("Customer not available with the given data");
		}
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {
		
		Optional<Customer> optional= customerDao.findById(customerId);
		
		if(optional.isPresent()) {
			
		 customerDao.delete(optional.get());
		 return optional.get();
		}
		else {
			throw new CustomerException ("Customer not available with the given ID :"+ customerId);
		}
	}

	@Override
	public List<Customer> viewCustomer(PaginationCriteria paginationCriteria) throws CustomerException {
		
		return customerCustomDao.findAll(paginationCriteria);
		
	}
	
	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		
		return customerDao.getAllCustomers();
		
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
	
		Optional<Customer> opt = customerDao.findById(customerId);
		
		if(opt.isPresent()) {
			Customer customer = opt.get();
			return customer;
		}
		else {
			throw new CustomerException("No customers found with the given Customer ID");
		}
	}

	@Override
	public Customer findCustomerByAccountNumber(Integer accNum) throws CustomerException {
		
		Customer opt = customerDao.getCustomerByAcNo(accNum);
		
		if(opt != null) {
			Customer customer = opt;
			return customer;
		}
		else {
			throw new CustomerException("No customers found with the given Customer ID");
		}
	}

	@Override
	public List<Customer> findCustomerWithSorting(String field) throws CustomerException {
		return customerDao.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	@Override
	public Page <Customer> findCustomerWithPagination(int offset, int pageSize) throws CustomerException {
		Page<Customer>customers= customerDao.findAll(PageRequest.of(offset, pageSize));
		return customers;
	}

	@Override
	public Page<Customer> findCustomerWithPaginationAndSorting(int offset, int pageSize, String field)
			throws CustomerException {
		
		Page<Customer>customers= customerDao.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.DESC,field)));
		return customers;
	}
	
	public Page<Customer> getCustomers(CustomerPage customerPage, 
			CustomerSearchCriteria customerSearchCriteria){
		return customerCriteriaRepository.findWithFilters(customerPage,customerSearchCriteria);
	}

}
