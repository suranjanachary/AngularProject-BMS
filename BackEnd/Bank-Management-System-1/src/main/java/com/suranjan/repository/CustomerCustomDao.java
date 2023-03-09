package com.suranjan.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.suranjan.exception.CustomerException;
import com.suranjan.model.Customer;
import com.suranjan.model.PaginationCriteria;

public interface CustomerCustomDao {

	Customer findCustomerByCustomerId(String empc,Integer id) ;
    List<Customer> findAll(PaginationCriteria paginationCriteria) throws CustomerException;
//    Page<Customer> findByNameContaining(String name, Pageable pageable);
}
