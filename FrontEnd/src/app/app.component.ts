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

    usersState$: Observable<{ appState: string, appData?: ApiResponse<Page>, error?: HttpErrorResponse }>;
    responseSubject = new BehaviorSubject<ApiResponse<Page>>(null);
    private currentPageSubject = new BehaviorSubject<number>(0);
    currentPage$ = this.currentPageSubject.asObservable();

  customers: Customer [];

  constructor(private customerService : CustomerService){}

  ngOnInit(): void {
    // this.loadingService.loadingOn();
    this.usersState$ = this.customerService.users$().pipe(
      map((response: ApiResponse<Page>) => {
        // this.loadingService.loadingOff();
        this.responseSubject.next(response);
        this.currentPageSubject.next(response.data.page.number);
        console.log(response);
        return ({ appState: 'APP_LOADED', appData: response });
      }),
      startWith({ appState: 'APP_LOADING' }),
      catchError((error: HttpErrorResponse) =>{ 
        // this.loadingService.loadingOff();
        return of({ appState: 'APP_ERROR', error })}
        )
    )
  }
  getmeField(sortField : string){

      this.customerService.getSortingDropDown(sortField).subscribe( data => {
      this.customers =[...data];
      // console.log(data);

    })
   
  }
  
}
