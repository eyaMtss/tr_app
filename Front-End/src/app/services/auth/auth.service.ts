import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakLoginOptions, KeycloakTokenParsed } from 'keycloak-js';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private keycloakService: KeycloakService) { }

  getLoggedUser(){
    try {
      let userDetails = this.keycloakService.getKeycloakInstance().idTokenParsed;
      console.log('UserDetails', userDetails);
      console.log('UserRoles', this.keycloakService.getUserRoles());
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

  login(){
    this.keycloakService.login();
  }
  
  public getIsLogged(): Promise<boolean> {
    return (this.keycloakService.isLoggedIn());
  }

  logout(){
    this.keycloakService.logout(window.location.origin).then(() => this.keycloakService.clearToken());
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

