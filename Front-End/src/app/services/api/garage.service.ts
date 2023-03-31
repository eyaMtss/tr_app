import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Garage } from 'src/app/models/garage';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GarageService {
  private _URL = environment.domain + ":" + environment.port + "/garage/";
  constructor(private httpClient: HttpClient) { }

  create(garage: Garage): Observable<Garage> {
    return this.httpClient.post<Garage>(this._URL + "add", garage);
  }
}
