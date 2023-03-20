import { NgModule } from '@angular/core';
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
    LoginPageComponent,
    SignUpComponent,
    ShareInformationComponent,
    SendPictureComponent,
    UserInformationComponent,
    RatingPageComponent,
    PickUpPassComponent,
    OrderComponent,
    ShiftComponent,
    SuiviOrdreComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule ,
    GooglePlaceModule,

    FormsModule,
    MatProgressSpinnerModule,
    HttpClientModule,
    NgxIntlTelInputModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    WebcamModule,
    GoogleMapsModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
