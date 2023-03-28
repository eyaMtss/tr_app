import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgenceLocationAdminComponent } from './agence-location-admin.component';

const routes: Routes = [{ path: '', component: AgenceLocationAdminComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AgenceLocationAdminRoutingModule { }
