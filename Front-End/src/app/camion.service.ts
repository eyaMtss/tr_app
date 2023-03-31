import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Camion } from './camion';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class CamionService {

  constructor(private httpClient: HttpClient) { }
  getCamionList(): Observable<Camion[]>{
    return this.httpClient.get<Camion[]>("http://localhost:8091/Camions");
  }

  updateCamion(camion: Camion): Observable<Object>{
    return this.httpClient.put("http://localhost:8091/ModifierUnCamion", camion);
  }

  deleteCamion(id: number): Observable<Object>{
    return this.httpClient.delete("http://localhost:8091/AnnulerUnCamion/"+`${id}`);
  }

  createCamion(camion: Camion): Observable<Object>{
    return this.httpClient.post("http://localhost:8091/AjouterUnCamion", camion);
  }
  getCamionById(id: number): Observable<Camion>{
    return this.httpClient.get<Camion>("http://localhost:8091/Camions/"+`${id}`);
  }
}
