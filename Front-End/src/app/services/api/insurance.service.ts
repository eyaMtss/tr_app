import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from 'src/app/models/company';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InsuranceService {
  private _URL = environment.domain + ":" + environment.port + "/insurance/";
  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Company[]> {
    return this.httpClient.get<Company[]>(this._URL + "getAll")
  }

  getById(id: number): Observable<Company>{
    return this.httpClient.get<Company>(this._URL + "getById/" + id);
  }

  
  create(insurance: Company): Observable<Company> {
    return this.httpClient.post<Company>(this._URL + 'add', insurance);
  }

  deleteSociete(id: number){
    return this.httpClient.delete<Company>(this._URL + "delete/" + id);
  }
 
  editSociete(insurance: Company): Observable<Company>{
    return this.httpClient.put<Company>(this._URL + "update/", insurance);
  }
}
