import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable, exhaustMap, of, take } from 'rxjs';
import { KeycloakService } from 'keycloak-angular';
import { AuthService } from '../services/auth/auth.service';


@Injectable()
export class RequestInterceptor implements HttpInterceptor {

  constructor(private keycloakSecurityService: KeycloakService, private authService: AuthService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    console.log('request interceptor ...')
    return of(this.keycloakSecurityService.getKeycloakInstance())
      .pipe(
        take(1),
        exhaustMap(keycloak => {
          console.log('keycloak', keycloak)
          if (!keycloak.authenticated) {
            return next.handle(req);
          }

          const modifiedReq = req.clone(
            {
              setHeaders: {
                Authorization: 'Bearer ' + keycloak.token
              }
            }
          );
          return next.handle(modifiedReq);
        })
      );
  }
}
