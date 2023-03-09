import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit{
customerId: number;
customer: Customer;

  constructor(private customerService: CustomerService, private route: ActivatedRoute){

  }
  ngOnInit(): void {
    this.customerId = this.route.snapshot.params['customerId'];
    this.customer = new Customer();
    this.customerService.findCustomerById(this.customerId).subscribe( data=>{
      console.log(data);
      this.customer=data;
    })
  }



}
