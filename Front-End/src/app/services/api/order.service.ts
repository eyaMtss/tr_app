import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from 'src/app/models/order';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private _URL = environment.domain + ":" + environment.port + "/";
  constructor(private httpClient: HttpClient) { }
 

  getById(id: number): Observable<Order>{
    return this.httpClient.get<Order>(this._URL + "/Ordres/" + id)
  }
}

