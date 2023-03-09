package com.suranjan.repository;

import java.util.List;

import com.suranjan.exception.CustomerException;
import com.suranjan.model.Customer;
import com.suranjan.model.PaginationCriteria;

public interface CustomerCustomDao {

	Customer findCustomerByCustomerId(String empc,Integer id) ;
    List<Customer> findAll(PaginationCriteria paginationCriteria) throws CustomerException;
}
