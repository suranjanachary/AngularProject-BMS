import { Component } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CustomerListComponent } from '../customer-list/customer-list.component';
import { CustomerService } from '../customer.service';
import { Pagination } from '../pagination';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent {

  
  pagination : Pagination = new Pagination();
  private currentPageSubject = new BehaviorSubject<number>(0);
  currentPage$ = this.currentPageSubject.asObservable();
  constructor(public customerListComponent : CustomerListComponent
  ,public customerService : CustomerService) { }
  
    ngOnInit(): void {
      
       
      //this.pagination.totalPages= 10;
      this.customerService.getPaginationData(0,8,"string","customertName",false).subscribe(data =>{
      
          this.pagination = data;
          console.log(this.pagination);
          this.currentPageSubject.next(data.pageable.pageNumber);
        })
     } 
     goToPage(name? : string , pageNumber : number = 0) {
       this.customerService.getPaginationData(pageNumber,8,"string","customerName",false).subscribe(data =>{
                
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
