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
import { NgxIntlTelInputModule } from 'ngx-intl-tel-input';
import { AddOfficeComponent } from './components/add-office/add-office.component';
import { ContactSectionComponent } from './components/contact-section/contact-section.component';
import { GoogleMapsModule } from '@angular/google-maps';
import { GooglePlaceModule } from 'ngx-google-places-autocomplete';
@NgModule({
  declarations: [
    AddGarageComponent,
    AddLavageComponent,
    AddVehicleComponent,
    AddressComponent,
    ImmatriculationComponent,
    NavbarComponent,
    UploadFileComponent,
    AddOfficeComponent,
    ContactSectionComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    NgxIntlTelInputModule,
    GoogleMapsModule,
    GooglePlaceModule,
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
