import { HttpErrorResponse } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, catchError, map, Observable, of, startWith } from 'rxjs';
import { ApiResponse } from '../api-response';
import { Content } from '../content';
import { CustomerService } from '../customer.service';
import { Page } from '../page';
import { Pagination } from '../pagination'
@Injectable()
@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  // usersState$: Observable<{ appState: string, appData?: ApiResponse<Page>, error?: HttpErrorResponse }>;

  //   responseSubject = new BehaviorSubject<ApiResponse<Page>>(null);
  //   private currentPageSubject = new BehaviorSubject<number>(0);
  //   currentPage$ = this.currentPageSubject.asObservable();

  field: string;
  name: string;
  direction: boolean = false;
  pagination: Pagination;
  page: Page;
  customers: Content [] = [];
  pageNumber: number = 0;


  constructor(private customerService: CustomerService, private router: Router) {

  }
  // getmeField(cust : Customer []){
  //   this.customers = cust;

  //    this.customerService.getSortingDropDown(sortby).subscribe( data => {
  //      console.log(data);
  //      this.customers=data;
  //    })
  // }
  // getmeField(sortField: string) {

  //   this.customerService.getSortingDropDown(sortField).subscribe(data => {
  //     this.customers = [...data];
  //     console.log(data);

  //   })
  // }

  ngOnInit(): void {

    this.getCustomers();
    //  // this.loadingService.loadingOn();
    //  this.usersState$ = this.customerService.getUsers().pipe(
    //   map((response: ApiResponse<Page>) => {
    //     // this.loadingService.loadingOff();
    //     this.responseSubject.next(response);
    //     this.currentPageSubject.next(response.data.page.number);
    //     console.log(response);
    //     return ({ appState: 'APP_LOADED', appData: response });
    //   }),
    //   startWith({ appState: 'APP_LOADING' }),
    //   catchError((error: HttpErrorResponse) =>{ 
    //     // this.loadingService.loadingOff();
    //     return of({ appState: 'APP_ERROR', error })}
    //     )
    // ) 


      this.customerService.getPaginationData().subscribe(data => {
      this.pagination = data;
     
      this.pageNumber = this.pagination.totalPages;
      this.customers = data.content;
      console.log(data);
      console.log(this.pagination.content);
    })

  }

  private getCustomers() {

    if (this.field == undefined) {
      this.field = "customerName";
    }
    if (this.name == undefined) {
        this.customerService.getPaginationData(this.pageNumber, 8, "string", this.field, this.direction).subscribe(data => {
        this.pagination = data;
        this.customers = this.pagination.content;
        // console.log(this.pagination);
      })
    }
    else {
        this.customerService.getPaginationData(this.pageNumber, 8, this.name, this.field, this.direction).subscribe(data => {
        this.pagination = data;
        this.customers = this.pagination.content;
        // console.log(this.pagination);
      })
    }
  }
  updateCustomers(customers : Content []){
    this.customers = customers;
  }
  filter() {

    if (this.field == undefined) {
        this.field = "productName";
    }
    if (this.name == undefined || this.name == "") {
        this.customerService.getPaginationData(this.pageNumber, 8, "string", this.field, this.direction).subscribe(data => {
        this.pagination = data;
        this.customers = this.pagination.content;
        // console.log(this.pagination);
      })
    }
    else {
        this.customerService.getPaginationData(this.pageNumber, 8, this.name, this.field, this.direction).subscribe(data => {
        this.pagination = data;
        this.customers = this.pagination.content;
        // console.log(this.pagination);
      })
    }
  }
  sortByField() {
    if (this.field == undefined || this.field == "") {
       this.field = "customerName";
    }
    if (this.name == undefined) {
        this.customerService.getPaginationData(this.pageNumber, 8, "string", this.field, this.direction).subscribe(data => {
        this.pagination = data;
        this.customers = this.pagination.content;
        // console.log(this.pagination);
      })
    }
    else {
        this.customerService.getPaginationData(this.pageNumber, 8, this.name, this.field, this.direction).subscribe(data => {
        this.pagination = data;
        this.customers = this.pagination.content;
        // console.log(this.pagination);
      })
    }
  }
  sortBy(field: string) {
    this.field = field;
    this.sortByField();
  }
  order(flag: boolean) {
    this.direction = flag;
    this.sortByField();
  }

  // private getCustomers(){
  //   this.customerService.getCustomersList().subscribe(data => {
  //     this.customers = data;
  //   });
  // }

  updateCustomer(customerId: number) {
      this.router.navigate(['update-customer', customerId])
  }

  deleteCustomer(customerId: number) {

      this.customerService.deleteCustomerById(customerId).subscribe(data => {
      // console.log(data);
      this.getCustomers();
    })
  }
  customerDetails(customerId: number) {
      this.router.navigate(['customer-details', customerId]);
  }
}
