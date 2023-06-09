import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { OrderComponent } from './order/order.component';
import { PickUpPassComponent } from './pick-up-pass/pick-up-pass.component';

import { SuiviOrdreComponent } from './suivi-ordre/suivi-ordre.component';
import { UserInformationComponent } from './user-information/user-information.component';
import { AuthGuard } from './guard/auth.guard';
import { AccessDeniedComponent } from './access-denied/access-denied.component';
import { QrCodeTestComponent } from './qr-code-test/qr-code-test.component';
import { RatingComponent } from './rating/rating.component';
import { HomeComponent } from './home/home.component';
import { MultiComponent } from './multi/multi.component';
import { CompleteRegistrationComponent } from './complete-registration/complete-registration.component';
import { SignupGuard } from './guard/signup.guard';
import { RegistrationGuard } from './guard/registration.guard';
import { LoginCamionComponent } from './login-camion/login-camion.component';
import { SocieteDeRemorquageComponent } from './societe-de-remorquage/societe-de-remorquage.component';
import { ShiftComponent } from './shift/shift.component';
import { ProfilclientComponent } from './profilclient/profilclient.component';
import { TaComponent } from './ta/ta.component';
import { DrivercamionComponent } from './drivercamion/drivercamion.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'signup', loadChildren: () => import('./signup/signup.module').then(m => m.SignupModule), canActivate: [SignupGuard] },
  { path: 'access-denied', component: AccessDeniedComponent, canActivate: [AuthGuard] },
  { path: 'tunidesign', component: MultiComponent, canActivate: [AuthGuard, RegistrationGuard] },
  { path: 'complete-registration', component: CompleteRegistrationComponent },
  { path: 'camion-login', component: LoginCamionComponent },

 
  {path: 'profil', component: ProfilclientComponent},
  {path: 'userInformation', component: UserInformationComponent},
  {path: 'rating', component: RatingComponent},
  {path: 'pass', component: PickUpPassComponent},
  {path: 'order', component: OrderComponent},
  {path: 'suivi', component: SuiviOrdreComponent},
  {path: 'shift', component: ShiftComponent},
  { path: 'qrcode', component: QrCodeTestComponent},
  
  {path: 'ta', component: TaComponent, canActivate:[AuthGuard], data: { roles: ['TA']}},
  {path: 'drivercamion', component: DrivercamionComponent, canActivate:[AuthGuard], data: { roles: ['DRIVER']}},
  {path: 'societe', component: SocieteDeRemorquageComponent, canActivate:[AuthGuard], data: { roles: ['SOCIETE_REMORQUAGE']}},

  { path: 'garagisteAdmin', loadChildren: () => import('./garagiste-admin/garagiste-admin.module').then(m => m.GaragisteAdminModule),
    canActivate:[AuthGuard], data: { roles: ['GARAGISTE_ADMIN']} },
  { path: 'insuranceAdmin', loadChildren: () => import('./insurance-admin/insurance-admin.module').then(m => m.InsuranceAdminModule), 
    canActivate:[AuthGuard], data: { roles: ['INSURANCE_ADMIN']} },
  { path: 'agenceLocationAdmin', loadChildren: () => import('./agence-location-admin/agence-location-admin.module').then(m => m.AgenceLocationAdminModule), 
    canActivate:[AuthGuard], data: { roles: ['AGENCE_LOCATION_ADMIN']} },
  { path: 'client', loadChildren: () => import('./client/client.module').then(m => m.ClientModule), 
    canActivate:[AuthGuard], data: { roles: ['CLIENT']} },
  { path: 'lavagisteAdmin', loadChildren: () => import('./lavagiste-admin/lavagiste-admin.module').then(m => m.LavagisteAdminModule), 
    canActivate:[AuthGuard], data: { roles: ['LAVAGISTE_ADMIN']} },
  { path: 'driver', loadChildren: () => import('./driver/driver.module').then(m => m.DriverModule),
    canActivate:[AuthGuard], data: { roles: ['DRIVER']}},
  { path: 'expert', loadChildren: () => import('./expert/expert.module').then(m => m.ExpertModule),
    canActivate:[AuthGuard], data: { roles: ['EXPERT']} },



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
