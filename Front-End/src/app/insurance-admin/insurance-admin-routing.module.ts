import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InsuranceAdminComponent } from './insurance-admin.component';

const routes: Routes = [{ path: '', component: InsuranceAdminComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InsuranceAdminRoutingModule { }
