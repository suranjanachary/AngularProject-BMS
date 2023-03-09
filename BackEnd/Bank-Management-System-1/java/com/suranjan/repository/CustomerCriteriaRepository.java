package com.suranjan.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import com.suranjan.model.Customer;
import com.suranjan.model.CustomerPage;
import com.suranjan.model.CustomerSearchCriteria;

@Repository
public class CustomerCriteriaRepository {

	private final EntityManager entityManager;
	private final CriteriaBuilder criteriaBuilder;

	public CustomerCriteriaRepository(EntityManager entityManager, CriteriaBuilder criteriaBuilder) {
		super();
		this.entityManager = entityManager;
		this.criteriaBuilder = criteriaBuilder;
	}

	public Page<Customer> findWithFilters(CustomerPage customerPage, 
			CustomerSearchCriteria customerSearechCriteria){
		
		
		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
		Predicate predicate = getPredicate(customerSearechCriteria,customerRoot);
		criteriaQuery.where(predicate);
		
		setOrder(customerPage,criteriaQuery,customerRoot);
		TypedQuery<Customer> typeQuery = entityManager.createQuery(criteriaQuery);
		typeQuery.setFirstResult(customerPage.getPageNumber()*customerPage.getPageSize());
		typeQuery.setMaxResults(customerPage.getPageSize());
		Pageable pageable = getPageable(customerPage);
		
		long customerCount = getCustomerCount(predicate);
		
		return new PageImpl<>(typeQuery.getResultList(),pageable,customerCount);
		
	}
	
	private long getCustomerCount(Predicate predicate) {
		// TODO Auto-generated method stub
		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		Root<Customer> countRoot = countQuery.from(Customer.class);
		
		countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
		return entityManager.createQuery(countQuery).getSingleResult();
	}
	
	
	private Pageable getPageable(CustomerPage productPage) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(productPage.getSortDirection(),productPage.getSortBy());
		return PageRequest.of(productPage.getPageNumber(),productPage.getPageSize(),sort );
		
	}
	
	
	private void setOrder(CustomerPage customerPage, CriteriaQuery<Customer> criteriaQuery,
			Root<Customer> customerRoot) {
		// TODO Auto-generated method stub
		if(customerPage.getSortDirection().equals(Sort.Direction.ASC)) {
			criteriaQuery.orderBy(criteriaBuilder.asc(customerRoot.get(customerPage.getSortBy())));
			}
		else {
			criteriaQuery.orderBy(criteriaBuilder.desc(customerRoot.get(customerPage.getSortBy())));
		}
	  }


	private Predicate getPredicate(CustomerSearchCriteria customerSearchCriteria, Root<Customer> customerRoot) {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (Objects.nonNull(customerSearchCriteria.getCustomer())
				&& Objects.nonNull(customerSearchCriteria.getCustomer().getCustomerName())) {

			predicates.add(criteriaBuilder.like(customerRoot.get("customerName"),
					"%" + customerSearchCriteria.getCustomer().getCustomerName() + "%"));
		}

		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

	}

}
