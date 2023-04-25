import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DriverRoutingModule } from './driver-routing.module';
import { DriverComponent } from './driver.component';
import { GooglePlaceModule } from 'ngx-google-places-autocomplete';
import { GoogleMapsModule } from '@angular/google-maps';


@NgModule({
  declarations: [
    DriverComponent
  ],
  imports: [
    CommonModule,
    DriverRoutingModule,
    GoogleMapsModule,
    GooglePlaceModule,

  ]
})
export class DriverModule { }
