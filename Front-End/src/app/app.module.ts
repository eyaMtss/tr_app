import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ShareInformationComponent } from './share-information/share-information.component';
import { SendPictureComponent } from './send-picture/send-picture.component';
import { UserInformationComponent } from './user-information/user-information.component';
import { RatingPageComponent } from './rating-page/rating-page.component';
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
import {MatMenuModule} from '@angular/material/menu';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { QrCodeComponent } from './qr-code/qr-code.component';
import { QrCodeTestComponent } from './qr-code-test/qr-code-test.component';
import { QRCodeModule } from 'angularx-qrcode';
import { HttpClientModule } from '@angular/common/http';
import { NgxIntlTelInputModule } from "ngx-intl-tel-input";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { WebcamModule } from 'ngx-webcam';
import { GoogleMapsModule } from '@angular/google-maps'
import { GooglePlaceModule } from "ngx-google-places-autocomplete";

import { SuiviOrdreComponent } from './suivi-ordre/suivi-ordre.component';

           // @agm/core



@NgModule({

  declarations: [
    AppComponent,
    ShareInformationComponent,
    SendPictureComponent,
    UserInformationComponent,
    RatingPageComponent,
    PickUpPassComponent,
    OrderComponent,
    ShiftComponent,
    SuiviOrdreComponent,

    ShiftComponent,
    AccessDeniedComponent,
    NavbarComponent,
    QrCodeComponent,
    QrCodeTestComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule ,
    GooglePlaceModule,

    FormsModule,
    MatProgressSpinnerModule,
    ReactiveFormsModule,
    KeycloakAngularModule,
    HttpClientModule,
    MatMenuModule,
    BrowserAnimationsModule,
    QRCodeModule
    MatProgressSpinnerModule,
    HttpClientModule,
    NgxIntlTelInputModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    WebcamModule,
    GoogleMapsModule,


  ],
  providers: [
    KeycloakService,
    AuthService,
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
    /*{
      provide: HTTP_INTERCEPTORS,
      useClass: RequestInterceptor,
      multi: true
    },*/
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
