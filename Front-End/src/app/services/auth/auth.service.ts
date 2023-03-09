import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakLoginOptions, KeycloakTokenParsed } from 'keycloak-js';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private keycloakService: KeycloakService) { }

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

  /*login(username: string, password: string) {
    const credentials: Keycloak.KeycloakLoginOptions = {
      cordovaOptions: {username,password}
    };
    return this.keycloakService.login(credentials);
  }*/

  async login(){
    this.keycloakService.login();
  }
  
  public getIsLogged(): Promise<boolean> {
    return (this.keycloakService.isLoggedIn());
  }

  public getIsLoggedIn(): any {
    this.keycloakService.isLoggedIn().then(value => {return value});
  } 

  logout(){
    this.keycloakService.logout(window.location.origin).then(() => {
      this.keycloakService.clearToken() //clear token from keycloak service
    });
    localStorage.removeItem("Token") // clear token from localStorage
    localStorage.setItem("isLoggedIn", "false"); // change isLoggedIn to false in LocalStorage
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
}

