import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  //userURL = 'http://localhost:8080/user/';

  
  constructor(private httpClient: HttpClient) { }

  /*public create(user: User): Observable<any> {
    return this.httpClient.post<any>(this.userURL + 'create', user);
  }*/
}
