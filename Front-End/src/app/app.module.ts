import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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
    AccessDeniedComponent,
    NavbarComponent,
    QrCodeComponent

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
    MatMenuModule,
    BrowserAnimationsModule
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
