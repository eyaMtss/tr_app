import { Component, OnInit } from '@angular/core';
import { Camion } from '../camion';
import { CamionService } from '../camion.service';
import {NgxPaginationModule} from 'ngx-pagination';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { CompanyUserRequest } from '../company-user-request';
import { PersonnelService } from '../personnel.service';

@Component({
  selector: 'app-societe-de-remorquage',
  templateUrl: './societe-de-remorquage.component.html',
  styleUrls: ['./societe-de-remorquage.component.css']
})
export class SocieteDeRemorquageComponent  implements OnInit{
// informationsForm
id!:number
informationForm: FormGroup;
afficher=0;
currentRole!: string; //user is the default user
isInformationsNextBtnDisabled: Boolean = true;

// addressForm
addressForm!: FormGroup;
isAddressNextBtnDisabled: Boolean = true;
//vehicule section when role = user
//maxVehicleNumber: number = 5; //
//currentVehicleNumber: number = 1; // user must have at least 1 vehicule
//vehiculeValues: Vehicle[] = []; //user can have several vehicules, we put them in a list: vehiculeValues

// credentialsForm
credentialsForm!: FormGroup;
isCredentialsNextBtnDisabled: Boolean = true;
  test=0;
  modifier=false;
  p:any;
  message=""
  camion=new Camion()
  UserRequest=new CompanyUserRequest()
  camions: Camion[]=[];
  Drivers: CompanyUserRequest[]=[];
  TAs: CompanyUserRequest[]=[];
  immatType!: any
  type!:any;
  porte!:any
  country!:any
  gouv!:any
model!:any
role!:any
  typePoidsLourd!:any;
  isRegistrationTypeSelected: boolean = false;

  fieldTextTypeForPassword: boolean = false; // show or hide password
  fieldTextTypeForConfirmPassword: boolean = false

  registrationTypes = [{ id: 1, value: "Série Normale (TU)" }, { id: 2, value: "Régime Suspensif (RS)" }]
  TypeCamions = [{ id: 1, value: "poids Lourd" }, { id: 2, value: "Poids Leger" }]
  nbPorte = [{ id: 1, value: "une poids" }, { id: 2, value: "2 Portes" }]
modeles= [{ id: 1, value: "Renault" }, { id: 2, value: "Iveco" }, { id: 3, value: "Scania" },{ id: 4, value: "Mercedes" }]
  TypePoidsLourd = [{ id: 1, value: "grand plateau" }, { id: 2, value: "petit plateau" }, { id: 3, value: "semi-remorque" }, { id: 4, value: "fourchette" }]
  roles = [{id: "1", value: "driver"}, {id: "2", value: "TA"}, ]
  genreList = [{id: "F", value: "Féminin"}, {id: "M", value: "Masculin"}];
  pays = [{id: "1", value: "Tunisie"}, {id: "2", value: "Libye"},{id: "3", value: "Algérie"}, {id: "4", value: "France"}];
  gouvernorats = [{id: "1", value: "Tunis"}, {id: "2", value: "Beja"},{id: "3", value: "Bizerte"}, {id: "4", value: "Sousse"},{id: "5", value: "Nabeul"}, {id: "6", value: "Jendouba"},{id: "7", value: "Kasserine"}, {id: "8", value: "Tatouine"},{id: "9", value: "Gafsa"}, {id: "10", value: "Kairouane"},{id: "11", value: "SidiBouzid"}, {id: "12", value: "Mahdia"},
  {id: "13", value: "Monastir"}, {id: "14", value: "Sfax"},{id: "15", value: "Siliana"}, {id: "16", value: "Kébili"},{id: "17", value: "Medenine"}, {id: "18", value: "Kef"},{id: "19", value: "Gabes"}, {id: "20", value: "Tozeur"},{id: "21", value: "Zaghouan"}, {id: "22", value: "Ben Arous"}
];

  constructor( private camionService:CamionService ,config: NgbModalConfig, private modalService: NgbModal,private _formBuilder: FormBuilder,private personelService:PersonnelService ) {  config.backdrop = 'static';
  config.keyboard = false;
  this.informationForm = this._formBuilder.group({
    role: ["CLIENT", Validators.required],
    firstname: ["", Validators.required],
    lastname: ["", Validators.required],
    email: ["", [Validators.required, Validators.email]],
    username: ["", [Validators.required]],
    phone: ["", [Validators.required, Validators.minLength(8), Validators.maxLength(9)]],
    matriculeFiscale: ["", [Validators.required, Validators.minLength(8), Validators.maxLength(9)]],
    gender: ["", Validators.required],
    birthdate: ["", Validators.required],
    company: [{ value: '', disabled: true }, Validators.required],
  });


  this.credentialsForm = this._formBuilder.group({
    password: ["", [Validators.required,  Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]],
    confirmPassword: ["", [Validators.required,  Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]]
  });
  this.credentialsForm.addValidators(
    this.matchValidator(
      this.credentialsForm.get('password')!,
      this.credentialsForm.get('confirmPassword')!
    )
   );
}

  ngOnInit(): void {


  }
button1()
{
  this.test=1;
  console.log(this.test)
  this.getCamions()
  console.log(this.camions)
}
button2()
{
  this.test=2;
  console.log(this.test)
}
button3()
{
  this.test=3;
  console.log(this.test)
}
button4()
{
  this.test=4;
  console.log(this.test)
}

