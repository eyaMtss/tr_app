import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Company } from 'src/app/models/company';
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

  constructor(private _formBuilder: FormBuilder, private societeRemorquageService: SocieteRemorquageService){
    this.informationForm = this._formBuilder.group({
      role: [1, Validators.required],
      firstname: ["", Validators.required],
      lastname: ["", Validators.required],
      name: ["", Validators.required], // company
      email: ["", [Validators.required, Validators.email]],
      phone: ["", Validators.required],
      phone2: ["", Validators.required], // company
      gender: ["", Validators.required],
      birthdate: ["", Validators.required],
      company: ["", Validators.required],
      matriculeFiscale: [""]
    });
  }

  ngOnInit(): void {
    this.informationForm.controls['role'].setValue(1); // role is setted to user

    this.getSocietesRemorquage() //test
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
  }

  onRoleChange() {
    this.currentRole = this.informationForm.controls['role'].value;
    this.companyLabel = this.roles.filter(e => e.id == this.currentRole).map(e => e.value)[0];
    switch (this.currentRole) {
      case 2: { //assurance
        //let assuranceList = [{ id: 1, value: "Comar" }, { id: 2, value: "GAT" }, { id: 3, value: "BH-Assurance" }];
        //this.companyList = assuranceList;
        break;
      }
      case 3: { //société de remorquage
        //let sociéteRemorquageList = [{ id: 1, value: "alla" }, { id: 2, value: "Allo remorquage" }, { id: 3, value: "Service remorquage" }];
        //this.companyList = sociéteRemorquageList;
        break;
      }
    }
  }

  getSocietesRemorquage(){
    this.societeRemorquageService.getAll().subscribe(data => {
      console.log(data);
      this.companyList = data;
    })
  }
}
