import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-multi',
  templateUrl: './multi.component.html',
  styleUrls: ['./multi.component.css']
})
export class MultiComponent implements OnInit {
  constructor(private router: Router, private authService:AuthService){
    
  }
  ngOnInit(): void {
    let role = this.authService.getRoles()[0];
    if(role == "CLIENT") this.router.navigate(["/client"]);
    else if(role == "GARAGISTE_ADMIN") this.router.navigate(["/garagisteAdmin"]);
    else if(role == "LAVAGISTE_ADMIN") this.router.navigate(["/lavagisteAdmin"]);
    else if(role == "INSURANCE_ADMIN") this.router.navigate(["/insuranceAdmin"]);
    else if(role == "AGENCE_LOCATION_ADMIN") this.router.navigate(["/agenceLocationAdmin"]);
    else if(role == "DRIVER") this.router.navigate(['camion-login']);
    else if(role == "TA") this.router.navigate(["/ta"]);
    else if(role == "SOCIETE_REMORQUAGE_ADMIN") this.router.navigate(["/societe"]);
    else if(role == "EXPERT") this.router.navigate(["/expert"]);
    else this.router.navigate(["/home"]);
  }

}
