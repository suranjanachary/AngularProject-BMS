import { HttpErrorResponse } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { BehaviorSubject, catchError, map, Observable, of, startWith } from 'rxjs';
import { ApiResponse } from './api-response';
import { Customer } from './customer';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerService } from './customer.service';
import { Page } from './page';

Injectable()
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Banking Application';

//pagination

    
  customers: Customer [];

  constructor(private customerService : CustomerService){}

  ngOnInit(): void {
   
  }
  getmeField(sortField : string){

      this.customerService.getSortingDropDown(sortField).subscribe( data => {
      this.customers =[...data];
      // console.log(data);

    })
   
  }
  
}
