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
  roles: any[] = [{ id: 1, value: "User" }, { id: 2, value: "Assurance" }, { id: 3, value: "Société de remorquage" }]
  // address
  countries = [{ id: 1, value: "Tunisie" }, { id: 2, value: "Algerie" }, { id: 3, value: "Lybia" }];
  governorates: any[] = [];
  cities: any[] = [];

  companyList: any[] = [];
  
  maxVehicleNumber: number = 5;
  currentVehicleNumber: number = 1;
  stepperOrientation: Observable<StepperOrientation>; // stepper
  // forms
  informationForm: FormGroup;
  addressForm: FormGroup;
  credentialsForm: FormGroup;
  // image
  selectedFile!: File;
  viewedImage: any = "/assets/auth/user.png"

  vehiculeValues: any[] = []; //lista can have several values, we put them in a list: listaValues
  currentRole: number = 1;
  companyLabel: string = "Company";

  constructor(private _formBuilder: FormBuilder, breakpointObserver: BreakpointObserver) {
    this.informationForm = this._formBuilder.group({
      role: [1, Validators.required],
      firstname: ["", Validators.required],
      lastname: ["", Validators.required],
      email: ["", [Validators.required, Validators.email]],
      phone: ["", Validators.required],
      gender: ["", Validators.required],
      birthdate: ["", Validators.required],
      company: ["", Validators.required],
      matriculeFiscale: [""]
    });

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

    this.stepperOrientation = breakpointObserver
      .observe('(min-width: 800px)')
      .pipe(map(({ matches }) => (matches ? 'horizontal' : 'vertical')));

  }
  ngOnInit(): void {
    this.informationForm.controls['role'].setValue(1);
    this.addressForm.controls['country'].setValue(1);
    this.onCountryChange();

    this.onAddVehicleBtn(); //by default, there is only one input of lista
  }

  // Image
  public onFileChanged(event: any) {  //Gets called when the user selects an image
    //Select File
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile)
    var reader = new FileReader();
    reader.readAsDataURL(this.selectedFile);
    reader.onload = (_event) => {
      this.viewedImage = reader.result;
    }
  }

  onCountryChange() {
    console.log(this.addressForm.controls['country'].value)
    this.getGovernorates(this.addressForm.controls['country'].value);
  }

  onGovernorateChange(){
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

  onRoleChange(){
    this.currentRole = this.informationForm.controls['role'].value;
    this.companyLabel = this.roles.filter(e => e.id == this.currentRole).map(e => e.value)[0];
    switch(this.currentRole) {
      case 2 :{ //assurance
        let assuranceList = [{ id: 1, value: "Comar" }, { id: 2, value: "GAT" }, { id: 3, value: "BH-Assurance" }];
        this.companyList = assuranceList;
        break;
      }
      case 3: { //société de remorquage
        let sociéteRemorquageList = [{ id: 1, value: "alla" }, { id: 2, value: "Allo remorquage" }, { id: 3, value: "Service remorquage" }];
        this.companyList = sociéteRemorquageList;
        break;
      }
    }
  }

  onAddVehicleBtn(){
    if (this.vehiculeValues.length < 5){
      this.vehiculeValues.push({ value: "" });
      this.currentVehicleNumber += 1;
    }
    
  }
  onDeleteButton(i: any): void {  //delete the i input field for lista
    if (this.vehiculeValues.length == 1)   //always keep a field
      this.vehiculeValues[i].value = ""
    else{
      this.vehiculeValues.splice(i, 1);
      this.currentVehicleNumber -= 1;
    }
      
  }
}