import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientRoutingModule } from './client-routing.module';
import { ClientComponent } from './client.component';
import { ServiceCardComponent } from './service-card/service-card.component';
import { ShareInformationComponent } from './share-information/share-information.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { GoogleMapsModule } from '@angular/google-maps';
import { GooglePlaceModule } from 'ngx-google-places-autocomplete';
import { NgxIntlTelInputModule } from 'ngx-intl-tel-input';
import { SendPictureComponent } from './send-picture/send-picture.component';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { WebcamModule } from 'ngx-webcam';
import { SidebarComponent } from './sidebar/sidebar.component';
import { AddressComponent } from './address/address.component';
import { ProfileClientComponent } from './profile-client/profile-client.component';


@NgModule({
  declarations: [
    ClientComponent,
    ServiceCardComponent,
    ShareInformationComponent,
    SendPictureComponent,
    SidebarComponent,
    AddressComponent,
    ProfileClientComponent
  ],
  imports: [
    CommonModule,
    ClientRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    GoogleMapsModule,
    GooglePlaceModule,
    NgxIntlTelInputModule,
    MatProgressSpinnerModule,
    WebcamModule,
  ]
})
export class ClientModule { }
