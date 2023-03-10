import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { AppRoutingModule } from './customer-list/app-routing-module';
import { CreateCustomersComponent } from './create-customers/create-customers.component';
import { FormsModule } from '@angular/forms';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './header/header.component';
import { PaginationComponent } from './pagination/pagination.component'
@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    CreateCustomersComponent,
    UpdateCustomerComponent,
    CustomerDetailsComponent,

    HeaderComponent,
     PaginationComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    // DropdownDirective 
  ],
  providers: [AppComponent,CustomerListComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
