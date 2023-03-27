import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { OrderComponent } from './order/order.component';
import { PickUpPassComponent } from './pick-up-pass/pick-up-pass.component';
import { SendPictureComponent } from './send-picture/send-picture.component';
import { ShareInformationComponent } from './share-information/share-information.component';
import { ShiftComponent } from './shift/shift.component';

import { SuiviOrdreComponent } from './suivi-ordre/suivi-ordre.component';
import { UserInformationComponent } from './user-information/user-information.component';
import { AuthGuard } from './guard/auth.guard';
import { AccessDeniedComponent } from './access-denied/access-denied.component';
import { QrCodeTestComponent } from './qr-code-test/qr-code-test.component';
import { RatingComponent } from './rating/rating.component';
import { ProfilclientComponent } from './profilclient/profilclient.component';
import { HomeComponent } from './home/home.component';
import { MultiComponent } from './multi/multi.component';
import { CompleteRegistrationComponent } from './complete-registration/complete-registration.component';
import { SignupGuard } from './guard/signup.guard';
import { RegistrationGuard } from './guard/registration.guard';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'signup', loadChildren: () => import('./signup/signup.module').then(m => m.SignupModule), canActivate: [SignupGuard] },
  { path: 'access-denied', component: AccessDeniedComponent, canActivate: [AuthGuard] },
  { path: 'tunidesign', component: MultiComponent, canActivate: [AuthGuard, RegistrationGuard] },
  { path: 'complete-registration', component: CompleteRegistrationComponent },

  {path: 'shareInformation', component: ShareInformationComponent},
  {path: 'share', component: ShareInformationComponent},
  {path: 'picture', component: SendPictureComponent},
  {path: 'userInformation', component: UserInformationComponent},
  {path: 'rating', component: RatingComponent},
  {path: 'pass', component: PickUpPassComponent},
  {path: 'order', component: OrderComponent},
  {path: 'suivi', component: SuiviOrdreComponent},
  {path: 'shift', component: ShiftComponent, canActivate:[AuthGuard], data: { roles: ['AGENCY_ADMIN']}},
  { path: 'qrcode', component: QrCodeTestComponent},
  { path: 'profilclient/:id', component: ProfilclientComponent},

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
