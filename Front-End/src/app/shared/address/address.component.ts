import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {
  addressForm: FormGroup;
  country: any
  governorates: any;
  citiesJSON: any;
  cities!: any;
  countries = [{ id: "TUN", value: "Tunisie" }, { id: "LYB", value: "Libye" }, { id: "ALG", value: "Algérie" }, { id: "FR", value: "France" }];


  @Output() addressFormEvent = new EventEmitter<FormGroup>();


  constructor(private _formBuilder: FormBuilder, private httpClient: HttpClient) {
    this.addressForm = this._formBuilder.group({
      country: ["TUN", Validators.required],
      governorate: ["", Validators.required],
      city: ["", Validators.required],
      zipCode: ["", [Validators.required, Validators.minLength(4), Validators.maxLength(4)]],
      homeCode: ["", Validators.required],
    });
  }

  ngOnInit(): void {
    this.addressForm.controls['country'].setValue("TUN"); // country is setted to Tunisia
  }


  onCountryChange(e: any) {
    this.addressForm.controls['country'].setValue(e.target.value);
    this.httpClient.get('assets/address/gouv.json').subscribe(data => {
      console.log(data);
      this.governorates = data
    });
  }

  onGovernorateChange(e: any) {
    let governorate = e.target.value;
    this.addressForm.controls['governorate'].setValue(governorate);

    this.httpClient.get('assets/address/data.json').subscribe((data: any) => {
      console.log(data);
      this.citiesJSON = Object.entries(data);
      let currentGovernorateName = this.governorates.filter((gov:any) => gov.id == governorate)[0].name;
      this.cities = (this.citiesJSON.filter((e: any) => e[0] == currentGovernorateName)[0])[1];
    });
  }

  onCityChange(e: any) {
    let city = e.target.value;
    this.addressForm.controls['city'].setValue(city);
    let zipCode = this.cities.filter((e: any) => e.ville == city)[0].code_postal;
    this.addressForm.controls['zipCode'].setValue(zipCode);
  }

  onFormChange() {
    if (this.addressForm.valid) {
      this.emitInformationForm(this.addressForm);
    }
  }

  emitInformationForm(value: FormGroup) {
    this.addressFormEvent.emit(value);
  }
}
