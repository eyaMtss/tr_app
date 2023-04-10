import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicle } from 'src/app/models/vehicle/vehicle';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {
  private _URL = environment.domain + ":" + environment.port + "/vehicule/";
  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Vehicle[]> {
    return this.httpClient.get<Vehicle[]>(this._URL + "getAll")
  }

  getById(id: number): Observable<Vehicle>{
    return this.httpClient.get<Vehicle>(this._URL + "getById/" + id);
  }

  create(vehicle: Vehicle): Observable<Vehicle> {
    return this.httpClient.post<Vehicle>(this._URL + 'add', vehicle);
  }

  deleteVehicle(id: number){
    return this.httpClient.delete<Vehicle>(this._URL + "delete/" + id);
  }
 
  editVehicle(vehicle: Vehicle): Observable<Vehicle>{
    return this.httpClient.put<Vehicle>(this._URL + "update/", vehicle);
  }
}
