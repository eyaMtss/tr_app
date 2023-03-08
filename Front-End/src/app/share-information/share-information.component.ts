import { Component, OnInit } from '@angular/core';
import { Router, TitleStrategy } from '@angular/router';
import { OrderRequest } from '../order-request';
import { OrderService } from '../order.service';
import {CountryISO,SearchCountryField} from "ngx-intl-tel-input";
import { FormGroup, FormControl, Validators , FormBuilder} from '@angular/forms';


@Component({
  selector: 'app-share-information',
  templateUrl: './share-information.component.html',
  styleUrls: ['./share-information.component.css']
})
export class ShareInformationComponent implements OnInit {

  pickUpLocation!:string;
  destination!:string;
  phone!:string;
  people!:number;
  situationType!:string;
  time:any;
  isLoaded!: string;
  matricule!: any;
  order: OrderRequest = new OrderRequest();
  order1: OrderRequest = new OrderRequest();
  date: Date= new Date();
  message=""
  tel!:any
  SearchCountryField = SearchCountryField;
  CountryISO = CountryISO;
  registerForm!:FormGroup
   submitted=false
  constructor(private router: Router ,private orderService: OrderService ,private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      location:['',[Validators.required]],
      destination:['',[Validators.required]],

      people:['',[Validators.required]],
      matricule:['',[Validators.required]],
    details:['',[Validators.required]],
    loaded:['',[Validators.required]],

    type:['',[Validators.required,]],



    })
  }
  confirm()
{
 /* console.log(this.pickUpLocation)
  console.log(this.destination)
  console.log(this.people)
  console.log(this.phone)
  console.log(this.situationType)
  console.log(this.matricule);*/
  console.log(this.tel.nationalNumber);



  this.router.navigate(['/sendPicture']);
}
saveOrder(){

  this.submitted = true

    if(this.registerForm.invalid){
      return
    }
else{
this.order.positionALong="toDo";
this.order.positionBLong="toDo"
this.order.positionCAtt="toDo";
this.order.positionCLong="ToDO";
const whitespaceRemoved = this.tel.nationalNumber.replace(/\s/g, '');

this.order.telephone=Number(whitespaceRemoved);
if(whitespaceRemoved.length==8)
{
  this.orderService.createOrder(this.order).subscribe( data =>{


 console.log(data)

  },
  error => {
  console.log(error),
  this.message="il y'a une erreur "
  });
}
else
{
  console.log("le numéro est invalide ")
}}}
phoneForm = new FormGroup({
  phone: new FormControl('', [Validators.required])
});

}
