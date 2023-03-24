import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './signup.component';
import { SignupGuard } from '../guard/signup.guard';

const routes: Routes = [
  { path: '', component: SignupComponent, canActivate: [SignupGuard] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SignupRoutingModule { }
