import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, Subscription } from 'rxjs';
import { Company } from 'src/app/models/company';
import { AgencyService } from 'src/app/services/api/agency.service';
import { InsuranceService } from 'src/app/services/api/insurance.service';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {
  isWhiteBackground!: boolean;
  backgroundColor!: string;
 
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
  insurances!: Company[];
  agencies!: Company[];
  @Output() vehicleFormEvent = new EventEmitter<FormGroup>();
  private subscription!: Subscription;
  constructor(private _formBuilder: FormBuilder, private httpClient: HttpClient,
    private agencyService: AgencyService, private insuranceService: InsuranceService){
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
      cylindree: ["", Validators.required],
      carburant: ["", Validators.required],
      carrosserieType: ["", Validators.required],
      power: ["", Validators.required],
      kilometrage: ["", Validators.required],
      doorsNumber: ["", Validators.required],
      color: ["", Validators.required],
      insurance: ["", Validators.required],
      agency: [{value: "", disabled: true}, Validators.required],
      contractNumber: ["", Validators.required],
      startContract: ["", Validators.required],
      endContract: ["", Validators.required],
      contractFile: [""],
      chassisFile: [""],
      technicalVisitFile: [""],
      vignetteFile: [""]
    });
  }
  
  ngOnInit(): void {
    this.getJSON("assets/vehicle/car-list.json").subscribe(data => {
      this.carList = data;
      this.brands = this.carList.map(car => car.brand)
    });
    this.getJSON("assets/vehicle/vehicle-condition.json").subscribe(data => {
      this.vehicleConditions = data;
    });
    this.getAllInsurances();
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

  getAllInsurances() {
    this.insuranceService.getAll().subscribe(data => {
      console.log(data);
      this.insurances = data;
    })
  }

  getAllAgencies() {
    console.log(this.vehicleForm.controls['insurance'].value)
    this.agencyService.getByInsurance(this.vehicleForm.controls['insurance'].value).subscribe(data => {
      console.log(data);
      this.vehicleForm.controls['agency'].enable();
      this.agencies = data;
    })
  }

  onInsuranceValueChange(){
    this.getAllAgencies();
  }

  onFormChange(){
    //this.informationForm.valueChanges.subscribe(val => {
      //if(this.vehicleForm.valid){
        console.log(this.vehicleForm)
        this.emitInformationForm(this.vehicleForm);
      //}
    //});  
  }

  emitInformationForm(value: FormGroup) {
    console.log(value);
    this.vehicleFormEvent.emit(value);
  }

  getContractFile(contractFile: File) {
    this.vehicleForm.controls['contractFile'].setValue(contractFile);
  }

  getChassisFile(chassisFile: File) {
    this.vehicleForm.controls['chassisFile'].setValue(chassisFile);
  }

  getTechnicalVisitFile(technicalVisitFile: File) {
    this.vehicleForm.controls['technicalVisitFile'].setValue(technicalVisitFile);
  }

  getVignetteFile(vignetteFile: File) {
    this.vehicleForm.controls['vignetteFile'].setValue(vignetteFile);
  }

  // Set the background color and isWhiteBackground variable based on your requirements
  setBackground(): void {
    this.backgroundColor = 'white'; // or any other color
    this.isWhiteBackground = this.backgroundColor === 'white';
  }
  
  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
