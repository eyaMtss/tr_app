import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { KeycloakAuthGuard, KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard extends KeycloakAuthGuard {
  
  constructor(protected override router: Router, protected override keycloakAngular: KeycloakService){
    super(router, keycloakAngular);
  }
  isAccessAllowed(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean | UrlTree> {
    return new Promise(async (resolve, reject) => {
      if(!this.authenticated){
        this.keycloakAngular.login();
        resolve(false);
        return;
      }
      const requiredRoles = route.data['roles'];
      let granted: boolean = false;
      if(!requiredRoles || requiredRoles.length === 0){
        granted = true;
      }
      else{
        for(const requiredRole of requiredRoles){
          if(this.roles.indexOf(requiredRole) > -1){
            granted = true;
            break;
          }
        }
      }

      if(granted === false){
        // If user doesn't have necessary roles, redirect to error page
        this.router.navigate(['access-denied']);
        resolve(granted);
      }
        
      resolve(granted);
    })
  
  } 
}