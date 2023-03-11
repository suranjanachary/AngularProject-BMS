import { Component } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CustomerListComponent } from '../customer-list/customer-list.component';
import { CustomerService } from '../customer.service';
import { Pagination } from '../pagination';
import { PaginationDto } from '../paginationDto';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent {

  
  pagination : Pagination = new Pagination();
  paginationDto : PaginationDto = new PaginationDto();
  private currentPageSubject = new BehaviorSubject<number>(0);
  currentPage$ = this.currentPageSubject.asObservable();
  constructor(public customerListComponent : CustomerListComponent
  ,public customerService : CustomerService) { }
  
    ngOnInit(): void {
      this.paginationDto.pageNumber = 0;
      this.paginationDto.pageSize  = 5 ;
      this.paginationDto.sortBy = "customerName";
      this.paginationDto.direction = false;
       
      //this.pagination.totalPages= 10;
      this.customerService.getPaginationData(this.paginationDto).subscribe(data =>{
      
          this.pagination = data;
          console.log(this.pagination);
          this.currentPageSubject.next(data.pageable.pageNumber);
        })
     } 
     goToPage(name? : string , pageNumber : number = 0) {
      this.paginationDto.pageNumber = pageNumber;
      this.paginationDto.pageSize  =3 ;
      this.paginationDto.sortBy = "customerName";
      this.paginationDto.direction = false;
       
      //this.pagination.totalPages= 10;
      this.customerService.getPaginationData(this.paginationDto).subscribe(data =>{
                
              this.pagination = data;
              console.log(this.pagination);
              this.currentPageSubject.next(pageNumber);
              this.customerListComponent.updateCustomers(this.pagination.content);
            })
        } 
      goToNextOrPreviousPage(direction? : string,name? : string){
        this.goToPage(name,direction === 'forward' ? this.currentPageSubject.value + 1 :this.currentPageSubject.value-1) ;
      }
}
