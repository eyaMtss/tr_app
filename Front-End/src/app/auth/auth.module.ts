import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { AuthComponent } from './auth.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import {MatStepperModule} from '@angular/material/stepper';
import {MatInputModule} from '@angular/material/input';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import { MatNativeDateModule, MatOptionModule } from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatDividerModule} from '@angular/material/divider';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import { InformationsComponent } from './informations/informations.component';
@NgModule({
  declarations: [
    AuthComponent,
    ForgotPasswordComponent,
    SignUpComponent,
    AddVehicleComponent,
    InformationsComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    MatStepperModule,
    MatInputModule,
    MatRadioModule,
    MatSelectModule,
    MatOptionModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatDividerModule,
    MatTooltipModule

  ],
  providers: [
    MatDatepickerModule
  ]
})
export class AuthModule { }
