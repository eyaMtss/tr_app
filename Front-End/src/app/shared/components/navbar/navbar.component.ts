import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { KeycloakLoginOptions } from 'keycloak-js';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnChanges{
  @Input() isLoggedIn!: boolean; // 
  username: string = "";
  currentRole: string = "";
  constructor(private router: Router, private authService: AuthService) {
    
  }
  ngOnChanges(changes: SimpleChanges): void {
    console.log(this.isLoggedIn)
    if (this.isLoggedIn == true){
      this.username = this.authService.getUsername();
      this.currentRole = this.authService.getRoles()[0];
      console.log(this.currentRole)
    }
    localStorage.setItem("isLoggedIn", this.isLoggedIn? "true":"false"); // set isLoggedIn attribute in LocalStorage
  }
  ngOnInit(): void {
  }

  home() {
    console.log(this.username)
    console.log(this.currentRole)
    if (this.isLoggedIn == true){
      if(this.currentRole == "CLIENT") this.router.navigate(["/client"]);
      else if(this.currentRole == "GARAGISTE_ADMIN") this.router.navigate(["/garagisteAdmin"]);
      else if(this.currentRole == "LAVAGISTE_ADMIN") this.router.navigate(["/lavagisteAdmin"]);
      else if(this.currentRole == "INSURANCE_ADMIN") this.router.navigate(["/insuranceAdmin"]);
      else if(this.currentRole == "AGENCE_LOCATION_ADMIN") this.router.navigate(["/agenceLocationAdmin"]);
      else if(this.currentRole == "DRIVER") this.router.navigate(['camion-login']);
    }
        
        
    else this.router.navigate(["/"]);
  }

  signin() {
    const loginOptions: KeycloakLoginOptions = {
      redirectUri: window.location.origin + "/tunidesign"
    };
    this.authService.login(loginOptions);
  }

  signup() {
    this.router.navigate(['/signup']);
  }

  logout(){
    this.authService.logout();
    
  }

  profile(){
    if(this.currentRole == "CLIENT") this.router.navigate(["/client/profile"]);
  }

  orders(){
    
  }

  settings(){
    
  }
}
