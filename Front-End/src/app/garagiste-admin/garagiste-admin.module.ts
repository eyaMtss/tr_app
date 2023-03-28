import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GaragisteAdminRoutingModule } from './garagiste-admin-routing.module';
import { GaragisteAdminComponent } from './garagiste-admin.component';


@NgModule({
  declarations: [
    GaragisteAdminComponent
  ],
  imports: [
    CommonModule,
    GaragisteAdminRoutingModule
  ]
})
export class GaragisteAdminModule { }
