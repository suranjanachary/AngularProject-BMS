import { NgModule } from "@angular/core";
import { Routes, RouterModule} from '@angular/router';
import { CreateCustomersComponent } from "../create-customers/create-customers.component";
import { CustomerDetailsComponent } from "../customer-details/customer-details.component";

import { UpdateCustomerComponent } from "../update-customer/update-customer.component";
import { CustomerListComponent } from "./customer-list.component";

const routes: Routes = [
    {path: 'customers',component: CustomerListComponent},
    {path: 'create-customer', component:  CreateCustomersComponent},
    {path: 'update-customer/:customerId', component: UpdateCustomerComponent},
    {path: 'customer-details/:customerId' , component: CustomerDetailsComponent},
   
    {path: '', redirectTo: 'customers', pathMatch:'full'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{ }