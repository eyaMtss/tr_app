import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Company } from 'src/app/models/company';
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
  roles: any[] = [{ id: 1, value: "User" }, { id: 2, value: "Assurance" }, { id: 3, value: "Société de remorquage" }]; //role values
  currentRole: number = 1; // default role = user
  companyList: Company[] = []; // company(insurance / société remorquage)
  companyLabel!: string;

  genreList = [{id: "F", value: "Féminin"}, {id: "M", value: "Masculin"}];
  @Output() informationsFormEvent = new EventEmitter<FormGroup>();
  @Output() currentRoleEvent = new EventEmitter<number>();
  constructor(private _formBuilder: FormBuilder, private societeRemorquageService: SocieteRemorquageService,
    private insuranceService: InsuranceService) {
    this.informationForm = this._formBuilder.group({
      role: [1, Validators.required],
      firstname: ["", Validators.required],
      lastname: ["", Validators.required],
      email: ["", [Validators.required, Validators.email]],
      phone: ["", Validators.required],
      gender: ["", Validators.required],
      birthdate: ["", Validators.required],
      company: [{ value: '', disabled: true }, Validators.required],
      img: [""]
    });
  }

  ngOnInit(): void {
    this.informationForm.controls['role'].setValue(1); // role is setted to user

    //this.getAllSocietesRemorquage() //test
  }

  // Image
  public onFileChanged(event: any) {  //Gets called when the user selects an image
    //Select File
    this.selectedUserImage = event.target.files[0];
    console.log(this.selectedUserImage)
    var reader = new FileReader();
    reader.readAsDataURL(this.selectedUserImage);
    reader.onload = (_event) => {
      this.viewedImage = reader.result;
    }
    this.informationForm.controls['img'].setValue(this.selectedUserImage);
  }

  onRoleChange() {

    this.currentRole = this.informationForm.controls['role'].value;
    this.emitCurrentrole(this.currentRole); // emit current Role to signup component
    console.log(this.currentRole);
    this.companyLabel = this.roles.filter(e => e.id == this.currentRole).map(e => e.value)[0];
    switch (this.currentRole) {
      case 1: {
        this.informationForm.controls['company'].disable();
        this.informationForm.controls['matriculeFiscale'].disable();
        break;
      }
      case 2: { //assurance
        this.informationForm.controls['company'].enable();
        this.informationForm.controls['matriculeFiscale'].enable();
        this.getAllInsurances();
        break;
      }
      case 3: { //société de remorquage
        console.log(this.currentRole);
        this.informationForm.controls['company'].enable();
        this.informationForm.controls['matriculeFiscale'].enable();
        this.getAllSocietesRemorquage();
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

  onClick() {
    console.log(this.informationForm.valid);
  }

  onFormChange(){
    //this.informationForm.valueChanges.subscribe(val => {
      if(this.informationForm.valid){
        this.emitInformationForm(this.informationForm);
      }
    //});  
  }

  emitInformationForm(value: FormGroup) {
    console.log(value)
    this.informationsFormEvent.emit(value);
  }

  emitCurrentrole(value: number){
    this.currentRoleEvent.emit(value);
  }
}
