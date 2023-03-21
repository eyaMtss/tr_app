import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, catchError, map, retry, throwError } from 'rxjs';

@Injectable()
export class ErrorsCatchingInterceptor implements HttpInterceptor {

  constructor() { } //private alertifyService: AlertifyService

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    //console.log("Passed through the interceptor in request");
    return next.handle(request)
      .pipe(map(res => {
          console.log("Passed through the interceptor in response");
          return res
        }),
        catchError((error: HttpErrorResponse) => {
          let errorMsg = 'Something went wrong, please try again.';
          if (error.error instanceof ErrorEvent) {
            console.log('This is client side error');
            errorMsg = `Error: ${error.error.message}`;
          } else {
            console.log('This is server side error');
            errorMsg = `Error Code: ${error.status},  Message: ${error.message}`;
          }
         // console.log(errorMsg);
          //this.alertifyService.httpError(errorMsg)
          
          //alertifyjs.error('Confirm Message', function(){ alertifyjs.success('Ok') });
          window.alert(errorMsg)
          return throwError(errorMsg);
        })
      )
  }
}

