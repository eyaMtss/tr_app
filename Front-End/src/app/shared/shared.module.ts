import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddGarageComponent } from './components/add-garage/add-garage.component';
import { AddLavageComponent } from './components/add-lavage/add-lavage.component';
import { AddVehicleComponent } from './components/add-vehicle/add-vehicle.component';
import { AddressComponent } from './components/address/address.component';
import { ImmatriculationComponent } from './components/immatriculation/immatriculation.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { UploadFileComponent } from './components/upload-file/upload-file.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    AddGarageComponent,
    AddLavageComponent,
    AddVehicleComponent,
    AddressComponent,
    ImmatriculationComponent,
    NavbarComponent,
    UploadFileComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ],
  exports: [
    AddGarageComponent,
    AddLavageComponent,
    AddVehicleComponent,
    AddressComponent,
    ImmatriculationComponent,
    NavbarComponent,
    UploadFileComponent
  ]
})
export class SharedModule { }
