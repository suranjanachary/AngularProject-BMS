package com.suranjan.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.suranjan.exception.CustomerException;
import com.suranjan.model.Customer;
import com.suranjan.model.PaginationCriteria;

@Repository
@Transactional
public class CustomerCustomDaoImpl implements CustomerCustomDao {

	 @PersistenceContext
	 private EntityManager entityManager;
	
	

	@Override
	public List<Customer> findAll(PaginationCriteria paginationCriteria) throws CustomerException {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer>root = criteriaQuery.from(Customer.class);

        if(paginationCriteria.getSearchItem()!=null&&!paginationCriteria.getSearchItem().isEmpty()) {

            Predicate predicate=criteriaBuilder.like(root.get("customerName"),paginationCriteria.getSearchItem());

            criteriaQuery.where(predicate);

        }

        // Condition for sorting.
        
        Order order;
        if (paginationCriteria.getSortField() != null && !paginationCriteria.getSortField().isEmpty()) {
            if (paginationCriteria.getSortType().equals("desc") ) {
                order = criteriaBuilder.desc(root.get(paginationCriteria.getSortField()));
            } else {
                order = criteriaBuilder.asc(root.get(paginationCriteria.getSortField()));
            }
        } else {
            order = criteriaBuilder.desc(root.get("customerId"));
        }
        criteriaQuery.orderBy(order);




        List<Customer> result =
                entityManager
                        .createQuery(criteriaQuery)
                        .setMaxResults(paginationCriteria.getLimit())
                        .setFirstResult((paginationCriteria.getPage()-1)* paginationCriteria.getLimit())
                        .getResultList();

        return result;
	}

	@Override
	public Customer findCustomerByCustomerId(String cust, Integer id) {
		
		 	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery cq = cb.createQuery(Customer.class);

	        Root<Customer> customer = cq.from(Customer.class);

	        Predicate customerNamePredicate = cb.equal(customer.get("customerName"),cust);

	        Predicate customerIdPredicate=cb.notEqual(customer.get("customerId"),id);
	        Predicate predicate = cb.and(customerNamePredicate,customerIdPredicate);
	        cq.where(predicate);
	        
	        List<Customer> list =entityManager.createQuery(cq).getResultList();
	        if(list.size()>0){
	            return list.get(0);
	        }

	        return null ;
	}

}
