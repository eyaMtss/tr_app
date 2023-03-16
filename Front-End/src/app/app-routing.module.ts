import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { OrderComponent } from './order/order.component';
import { PickUpPassComponent } from './pick-up-pass/pick-up-pass.component';
import { RatingPageComponent } from './rating-page/rating-page.component';
import { SendPictureComponent } from './send-picture/send-picture.component';
import { ShareInformationComponent } from './share-information/share-information.component';
import { ShiftComponent } from './shift/shift.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SuiviOrdreComponent } from './suivi-ordre/suivi-ordre.component';
import { UserInformationComponent } from './user-information/user-information.component';

const routes: Routes = [

  {path: 'share', component: ShareInformationComponent},
  {path: 'signUp', component: SignUpComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'picture', component: SendPictureComponent},
  {path: 'userInformation', component: UserInformationComponent},
  {path: 'rating', component: RatingPageComponent},
  {path: 'pass', component: PickUpPassComponent},
  {path: 'order', component: OrderComponent},
  {path: 'shift', component: ShiftComponent},
  {path: 'suivi', component: SuiviOrdreComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
