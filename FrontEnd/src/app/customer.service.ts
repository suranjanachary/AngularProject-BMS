import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from './api-response';
import { Customer } from './customer';
import { Page } from './page';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private baseURL = "http://localhost:8888/api/customers"
  
  constructor( private httpClient: HttpClient) {}

   getCustomersList(): Observable<Customer[]> {
   return this.httpClient.get<Customer[]>(`${this.baseURL}/all/customers`);
   
  }
  createCustomer(customer: Customer): Observable<Object>{
   return this.httpClient.post(`${this.baseURL}/add/customer`,customer) ;

  }
  updateCustomer(customerId:number,customer: Customer): Observable<Object>{
   return this.httpClient.put(`${this.baseURL}/update/customer/${customerId}`,customer) ;
 
  }
  findCustomerById(customerId: number): Observable<Customer>{
    return this.httpClient.get<Customer>(`${this.baseURL}/customer/${customerId}`) ;
  
  }

  deleteCustomerById(customerId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/delete/customer/${customerId}`) ;
  
  }
  
  getSortingDropDown(field: String): Observable<Customer []>{
    return this.httpClient.get<Customer[]>(`${this.baseURL}/sorted/customers/${field}`) ;
  }

  // Make call to the back end API to retrieve page of users
  
  users$ = (name: string = '', page: number = 0, size: number = 10): Observable<ApiResponse<Page>> => 
    this.httpClient.get<ApiResponse<Page>>(`${this.baseURL}/customers?name=${name}&page=${page}&size=${size}`);

}
