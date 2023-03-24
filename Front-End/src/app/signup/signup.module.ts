import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SignupRoutingModule } from './signup-routing.module';
import { SignupComponent } from './signup.component';
import { AddressComponent } from './address/address.component';
import { CredentialsComponent } from './credentials/credentials.component';
import { InformationsComponent } from './informations/informations.component';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    SignupComponent,
    AddressComponent,
    CredentialsComponent,
    InformationsComponent,
    AddVehicleComponent
  ],
  imports: [
    CommonModule,
    SignupRoutingModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class SignupModule { }
