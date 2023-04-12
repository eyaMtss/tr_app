import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { Camion } from 'src/app/models/camion';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CamionService {
  private _URL = environment.domain + ":" + environment.port + "/camion/";
  constructor(private httpClient: HttpClient) { }
  getCamionList(): Observable<Camion[]>{
    return this.httpClient.get<Camion[]>(this._URL + "getAll");
  }

  updateCamion(camion: Camion): Observable<Object>{
    return this.httpClient.put(this._URL + "update", camion);
  }

  deleteCamion(id: number): Observable<Object>{
    return this.httpClient.delete(this._URL + "delete/"+`${id}`);
  }

  createCamion(camion: Camion): Observable<Object>{
    return this.httpClient.post(this._URL + "add", camion);
  }
  getCamionById(id: number): Observable<Camion>{
    return this.httpClient.get<Camion>(this._URL + "getById/"+`${id}`);
  }
}
