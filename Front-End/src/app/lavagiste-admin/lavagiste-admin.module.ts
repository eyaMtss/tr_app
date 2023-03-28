import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LavagisteAdminRoutingModule } from './lavagiste-admin-routing.module';
import { LavagisteAdminComponent } from './lavagiste-admin.component';


@NgModule({
  declarations: [
    LavagisteAdminComponent
  ],
  imports: [
    CommonModule,
    LavagisteAdminRoutingModule
  ]
})
export class LavagisteAdminModule { }
