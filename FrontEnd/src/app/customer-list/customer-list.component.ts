import { HttpErrorResponse } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, catchError, map, Observable, of, startWith } from 'rxjs';
import { ApiResponse } from '../api-response';
import { Content } from '../content';
import { CustomerService } from '../customer.service';
import { Page } from '../page';
import { Pagination } from '../pagination'
import { PaginationDto } from '../paginationDto';
@Injectable()
@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  field: string;
  pageSize : number = 3;
  name: string;
  direction: boolean = false;
  pagination: Pagination = new Pagination();
  customers: Content [] = [];
  pageNumber: number = 0;
  paginationDto : PaginationDto = new PaginationDto();

  private currentPageSubject = new BehaviorSubject<number>(0);
  currentPage$ = this.currentPageSubject.asObservable();

  constructor(private customerService: CustomerService, private router: Router) {

  }
  
  ngOnInit(): void {
    this.paginationDto.pageNumber = 0;
    this.paginationDto.pageSize  = this.pageSize;
    this.paginationDto.sortBy = "customerName";
    this.paginationDto.direction = false;
     
    //this.pagination.totalPages= 10;
    this.customerService.getPaginationData(this.paginationDto).subscribe(data =>{
   
      this.pagination = data;
     
      this.pageNumber = this.pagination.totalPages;
      this.customers = data.content;
      console.log(data);
      console.log(this.pagination.content);
    })

  }

  // private getCustomers() {

    
    
  //     // this.pagintaiondto.pagenumber = this.pageNumber;
  //     this.paginationDto.pageNumber = this.pageNumber;
  //     this.paginationDto.pageSize  =3 ;
  //     this.paginationDto.name = this.name;
  //     this.paginationDto.sortBy = this.field;
  //     this.paginationDto.direction = this.direction;
       
  //     //this.pagination.totalPages= 10;
  //     this.customerService.getPaginationData(this.paginationDto).subscribe(data =>{
  //       this.pagination = data;
  //       this.customers = this.pagination.content;
  //       // console.log(this.pagination);
  //     })
    
  // }
  updateCustomers(customers : Content []){
    this.customers = customers;
  }
  filter() {

      this.paginationDto.pageNumber = 0;
      this.paginationDto.pageSize  = this.pageSize;
      this.paginationDto.name = this.name;
      console.log(this.paginationDto.name);
      this.paginationDto.sortBy = "customerName";
      this.paginationDto.direction = this.direction;
       
      //this.pagination.totalPages= 10;
      this.customerService.getPaginationData(this.paginationDto).subscribe((data) =>{
        
        console.log(data);

        this.pagination = data;
        this.customers = data.content;
        console.log(this.customers);
        // console.log("suranjan");
        // console.log(this.name,this.pageNumber,this.field,this.direction);
      })
    
  }

  selectOrder(flag : boolean){
  this.direction = flag;
  this.sortByField();
  }

  selectSize(size : number){
   this.pageSize= size;
   this.sortByField();
  
  }

  sortByField() {
    this.paginationDto.pageNumber = 0;
      this.paginationDto.pageSize  =this.pageSize ;

      this.paginationDto.name = this.name;
      this.paginationDto.sortBy = this.field;
      this.paginationDto.direction = this.direction;
      if(this.paginationDto.name == undefined){
        this.paginationDto.name = "";
      }
       
      //this.pagination.totalPages= 10;
      this.customerService.getPaginationData(this.paginationDto).subscribe(data =>{
        this.pagination = data;
        this.customers = this.pagination.content;
        console.log(this.pagination);
      })
    
  }
  getmeField(field: string) {
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
      //this.getCustomers();
    })
  }
  customerDetails(customerId: number) {
      this.router.navigate(['customer-details', customerId]);
  }

  goToPage(name? : string , pageNumber? : number) {

    this.paginationDto.pageNumber = pageNumber;
    // this.pageNumber = pageNumber;
    this.paginationDto.pageSize  = this.pageSize;
    this.paginationDto.sortBy = "customerName";
    this.paginationDto.direction = false;

      this.customerService.getPaginationData(this.paginationDto).subscribe(data =>{
        this.pagination = data;
        console.log(this.pagination);
        this.customers = data.content;
        this.currentPageSubject.next(pageNumber);
       
        })
    
  }
  goToNextOrPreviousPage(direction? : string,name? : string){
    this.goToPage(name,direction === 'forward' ? this.currentPageSubject.value + 1 :this.currentPageSubject.value-1) ;
  }

}
