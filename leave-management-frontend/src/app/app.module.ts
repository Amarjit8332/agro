import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LeaveApplicationComponent } from './leave-application/leave-application.component';
import { ManagerApprovalComponent } from './manager-approval/manager-approval.component';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { LeaveRequestService } from './leave-request.service';

const routes: Routes = [
  {path:"", component: LeaveApplicationComponent},
  { path: 'leave-application', component: LeaveApplicationComponent },
  { path: 'manager-approval', component: ManagerApprovalComponent }
  
];
@NgModule({
  declarations: [
    AppComponent,
    LeaveApplicationComponent,
    ManagerApprovalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    [RouterModule.forRoot(routes)]
  ],
  providers: [LeaveRequestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
