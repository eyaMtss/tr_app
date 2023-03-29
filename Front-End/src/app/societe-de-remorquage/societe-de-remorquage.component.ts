import { Component, OnInit } from '@angular/core';
import { Camion } from '../camion';
import { CamionService } from '../camion.service';
import {NgxPaginationModule} from 'ngx-pagination';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-societe-de-remorquage',
  templateUrl: './societe-de-remorquage.component.html',
  styleUrls: ['./societe-de-remorquage.component.css']
})
export class SocieteDeRemorquageComponent  implements OnInit{

  test=0;
  modifier=false;
  p:any;
  message=""
  camion=new Camion()
  camions: Camion[]=[];
  immatType!: any
  type!:any;
  porte!:any
model!:any
  typePoidsLourd!:any;
  isRegistrationTypeSelected: boolean = false;
  registrationTypes = [{ id: 1, value: "Série Normale (TU)" }, { id: 2, value: "Régime Suspensif (RS)" }]
  TypeCamions = [{ id: 1, value: "poids Lourd" }, { id: 2, value: "Poids Leger" }]
  nbPorte = [{ id: 1, value: "une poids" }, { id: 2, value: "2 Portes" }]
modeles= [{ id: 1, value: "Renault" }, { id: 2, value: "Iveco" }, { id: 3, value: "Scania" },{ id: 4, value: "Mercedes" }]
  TypePoidsLourd = [{ id: 1, value: "grand plateau" }, { id: 2, value: "petit plateau" }, { id: 3, value: "semi-remorque" }, { id: 4, value: "fourchette" }]

  constructor( private camionService:CamionService ,config: NgbModalConfig, private modalService: NgbModal ) {  config.backdrop = 'static';
  config.keyboard = false;}

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



}