 getCamions(){
  this.camionService.getCamionList().subscribe(data => {
    this.camions = data;
    if (this.camions.length==0)
    {
      this.message="la liste des camions est vide pour le moment... "
    }
  });
}
deleteCamion(id: number){
  this.camionService.deleteCamion(id).subscribe( data => {
    console.log(data);
    this.getCamions();

  })
}

saveCamion()
{
console.log(this.camion)
if (this.modifier==false)
{
if (this. immatType==1)
{
  this.camion.matricule=this.camion.numImmat+" "+"تونس TU "+" "+ this.camion.serie
}
else
{
  this.camion.matricule="RS "+this.camion.numImmat+" ن ت"
}
this.camion.companyID=1;
    this.camionService.createCamion(this.camion).subscribe( data =>{

    },
    error => {
    console.log(error)

    });
   this.button1();}
   else
   {
    console.log(this.modifier)
    if (this. immatType==1)
    {
      this.camion.matricule=this.camion.numImmat+" "+"تونس TU "+" "+ this.camion.serie
    }
    else
    {
      this.camion.matricule="RS "+this.camion.numImmat+" ن ت"
    }
    this.camion.companyID=1;
        this.camionService.updateCamion(this.camion).subscribe( data =>{

        },
        error => {
        console.log(error)

        });
        this.camion=new Camion()
        this.modifier=false;
        console.log(this.modifier)
       this.button1();


      }
   }



onRegistrationTypeChange(e: any) {
  this.isRegistrationTypeSelected = true;
  this.immatType = e.target.value
  console.log(this.immatType);
  console.log(this.registrationTypes[this.immatType - 1].value)
  this.camion.typeImmat=this.registrationTypes[this.immatType - 1].value

}
onTypeChange(e: any) {

  this.type = e.target.value
  console.log(this.type);
  console.log(this.TypeCamions[this.type - 1].value)
  this.camion.type=this.TypeCamions[this.type - 1].value

}
ongouvChange(e: any) {

  this.gouv = e.target.value
  console.log(this.gouv);
  console.log(this. gouvernorats[this.gouv - 1].value)
  this.UserRequest.governorate=this. gouvernorats[this.gouv - 1].value

}

onTypePoidsLourdChange(e: any) {

  this.typePoidsLourd = e.target.value
  console.log(this.typePoidsLourd);
  console.log(this.TypePoidsLourd[this.typePoidsLourd - 1].value)
  this.camion.typePoidsLourd=this.TypePoidsLourd[this.typePoidsLourd - 1].value

}
onNbPorteChange(e: any) {

  this.porte = e.target.value
  console.log(this.porte);
  console.log(this.nbPorte[this.porte - 1].value)
  this.camion.porte=this.porte

}

onPaysChange(e: any) {

  this.country = e.target.value
  console.log(this.country);
  console.log(this.pays[this.country - 1].value)
  this.UserRequest.country=this.pays[this.country - 1].value


}
onModeleChange(e: any) {

  this.model = e.target.value
  console.log(this.model);
  console.log(this.modeles[this.model - 1].value)
  this.camion.modele=this.modeles[this.model - 1].value

}
open(content: any) {
  this.modalService.open(content);
}

updateCamion(id:number)
{
 this.button2()
 this.camionService.getCamionById(id).subscribe(data => {
  this.camion = data;
}, error => console.log(error));
this.modifier=true;
console.log(this.modifier)
this.button2()
}

onFormChange(){
  console.log(this.UserRequest)
 this.test=5;

}

onFormChanger(){
  console.log(this.UserRequest)
  this.test=6;

 }
onRoleChange(e: any) {
  this.role = e.target.value
  console.log(this.role);
  console.log(this.roles[this.role - 1].value)
  //this.camion.modele=this.roles[this.role - 1].value}
}

 matchValidator(
  control: AbstractControl,
  controlTwo: AbstractControl
): ValidatorFn {
  return () => {
    if (control.value !== controlTwo.value)
      return { match_error: 'Passwords does not match' };
    return null;
  };

}
toggleFieldTextTypeForPassword() {
  this.fieldTextTypeForPassword = !this.fieldTextTypeForPassword;
}

toggleFieldTextTypeForConfirmPassword(){
  this.fieldTextTypeForConfirmPassword = !this.fieldTextTypeForConfirmPassword;
}
onSubmit()
{
  this.UserRequest.societeRemorquageId=1;
  console.log(this.UserRequest)
  console.log(this.UserRequest.password)
  if(this.role==1)
  {
  this.personelService.createPersonnel(this.UserRequest).subscribe( data =>{
 console.log(data)
  },
  error => {
  console.log(error)

  });}
  else{
    this.personelService.createPersonnelTA(this.UserRequest).subscribe( data =>{
      console.log(data)
       },
       error => {
       console.log(error)

       });
  }
}
afficherDrivers()
{
  this.afficher=1;
  this.getDrivers();

}
confirmer()
{

  this.afficher=2;
  this.getTas()
}

getDrivers(){
  this.personelService.getDrivers().subscribe(data => {
    this.Drivers = data;
    console.log(this.Drivers)
    if (this.camions.length==0)
    {
      this.message="la liste des camions est vide pour le moment... "
    }
  });
}

getTas(){
  this.personelService.getTAs().subscribe(data => {
    this.TAs = data;
    console.log(this.TAs)
    if (this.camions.length==0)
    {
      this.message="la liste des camions est vide pour le moment... "
    }
  });
}
}
