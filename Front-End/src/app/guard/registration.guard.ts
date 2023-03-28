import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class RegistrationGuard implements CanActivate {
  constructor(private keycloakService: KeycloakService, private router: Router, private authService: AuthService) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const userDetails = this.keycloakService.getKeycloakInstance().idTokenParsed;
    console.log(userDetails)
    if (!userDetails) {
      return false;
    }

    const hasCompletedRegistration = userDetails.completed_registration === 'true';
    console.log(userDetails.completed_registration);
    console.log(hasCompletedRegistration);
    if (!hasCompletedRegistration) {
      this.router.navigate(['/complete-registration']);
      return false;
    }

    return true;
  }
}