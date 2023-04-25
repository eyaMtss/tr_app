import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth/auth.service';
import { UserService } from '../services/api/user.service';

@Injectable({
  providedIn: 'root'
})
export class RegistrationGuard implements CanActivate {
  constructor(private keycloakService: KeycloakService, private router: Router,
    private authService: AuthService, private userService: UserService) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    let username = this.authService.getUsername();
    this.userService.getByUsername(username).subscribe(data => {
      console.log(data);
      let isRegistrationCompleted = data.isRegistrationCompleted;
      console.log(isRegistrationCompleted)
      if(isRegistrationCompleted){
        localStorage.setItem("isRegistrationCompleted", "true");
        return true;
      }
      else {
        localStorage.setItem("isRegistrationCompleted", "false");
        this.router.navigate(["/complete-registration"]);
        return false;
      }
    });
    return false;
    /*const userDetails = this.keycloakService.getKeycloakInstance().idTokenParsed;
    console.log(userDetails)
    if (!userDetails) {
      return false;
    }

    const hasCompletedRegistration = userDetails.completed_registration == '1';
    console.log(hasCompletedRegistration);
    if (!hasCompletedRegistration) {
      this.router.navigate(['/complete-registration']);
      return false;
    }
    return true;*/
  
  }
}