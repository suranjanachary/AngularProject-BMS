import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';


@Component({
  selector: 'app-create-customers',
  templateUrl: './create-customers.component.html',
  styleUrls: ['./create-customers.component.css']
})
export class CreateCustomersComponent implements OnInit {
  

  customer : Customer = new Customer();
  
  constructor(private customerService: CustomerService, private router : Router){

  }

  ngOnInit(): void {
    
  }

  saveCustomer(){
    this.customerService.createCustomer(this.customer).subscribe( data=>{
      console.log(data);
      this.goToCustomerList();
    },

    error => console.log(error))
  }

  goToCustomerList(){
    this.router.navigate(['all/customers'])
  }

  onSubmit(){
    console.log(this.customer);
    this.saveCustomer();
  }
}
