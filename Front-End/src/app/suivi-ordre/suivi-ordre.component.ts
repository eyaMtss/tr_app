import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderResponse } from '../order-response';
import { OrderService } from '../order.service';
import { Suivi } from '../suivi';
import { SuiviService } from '../suivi.service';

@Component({
  selector: 'app-suivi-ordre',
  templateUrl: './suivi-ordre.component.html',
  styleUrls: ['./suivi-ordre.component.css']
})
export class SuiviOrdreComponent implements OnInit {
  constructor(private router: Router , private suiviService:SuiviService, private ordreService:OrderService){}

  ordre!:OrderResponse;

  id!:any;
  suivi!:any;
  test=0;
  idVehicule!:any;
  idC!:any;
  idTA!:any;
  orderTimeRequest!:any;
  ngOnInit(): void {
    this.getSuivi();
    this.getOrdre();
  }

  getSuivi()
{
  this.id= localStorage.getItem('id')
  this.suiviService.getSuivi(this.id).subscribe(
    data => {
      console.log(data)
    //  console.log("response received")
   //  this.router.navigate(['']);
       this.idC=data.idChauffeur;
       this.idTA=data.idTA
       this.test=data.status

    },
   error=>{
     console.log("error accured")
     //this.errorMessage="";
   }
);


}

getOrdre()
{
  this.id= localStorage.getItem('id')
  this.ordreService.getOrdre(this.id).subscribe(
    data => {
      console.log("response received")
      console.log(data)
      this.idVehicule=data.idVehicule;
      this.orderTimeRequest=data.orderTimeRequest;

   //  this.router.navigate(['']);
   //this.ordre=data

    },
   error=>{
     console.log("error accured")
     //this.errorMessage="";
   }
);
}

}





