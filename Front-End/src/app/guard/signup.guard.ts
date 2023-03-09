import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class SignupGuard implements CanActivate {
  constructor(private loginService: AuthService, private router: Router) { }

  async canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean> {
    if (await this.loginService.getIsLogged()) {
      this.router.navigate(['/order']);
      console.log("false guard")
      return false;
    }
    return true;
  }
  
}
