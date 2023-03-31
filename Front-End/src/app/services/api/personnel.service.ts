import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CompanyUserRequest } from '../../models/company-user-request';

@Injectable({
  providedIn: 'root'
})
export class PersonnelService {

  constructor(private httpClient: HttpClient) { }

  createPersonnel(user:CompanyUserRequest): Observable<Object>{
    return this.httpClient.post<any>("http://localhost:8989/users/addDriver", user);
  }


  createPersonnelTA(user:CompanyUserRequest): Observable<Object>{
    return this.httpClient.post<any>("http://localhost:8989/users/addTA", user);
  }
  getDrivers(): Observable<CompanyUserRequest[]>{
    return this.httpClient.get<CompanyUserRequest[]>("http://localhost:8989/users/getAll/company/drivers/1");
  }
  getTAs(): Observable<CompanyUserRequest[]>{
    return this.httpClient.get<CompanyUserRequest[]>("http://localhost:8989/users/getAll/company/TA/1");
  }
}
