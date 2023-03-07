import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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
  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  confirm()
{
  console.log(this.pickUpLocation)
  console.log(this.destination)
  console.log(this.people)
  console.log(this.phone)
  console.log(this.situationType)
  console.log(this.matricule);
  console.log(this.isLoaded);


  this.router.navigate(['/sendPicture']);
}

}
