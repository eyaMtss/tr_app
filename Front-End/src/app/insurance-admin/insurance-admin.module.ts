import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InsuranceAdminRoutingModule } from './insurance-admin-routing.module';
import { InsuranceAdminComponent } from './insurance-admin.component';


@NgModule({
  declarations: [
    InsuranceAdminComponent
  ],
  imports: [
    CommonModule,
    InsuranceAdminRoutingModule
  ]
})
export class InsuranceAdminModule { }
