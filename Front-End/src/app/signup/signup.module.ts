import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SignupRoutingModule } from './signup-routing.module';
import { SignupComponent } from './signup.component';
import { InformationsComponent } from './informations/informations.component';
import { CredentialsComponent } from './credentials/credentials.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    SignupComponent,
    CredentialsComponent,
    InformationsComponent,
  ],
  imports: [
    CommonModule,
    SignupRoutingModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class SignupModule { }
