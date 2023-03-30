import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent {
  registrationTypes = [{id: 1, value: "Série Normale (TU)"}, {id: 2, value: "Régime Suspensif (RS)"},
  {id: 3, value: "Moto (MOTO)"}, {id: 4, value: "Tracteur (TRAC)"}, {id: 5, value: "Personnel Administratif et Technique (PAT)"},
  {id: 6, value: "Chef de Mission Diplomatique (CMD)"}, {id: 7, value: "Corps Diplomatique (CD)"},
  {id: 8, value: "Misiion Diplomatique (MD)"}, {id: 9, value: "Misiion Consulaire (MC)"}, 
  {id: 10, value: "Corps Consulaire (CC)"}, {id: 11, value: "Remorque (REM)"}, 
  {id: 12, value: "Appareil Agricol (AA)"}, {id: 13, value: "Engin Spécial (ES)"}, {id: 14, value: "Propriété de l'Etat (PE)"},
  {id: 15, value: "Immatriculation Temporaire (IT)"}, {id: 16, value: "Immatriculation Etrangère ou Douanière"}]
  
  brands = [{id: 1, value: "Alfa Romeo"}, {id: 2, value: "Audi"}, {id: 3, value: "BMW"}, 
  {id: 4, value: "Citroën"}, {id: 5, value: "DACIA"}, {id: 6, value: "Fiat"}, {id: 7, value: "Ford"},
  {id: 8, value: "Mercedes-Benz)"}, {id: 9, value: "Nissan"}, {id: 10, value: "Opel"}, {id: 11, value: "Peugeot"}, 
  {id: 12, value: "Renault"}, {id: 13, value: "Toyota"}, {id: 14, value: "Volkswagen"},
  {id: 15, value: "Abarth"}, {id: 16, value: "Alpine"}, {id: 17, value: "Alpine"}, {id: 18, value: "Aro"}, 
  {id: 19, value: "Asia"}, {id: 20, value: "Aston Martin"}, {id: 21, value: "Auverland"}, 
  {id: 22, value: "Bentley"}, {id: 23, value: "Bertone"}, {id: 24, value: "Bugatti"}, {id: 25, value: "Buick"},
  {id: 26, value: "Cadillac"}, {id: 27, value: "Caterham"}, {id: 28, value: "Chevrolet"}, {id: 29, value: "Cheyenne"},
  {id: 30, value: "Ferrari"}, {id: 31, value: "Honda"}, {id: 32, value: "Hummer"}, {id: 33, value: "Hyundai"},
  {id: 34, value: "Infiniti"}, {id: 35, value: "Isuzu"}, {id: 36, value: "Jaguar"}, {id: 37, value: "Jeep"},
  {id: 38, value: "Lamborghini"}, {id: 39, value: "KIA"}, {id: 40, value: "Lancia"}, {id: 41, value: "Land Rover"},
  {id: 42, value: "Mahindra"}, {id: 43, value: "Maserati"}, {id: 44, value: "Mazda"}, {id: 45, value: "Mitsubishi"},
  {id: 46, value: "Porsche"}, {id: 47, value: "Rover"}, {id: 48, value: "Tesla"}, {id: 49, value: "Volvo"}]
  
  
  vehicleForm: FormGroup;
  isRegistrationTypeSelected: boolean = false;

  @Output() vehicleFormEvent = new EventEmitter<FormGroup>();
  constructor(private _formBuilder: FormBuilder){
    this.vehicleForm = this._formBuilder.group({
      registrationType: ["", Validators.required],
      registrationNumber: ["", Validators.required],
      confirmRegistrationNumber: ["", Validators.required],
      chassisNumber: ["", Validators.required],
      kilometrage: ["", Validators.required],
      doorsNumber: ["", Validators.required],
      brand: ["", Validators.required],
      power: ["", Validators.required],
      color: ["", Validators.required],
      weight: ["", Validators.required],
      contractNumber: ["", Validators.required],
    });
  }
  
  onRegistrationTypeChange(){
    this.isRegistrationTypeSelected = true;
    console.log(this.isRegistrationTypeSelected);
  }

  notWritableField() {
    // console.log(this.filtroForm.controls['a'].value)
    this.vehicleForm.controls['doorsNumber'].setValue("")
    this.vehicleForm.updateValueAndValidity()
  }

  onFormChange(){
    //this.informationForm.valueChanges.subscribe(val => {
      if(this.vehicleForm.valid){
        this.emitInformationForm(this.vehicleForm);
      }
    //});  
  }

  emitInformationForm(value: FormGroup) {
    this.vehicleFormEvent.emit(value);
  }
}
