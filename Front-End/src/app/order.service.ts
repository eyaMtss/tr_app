import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { OrderRequest } from './order-request';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) { }

  createOrder(orderRequest: OrderRequest): Observable<Object>{
    return this.httpClient.post("http://localhost:8091/PasserUnOrdre", orderRequest);
  }
}
