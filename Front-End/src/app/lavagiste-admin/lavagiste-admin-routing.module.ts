import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LavagisteAdminComponent } from './lavagiste-admin.component';

const routes: Routes = [{ path: '', component: LavagisteAdminComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LavagisteAdminRoutingModule { }
