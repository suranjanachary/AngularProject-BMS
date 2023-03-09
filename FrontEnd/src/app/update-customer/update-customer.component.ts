import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  customerId:number
  customer : Customer = new Customer();
  
  constructor(private customerService: CustomerService, private route : ActivatedRoute, private router : Router){

  }

  ngOnInit(): void {
    this.customerId = this.route.snapshot.params['customerId'];
    this.customerService.findCustomerById(this.customerId).subscribe(data => {
      this.customer = data;
    },
    error=> console.log(error));
  }

  // updateCustomer(){
  //   this.customerService.updateCustomer(this.customerId,this.customer).subscribe( data=>{
  //     console.log(data);
  //     this.customer =  new Customer();
  //     this.goToCustomerList();
  //   },

  //   error => console.log(error))
  // }
  goToCustomerList() {
    this.router.navigate(['/all/customers']);
  }

  onSubmit(){
    this.customerService.updateCustomer(this.customerId, this.customer).subscribe(data =>{
      this.goToCustomerList();
      console.log(this.customer);
      // this.updateCustomer();
    },
    error => console.log(error));
  }

}
