import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {
  addressForm: FormGroup;
  countries = [{ id: 1, value: "Tunisie" }, { id: 2, value: "Algerie" }, { id: 3, value: "Lybia" }];
  governorates: any[] = [];
  cities: any[] = [];

  @Output() addressFormEvent = new EventEmitter<FormGroup>();
  
  constructor(private _formBuilder: FormBuilder){
    this.addressForm = this._formBuilder.group({
      country: ["", Validators.required],
      governorate: ["", Validators.required],
      city: ["", Validators.required],
      zipCode: ["", Validators.required],
      //homeCode: [{value: "", disabled: true}, Validators.required],
    });
  }

  ngOnInit(): void {
    this.addressForm.controls['country'].setValue(1); // country is setted to Tunisia
    this.onCountryChange(); // get Tunisia's governorates
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

  onFormChange(){
    if(this.addressForm.valid){
      console.log(this.addressForm.valid)
      this.emitInformationForm(this.addressForm);
    } 
  }

  emitInformationForm(value: FormGroup) {
    this.addressFormEvent.emit(value);
  }
}
