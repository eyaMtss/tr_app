import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CountryISO, SearchCountryField } from 'ngx-intl-tel-input';

@Component({
  selector: 'app-add-garage',
  templateUrl: './add-garage.component.html',
  styleUrls: ['./add-garage.component.css']
})
export class AddGarageComponent implements OnInit {
  CountryISO = CountryISO;
  SearchCountryField = SearchCountryField;

  garageForm: FormGroup;
  // garage 
  garageType: string = "";
  garageTypeValue!: string; // ngModel
  @Output() garageFormEvent = new EventEmitter<FormGroup>();
  
  zoom = 12;
  center!: google.maps.LatLngLiteral;
  options: google.maps.MapOptions = {
    mapTypeId: 'hybrid',
    zoomControl: false,
    scrollwheel: false,
    disableDoubleClickZoom: true,
    maxZoom: 15,
    minZoom: 8,
  };
  constructor(private _formBuilder: FormBuilder){
    this.garageForm = this._formBuilder.group({
      name: ["", Validators.required],
      capacity: ["", Validators.required],
      garageOwner: ["", Validators.required],
      email: ["", [Validators.required, Validators.email]],
      phone: ["", Validators.required],
      address: ["", Validators.required],
      garageType: ["", Validators.required]
    });
  }
  ngOnInit(): void {
    navigator.geolocation.getCurrentPosition((position) => {
      this.center = {
        lat: position.coords.latitude,
        lng: position.coords.longitude,
      };
    });
  }

  onGarageTypeChange(){
    let garageTypeValue = this.garageForm.controls['garageType'].value;
    console.log(garageTypeValue)
    console.log(garageTypeValue.includes("wrench"))
    if(garageTypeValue.includes("wrench")){
      this.garageType = "mecanique";
    }
    else if(garageTypeValue.includes("plug")){
      this.garageType = "electrique";
    }
    else if(garageTypeValue.includes("tire")){
      this.garageType = "pneumatique";
    }
    console.log(this.garageType);
  }

  onFormChange(){
    if(this.garageForm.valid){
        this.emitInformationForm(this.garageForm);
      } 
  }

  emitInformationForm(value: FormGroup) {
    this.garageFormEvent.emit(value);
  }
}
