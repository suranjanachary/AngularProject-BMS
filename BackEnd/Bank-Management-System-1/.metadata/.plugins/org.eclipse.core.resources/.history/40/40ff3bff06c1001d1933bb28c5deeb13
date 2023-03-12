package com.suranjan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suranjan.dto.AdminLoginDTO;
import com.suranjan.dto.PaginationDto;
import com.suranjan.exception.AdminException;
import com.suranjan.exception.CustomerException;
import com.suranjan.exception.LoginException;
import com.suranjan.model.AdminSignupData;
import com.suranjan.model.Customer;
import com.suranjan.model.CustomerPage;
import com.suranjan.model.CustomerSearchCriteria;
import com.suranjan.model.PaginationCriteria;
import com.suranjan.service.AdminLoginService;
import com.suranjan.service.AdminSignupService;
import com.suranjan.service.CustomerService;
import com.suranjan.service.CustomerServiceImpl;



//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/customers")

public class AdminController {

	@Autowired
	private AdminSignupService adminSignupService;
	
	@Autowired
	private AdminLoginService adminLoginService;
	
	@Autowired
	public CustomerService customerService;
	
	@Autowired
	public CustomerServiceImpl customerServiceImpl;
	
	
	
//	@Autowired
//	private UserValidator userValidator;
//	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.setValidator(userValidator);
//	}
	
	
	//<----------------------------------------ADMIN SIGNUP CONTROLLER-------------------------------------------------->
	
	@PostMapping("admin/register")
	public ResponseEntity<AdminSignupData> registerAdminHandler( @RequestBody AdminSignupData adminSignupData ) throws AdminException{
		
		AdminSignupData registeredAdminData = adminSignupService.createNewAdmin(adminSignupData);
		
		return new ResponseEntity<AdminSignupData>(registeredAdminData, HttpStatus.CREATED);
	}
	
	//<----------------------------------------ADMIN LOGIN-LOGOUT CONTROLLER-------------------------------------------------->
	
	@PostMapping("/admin/login")
	public String loginHandler(  @RequestBody AdminLoginDTO loginData) throws LoginException {
		return adminLoginService.loginAdmin(loginData);
	}
	
	@PatchMapping("/admin/logout")
	public String logOutFromAccount(@RequestParam String key) throws LoginException
	{
		return adminLoginService.logOutAdmin(key);
	}
	
	//<----------------------------------------CUSTOMER CONTROLLER-------------------------------------------------->
	@PostMapping("/add/customer")
	public ResponseEntity<?> insertCustomerHandler (@Valid @RequestBody Customer customer, Errors errors) throws CustomerException{
		
//		if(errors.hasErrors()) {
//			
//			return new ResponseEntity<>(errors.getAllErrors(),HttpStatus.OK);
//		}
			
		Customer addCustomer = customerService.insertCustomer(customer);
		
		return new ResponseEntity<>(addCustomer,HttpStatus.OK);
	}
	
