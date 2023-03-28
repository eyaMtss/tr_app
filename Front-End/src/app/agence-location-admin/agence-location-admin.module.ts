import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgenceLocationAdminRoutingModule } from './agence-location-admin-routing.module';
import { AgenceLocationAdminComponent } from './agence-location-admin.component';


@NgModule({
  declarations: [
    AgenceLocationAdminComponent
  ],
  imports: [
    CommonModule,
    AgenceLocationAdminRoutingModule
  ]
})
export class AgenceLocationAdminModule { }
