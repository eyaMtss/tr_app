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
import { AuthService } from './services/authentication/auth.service';
import { initializer } from './utils/app-init';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';


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
    ForgotPasswordComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule ,
    FormsModule,
    MatProgressSpinnerModule,
    ReactiveFormsModule,
    KeycloakAngularModule
  ],
  providers: [
    KeycloakService,
    AuthService,
    {
      provide: APP_INITIALIZER, 
      useFactory: initializer,
      multi: true,
      deps: [KeycloakService]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
