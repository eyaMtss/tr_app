import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CountryISO, SearchCountryField } from 'ngx-intl-tel-input';
import { Company } from 'src/app/models/company';
import { AgenceLocationService } from 'src/app/services/api/agence-location.service';
import { InsuranceService } from 'src/app/services/api/insurance.service';
import { SocieteRemorquageService } from 'src/app/services/api/societe-remorquage.service';

@Component({
  selector: 'app-informations',
  templateUrl: './informations.component.html',
  styleUrls: ['./informations.component.css']
})
export class InformationsComponent implements OnInit {
  // informationForm
  informationForm: FormGroup;
  selectedUserImage!: File;// image
  viewedImage: any = "/assets/auth/user.png" // default image
  roles: any[] = [{ id: "CLIENT", value: "Client" }, { id: "INSURANCE_ADMIN", value: "Assurance" },
  { id: "SOCIETE_REMORQUAGE_ADMIN", value: "Société de remorquage" },
  { id: "GARAGISTE_ADMIN", value: "Garagiste" }, { id: "AGENCE_LOCATION_ADMIN", value: "Agence de location" },
  { id: "LAVAGISTE_ADMIN", value: "Lavagiste" }, { id: "EXPERT", value: "Expert" }]; //role values
  currentRole: string = "CLIENT"; // default role = user
  companyList: Company[] = []; // company(insurance / société remorquage)
  companyLabel!: string;

  genderList = [{ id: "F", value: "Féminin" }, { id: "M", value: "Masculin" }];
  @Output() informationsFormEvent = new EventEmitter<FormGroup>();
  @Output() currentRoleEvent = new EventEmitter<string>();

  CountryISO = CountryISO;
  SearchCountryField = SearchCountryField;
  constructor(private _formBuilder: FormBuilder, private societeRemorquageService: SocieteRemorquageService,
    private insuranceService: InsuranceService, private agenceLocationService: AgenceLocationService) {
    this.informationForm = this._formBuilder.group({
      role: ["CLIENT", Validators.required],
      firstname: ["", Validators.required],
      lastname: ["", Validators.required],
      email: ["", [Validators.required, Validators.email]],
      username: ["", [Validators.required]],
      phone: ["", [Validators.required, Validators.minLength(8), Validators.maxLength(9)]],
      gender: ["", Validators.required],
      birthdate: ["", Validators.required],
      company: [{ value: '', disabled: true }, Validators.required],
    });
  }

  ngOnInit(): void {
  }

  onRoleChange() {

    this.currentRole = this.informationForm.controls['role'].value;
    this.emitCurrentrole(this.currentRole); // emit current Role to signup component
    console.log(this.currentRole);
    this.companyLabel = this.roles.filter(e => e.id == this.currentRole).map(e => e.value)[0];
    switch (this.currentRole) {
      case "INSURANCE_ADMIN": { //assurance
        this.informationForm.controls['company'].enable();
        this.informationForm.controls['username'].disable();
        this.getAllInsurances();
        break;
      }
      case "SOCIETE_REMORQUAGE_ADMIN": { //société de remorquage
        console.log(this.currentRole);
        this.informationForm.controls['company'].enable();
        this.informationForm.controls['username'].disable();
        this.getAllSocietesRemorquage();
        break;
      }
      case "AGENCE_LOCATION_ADMIN": { // agence de location
        this.informationForm.controls['company'].enable();
        this.informationForm.controls['username'].disable();
        //this.getAllAgencesLocation();
        break;
      }
      default: {
        this.informationForm.controls['company'].disable();
        this.informationForm.controls['username'].enable();
        break;
      }
    }
  }

  getAllSocietesRemorquage() {
    this.societeRemorquageService.getAll().subscribe(data => {
      console.log(data);
      this.companyList.splice(0);
      this.companyList = data;
    })
  }

  getAllInsurances() {
    this.insuranceService.getAll().subscribe(data => {
      console.log(data);
      this.companyList.splice(0);
      this.companyList = data;
    })
  }

  getAllRentAgencies() {
    this.agenceLocationService.getAll().subscribe(data => {
      console.log(data);
      this.companyList.splice(0);
      this.companyList = data;
    })
  }

  onClick() {
    console.log(this.informationForm.valid);
  }

  onFormChange() {
    //this.informationForm.valueChanges.subscribe(val => {
    if (this.informationForm.valid) {
      this.emitInformationForm(this.informationForm);
    }
    //});  
  }

  emitInformationForm(value: FormGroup) {
    console.log(value)
    this.informationsFormEvent.emit(value);
  }

  emitCurrentrole(value: string) {
    this.currentRoleEvent.emit(value);
  }
}
