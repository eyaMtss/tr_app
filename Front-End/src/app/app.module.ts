import { APP_INITIALIZER, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ShareInformationComponent } from './share-information/share-information.component';
import { SendPictureComponent } from './send-picture/send-picture.component';
import { UserInformationComponent } from './user-information/user-information.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PickUpPassComponent } from './pick-up-pass/pick-up-pass.component';
import { OrderComponent } from './order/order.component';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { ShiftComponent } from './shift/shift.component';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { AuthService } from './services/auth/auth.service';
import { initializer } from './utils/auth/app-init';
import { AccessDeniedComponent } from './access-denied/access-denied.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { ErrorsCatchingInterceptor } from './httpInterceptor/errors-catching.interceptor';
import { RequestInterceptor } from './httpInterceptor/request.interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { QrCodeComponent } from './qr-code/qr-code.component';
import { QrCodeTestComponent } from './qr-code-test/qr-code-test.component';
import { QRCodeModule } from 'angularx-qrcode';

import { NgxIntlTelInputModule } from "ngx-intl-tel-input";

import { WebcamModule } from 'ngx-webcam';

import { GooglePlaceModule } from "ngx-google-places-autocomplete";

import { SuiviOrdreComponent } from './suivi-ordre/suivi-ordre.component';
import { RatingComponent } from './rating/rating.component';
import { ProfilclientComponent } from './profilclient/profilclient.component';
import { AuthGuard } from './guard/auth.guard';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { GoogleMapsModule } from '@angular/google-maps';
import { HomeComponent } from './home/home.component';
import { MultiComponent } from './multi/multi.component';
import { CompleteRegistrationComponent } from './complete-registration/complete-registration.component';
import { SignupGuard } from './guard/signup.guard';
import { RegistrationGuard } from './guard/registration.guard';
import { AddressComponent } from './address/address.component';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import { ImmatriculationComponent } from './shared/immatriculation/immatriculation.component';
import { SocieteDeRemorquageComponent } from './societe-de-remorquage/societe-de-remorquage.component';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({

  declarations: [
    AppComponent,
    ShareInformationComponent,
    SendPictureComponent,
    UserInformationComponent,
    PickUpPassComponent,
    OrderComponent,
    ShiftComponent,
    SuiviOrdreComponent,
    AccessDeniedComponent,
    NavbarComponent,
    QrCodeComponent,
    QrCodeTestComponent,
    RatingComponent,
    ProfilclientComponent,
    HomeComponent,
    MultiComponent,
    CompleteRegistrationComponent,
    AddressComponent,
    AddVehicleComponent, ImmatriculationComponent, SocieteDeRemorquageComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule ,
    FormsModule,
    MatProgressSpinnerModule,
    ReactiveFormsModule,
    KeycloakAngularModule,
    HttpClientModule,
    BrowserAnimationsModule,
    QRCodeModule,
    MatProgressSpinnerModule,
    HttpClientModule,
    NgxIntlTelInputModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    WebcamModule,
    GoogleMapsModule,
    GooglePlaceModule,
    NgxPaginationModule


  ],
  providers: [
    KeycloakService,
    AuthService,
    AuthGuard,
    SignupGuard,
    RegistrationGuard,
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      multi: true,
      deps: [KeycloakService]
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorsCatchingInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: RequestInterceptor,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