	@PutMapping("/update/customer/{id}")
	public ResponseEntity<Customer> updateCustomerHandler (@PathVariable Integer id, @RequestBody Customer customer) throws CustomerException{
		
		Customer updateCustomer = customerService.updateCustomer(id,customer);
		
		return new ResponseEntity<Customer>(updateCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/customer/{id}")
	public ResponseEntity<Customer> deleteCustomerHandler (@PathVariable Integer id) throws CustomerException{
		
		Customer removeCustomer = customerService.deleteCustomer(id);
		
		return new ResponseEntity<Customer>(removeCustomer,HttpStatus.OK);
	}
	
//	@CrossOrigin(origins = "http://localhost:8888")
	@GetMapping("/all/customers")
	public ResponseEntity< List<Customer>> getAllCustomerHandler () throws CustomerException{
		
		List<Customer> allCustomers =customerService.getAllCustomers();
		
		return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);
	}
	
	@PostMapping("/pagination/paginationdto")
	public ResponseEntity<Page<Customer>> getcustomer(@RequestBody PaginationDto paginationDto){
		
		String name =  paginationDto.getName();
	    String sortBy = paginationDto.getSortBy();
	    Integer pageNumber = paginationDto.getPageNumber();
	    Integer pageSize = paginationDto.getPageSize();
	    boolean direction = paginationDto.isDirection();
		
		         
		CustomerPage customerPage = new CustomerPage();
		CustomerSearchCriteria customerSearchCritaria =  new CustomerSearchCriteria();
		if(name != null)
		customerSearchCritaria.setCustomerName(name);
	    customerPage.setPageNumber( pageNumber);
	    customerPage.setPageSize(pageSize);
	    
	    if(direction == true) {
	    	customerPage.setSortDirection(Sort.Direction.DESC);
	    }
	    if(sortBy != null)
	    customerPage.setSortBy(sortBy);
	    
	    
	    
	   
	     
	    
	   
	    System.out.println(customerSearchCritaria);

		return new ResponseEntity<>(customerServiceImpl.getCustomers(customerPage, customerSearchCritaria),HttpStatus.OK);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity< Customer> getCustomerByIdHandler (@PathVariable Integer id) throws CustomerException{
		
		Customer customer =customerService.viewCustomer(id);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/sorted/customers/{field}")
	public ResponseEntity< List<Customer>> getAllAscSortedCustomerHandler (@PathVariable String field) throws CustomerException{
		
		List<Customer> allCustomersSortedAsc =customerService.findCustomerWithSorting(field);
		
		return new ResponseEntity<List<Customer>>(allCustomersSortedAsc,HttpStatus.OK);
	}
	
	@GetMapping("/paginated/customers/{offset}/{pageSize}")
	public ResponseEntity< Page<Customer>> getAllPaginatedCustomerHandler (@PathVariable int offset,@PathVariable int pageSize) throws CustomerException{
		
		Page<Customer> allCustomersPaginated =customerService.findCustomerWithPagination(offset, pageSize);
		
		return new ResponseEntity<Page<Customer>>(allCustomersPaginated,HttpStatus.OK);
	}
	
	
	@GetMapping("/paginated/sorted/customers/{offset}/{pageSize}/{field}")
	public ResponseEntity< Page<Customer>> getAllPaginatedAndSortedCustomerHandler (@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field) throws CustomerException{
		
		Page<Customer> allCustomersPaginated =customerService.findCustomerWithPaginationAndSorting(offset, pageSize,field);
		
		return new ResponseEntity<Page<Customer>>(allCustomersPaginated,HttpStatus.OK);
	}
	
	//<----------------------------------------ACCOUNT CONTROLLER-------------------------------------------------->

//	@PostMapping("/add/account")
//	public ResponseEntity<Account> insertAccountHandler (@RequestBody Account account) throws AccountException{
//		
//		Account addAccount = accountService.addAccount(account);
//		
//		return new ResponseEntity<Account>(addAccount,HttpStatus.OK);
//	}
//	
//	@PutMapping("/update/account")
//	public ResponseEntity<Account> updateAccountHandler (@RequestBody Account account) throws AccountException{
//		
//		Account updateAccount = accountService.updateAccount(account);
//		
//		return new ResponseEntity<Account>(updateAccount,HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/delete/account/{id}")
//	public ResponseEntity<Account> deleteAccountHandler (@PathVariable Integer id) throws AccountException{
//		
//		Account removeAccount = accountService.deleteAccount(id);
//		
//		return new ResponseEntity<Account>(removeAccount,HttpStatus.OK);
//	}
//	
//	@GetMapping("/account/{acno}")
//	public ResponseEntity<Account> getAccountByIdHandler (@PathVariable Integer acno) throws AccountException{
//		
//		Account account = accountService.getAccountDetails(acno);
//		
//		return new ResponseEntity<Account>(account,HttpStatus.OK);
//	}
	 
	
}
