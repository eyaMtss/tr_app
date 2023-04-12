import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Affectation } from 'src/app/models/affectation';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AffectationService {

  private _URL = environment.domain + ":" + environment.port + "/";
  constructor(private httpClient: HttpClient) { }
  postAffectation(affectation:Affectation): Observable<Affectation>{
    return this.httpClient.post<Affectation>("http://localhost:5252/AffecterUnCamion",affectation);
  }
  getAffectatons(): Observable<Affectation[]>{
    return this.httpClient.get<Affectation[]>("http://localhost:5252/Affectations");
  }
}
