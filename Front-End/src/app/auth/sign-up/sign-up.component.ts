import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BreakpointObserver } from '@angular/cdk/layout';
import { StepperOrientation } from '@angular/material/stepper';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})

export class SignUpComponent implements OnInit {
  // address


  stepperOrientation: Observable<StepperOrientation>; // stepper
  

  // addressForm
  addressForm: FormGroup;
  countries = [{ id: 1, value: "Tunisie" }, { id: 2, value: "Algerie" }, { id: 3, value: "Lybia" }];
  governorates: any[] = [];
  cities: any[] = [];

  // vehicule section when role = user
  maxVehicleNumber: number = 5; // 
  currentVehicleNumber: number = 1; // user must have at least 1 vehicule
  vehiculeValues: any[] = []; //user can have several vehicules, we put them in a list: vehiculeValues

  // credentialsForm
  credentialsForm: FormGroup;

  constructor(private _formBuilder: FormBuilder, breakpointObserver: BreakpointObserver) {
    // resposive stepper
    this.stepperOrientation = breakpointObserver
      .observe('(min-width: 800px)')
      .pipe(map(({ matches }) => (matches ? 'horizontal' : 'vertical')));

    

    this.addressForm = this._formBuilder.group({
      country: ["", Validators.required],
      governorate: ["", Validators.required],
      city: ["", Validators.required],
      zipCode: ["", Validators.required],
      homeCode: ["", Validators.required],
    });

    this.credentialsForm = this._formBuilder.group({
      username: ["", Validators.required],
      password: ["", Validators.required],
      confirmPassword: ["", Validators.required]
    });
  }

  ngOnInit(): void {
    this.addressForm.controls['country'].setValue(1); // country is setted to Tunisia
    this.onCountryChange(); // get Tunisia's governorates
    this.onAddVehicleBtn(); //by default, there is only one input of vehiculeValues
  }

  

  onCountryChange() { // get governorates depending on the selected country
    this.getGovernorates(this.addressForm.controls['country'].value);
  }

  onGovernorateChange() { // get cities depending on the selected country&&governorate
    this.getCities(this.addressForm.controls['country'].value, this.addressForm.controls['governorate'].value);
  }

  getGovernorates(country: number) {
    let governorate: string[] = [];
    let id: number = 0;
    switch (country) {
      case 1: {
        this.governorates.splice(0);
        governorate = ["Ariana", "Béja", "Ben Arous", "Bizerte", "Gabès", "Gafsa", "Jendouba", "Kairouan",
          "Kasserine", "Kebili", "Kef", "Mahdia", "Manouba", "Medenine", "Monastir", "Nabeul", "Sfax",
          "Sidi Bouzid", "Siliana", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan"];
        break;
      }
      case 2: {
        this.governorates.splice(0);
        governorate = ["Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa", "Biskra", "Béchar",
          "Blida", "Bouira", "Tamanrasset", "Tébessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Alger", "Djelfa",
          "Jijel", "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma", "Constantine", "Médéa",
          "Mostaganem", "Mascara", "Ouargla", "Oran", "M'Sila", "El Bayadh", "Illizi", "Bordj Bou Arreridj",
          "Boumerdès", "El Tarf", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipaza",
          "Mila", "Aïn Defla", "Naâma", "Aïn Témouchent", "Ghardaïa", "Relizane"];
        break;
      }
      /*case 3: {
        this.governorates.splice(0);
        governorate = [];
        break;
      }*/
    }
    governorate.forEach(e => this.governorates.push({ id: id + 1, value: e }));
  }

  getCities(country: number, governorate: number) {
    console.log(governorate)
    let cities: string[] = [];
    let id: number = 0;
    switch (country) {
      case 1: { // Tunisia
        switch (governorate) {
          case 1: { //ariana
            cities = ["Ariana", "Sokra", "ghazela"]
            break;
          }
          case 1: {

            break;
          }
        }
        break;
      }
    }
    cities.forEach(e => this.cities.push({ id: id + 1, value: e }));
  }

  

  onAddVehicleBtn() { // add a new vehicule
    if (this.vehiculeValues.length < this.maxVehicleNumber) {
      this.vehiculeValues.push({ value: "" });
      this.currentVehicleNumber += 1;
    }
  }

  onDeleteButton(i: any): void {  //delete the i input field for vehiculesValues list
    if (this.vehiculeValues.length == 1)   //always keep a field
      this.vehiculeValues[i].value = ""
    else {
      this.vehiculeValues.splice(i, 1);
      this.currentVehicleNumber -= 1;
    }
  }
}