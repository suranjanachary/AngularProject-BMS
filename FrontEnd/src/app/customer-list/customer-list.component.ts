import { Component, Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
@Injectable()
@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer [];

  constructor (private customerService: CustomerService, private router : Router ) {
    
  }
  // getmeField(cust : Customer []){
  //   this.customers = cust;
    
  //    this.customerService.getSortingDropDown(sortby).subscribe( data => {
  //      console.log(data);
  //      this.customers=data;
  //    })
  // }
  getmeField(sortField : string){

    this.customerService.getSortingDropDown(sortField).subscribe( data => {
    this.customers =[...data];
    // console.log(data);
  
  })
}
 
  ngOnInit(): void {
    
    this.getCustomers() 
 
  }

  private getCustomers(){
    this.customerService.getCustomersList().subscribe(data => {
      this.customers = data;
    });
  }

  updateCustomer(customerId: number){
      this.router.navigate(['update-customer',customerId])
  }

  deleteCustomer(customerId: number){

        this.customerService.deleteCustomerById(customerId).subscribe(data =>{
        console.log(data);
        this.getCustomers();
      })
  }
  customerDetails(customerId: number){
    this.router.navigate(['customer-details',customerId]);
  }
 }
