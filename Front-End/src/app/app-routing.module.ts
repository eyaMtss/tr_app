import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderComponent } from './order/order.component';
import { PickUpPassComponent } from './pick-up-pass/pick-up-pass.component';
import { RatingPageComponent } from './rating-page/rating-page.component';
import { SendPictureComponent } from './send-picture/send-picture.component';
import { ShareInformationComponent } from './share-information/share-information.component';
import { ShiftComponent } from './shift/shift.component';
import { UserInformationComponent } from './user-information/user-information.component';
import { AuthGuard } from './guard/auth.guard';
import { AccessDeniedComponent } from './access-denied/access-denied.component';

const routes: Routes = [

  {path: 'shareInformation', component: ShareInformationComponent},
  {path: 'access-denied', component: AccessDeniedComponent, canActivate: [AuthGuard]},
  {path: 'sendPicture', component: SendPictureComponent},
  {path: 'userInformation', component: UserInformationComponent},
  {path: 'rating', component: RatingPageComponent},
  {path: 'pass', component: PickUpPassComponent},
  {path: 'order', component: OrderComponent},
  {path: 'shift', component: ShiftComponent, canActivate:[AuthGuard], data: { roles: ['AGENCY_ADMIN']}},
  {path: '', redirectTo: 'auth', pathMatch: 'full'},

  { path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
