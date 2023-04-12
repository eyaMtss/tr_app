import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakLoginOptions } from 'keycloak-js';
import { UserService } from '../api/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private keycloakService: KeycloakService, private router: Router,
    private userService: UserService) { }

  async getLoggedUser(){
    try {
      let userDetails = this.keycloakService.getKeycloakInstance().idTokenParsed;
      let isLoggedIn = "false";
      if(await this.getIsLogged()){
        isLoggedIn = "true";
      }
      localStorage.setItem("isLoggedIn", isLoggedIn);
      localStorage.setItem("Token", await this.getToken());
      return userDetails;
    } catch(e){
      console.log('getLoggedUser Exception', e);
      return undefined;
    }
  }

  async login(loginOptions: KeycloakLoginOptions){
    this.keycloakService.login(loginOptions);
  }

  
  public getIsLogged(): Promise<boolean> {
    return (this.keycloakService.isLoggedIn());
  }

  public getIsLoggedIn(): any {
    this.keycloakService.isLoggedIn().then(value => {return value});
  } 

  logout(){
    let username = this.getUsername()
    this.keycloakService.logout(window.location.origin).then(() => {
      this.keycloakService.clearToken(); //clear token from keycloak service
      this.router.navigate(["/home"]); // navigate to home page
    });
    console.log(username);
    localStorage.removeItem("Token") // clear token from localStorage
    localStorage.setItem("isLoggedIn", "false"); // change isLoggedIn to false in LocalStorage
    this.userService.updateCompletedRegistration(username).subscribe(data => {
      console.log(data);
    })
  }

  redirectToProfile(){
    this.keycloakService.getKeycloakInstance().accountManagement();
  }

  getRoles(): string[]{
    return this.keycloakService.getUserRoles();
  }

  getToken() {
    return this.keycloakService.getToken();
  }

  getUsername(){
    return this.getUserDetails()!['preferred_username'];
  }

  register(){
    return this.keycloakService.register();
  }

  getUserDetails(){
    return this.keycloakService.getKeycloakInstance().idTokenParsed;
  }
}

