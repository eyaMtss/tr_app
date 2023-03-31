import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {
  registrationTypes = [{id: 1, value: "Série Normale (TU)"}, {id: 2, value: "Régime Suspensif (RS)"},
  {id: 3, value: "Moto (MOTO)"}, {id: 4, value: "Tracteur (TRAC)"}, {id: 5, value: "Personnel Administratif et Technique (PAT)"},
  {id: 6, value: "Chef de Mission Diplomatique (CMD)"}, {id: 7, value: "Corps Diplomatique (CD)"},
  {id: 8, value: "Misiion Diplomatique (MD)"}, {id: 9, value: "Misiion Consulaire (MC)"}, 
  {id: 10, value: "Corps Consulaire (CC)"}, {id: 11, value: "Remorque (REM)"}, 
  {id: 12, value: "Appareil Agricol (AA)"}, {id: 13, value: "Engin Spécial (ES)"}, {id: 14, value: "Propriété de l'Etat (PE)"},
  {id: 15, value: "Immatriculation Temporaire (IT)"}, {id: 16, value: "Immatriculation Etrangère ou Douanière"}]
  
  carList!: any[];
  brands!: any[];
  models!: any[];
  vehicleConditions!: any[];

  vehicleForm: FormGroup;
  isRegistrationTypeSelected: boolean = false;

  @Output() vehicleFormEvent = new EventEmitter<FormGroup>();
  constructor(private _formBuilder: FormBuilder, private httpClient: HttpClient){
    this.vehicleForm = this._formBuilder.group({
      registrationType: ["", Validators.required],
      registrationNumber: ["", Validators.required],
      confirmRegistrationNumber: ["", Validators.required],
      chassisNumber: ["", Validators.required],
      
      brand: ["", Validators.required],
      model: [{value: "", disabled: true}, Validators.required],
      year: ["", [Validators.required, Validators.max(4), Validators.min(4)]],
      vehicleCondition: ["", Validators.required],
      boite: ["", Validators.required],
      cylindre: ["", Validators.required],
      carburant: ["", Validators.required],
      carrosserieType: ["", Validators.required],
      power: ["", Validators.required],
      kilometrage: ["", Validators.required],
      doorsNumber: ["", Validators.required],
      color: ["", Validators.required],
      contractNumber: ["", Validators.required],
      contractFile: [""],
      chassisFile: [""]
    });
  }
  
  ngOnInit(): void {
    this.getJSON("assets/vehicle/car-list.json").subscribe(data => {
      this.carList = data;
      this.brands = this.carList.map(car => car.brand)
    });
    this.getJSON("assets/vehicle/vehicle-condition.json").subscribe(data => {
      this.vehicleConditions = data;
    })
  }

  getJSON(jsonUrl: string): Observable<any>{
    return this.httpClient.get(jsonUrl);
  }

  onRegistrationTypeChange(){
    this.isRegistrationTypeSelected = true;
    console.log(this.isRegistrationTypeSelected);
  }

  onBrandChange(){
    this.vehicleForm.controls['model'].enable();
    this.models = this.carList.filter(car => car.brand == this.vehicleForm.controls['brand'].value)
                              .map(car => car.models)[0];
    console.log(this.models)
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

  getContractFile(contractFile: File) {
    this.vehicleForm.controls['contractFile'].setValue(contractFile);
  }

  getChassisFile(chassisFile: File) {
    this.vehicleForm.controls['chassisFile'].setValue(chassisFile);
  }
}
