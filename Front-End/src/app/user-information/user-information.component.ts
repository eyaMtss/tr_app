import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-information',
  templateUrl: './user-information.component.html',
  styleUrls: ['./user-information.component.css']
})
export class UserInformationComponent implements OnInit {

  name="Falten";
  surname="Foulen";
  phone="+216 22 446 488";
  contractId=918909
  contractType="Confort"
  date:Date=new Date();
  startingDate:string=this.date.getDate().toString()+'/'+this.date.getMonth().toString()+'/'+this.date.getFullYear().toString();
  endingDate:string=this.date.getDate().toString()+'/'+this.date.getMonth().toString()+'/'+(this.date.getFullYear()+1).toString();
  carType="Mazda3";
  mileAge=330400;
  adress="123 Rue Azzouz Rebai, Tunis"

  constructor() { }

  ngOnInit(): void {
  }

}
