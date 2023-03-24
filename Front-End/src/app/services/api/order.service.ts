import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from 'src/app/models/order';
import { OrderRequest } from 'src/app/models/order-request';
import { OrderResponse } from 'src/app/models/order-response';
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

  createOrder(orderRequest: OrderRequest){

    return this.httpClient.post<any>("http://localhost:8091/PasserUnOrdre", orderRequest);
   }
  
    updatePhotos(file1: File,file2: File,file3: File,id:number): Observable<any>
    {
      const formData = new FormData();
      formData.append("id",id.toLocaleString());
      formData.append("img1",file1);
      formData.append("img2",file2);
      formData.append("img3",file3);
      return this.httpClient.put<any>("http://localhost:8091/update", formData);
  
    }
  
    deleteOrder(id: number): Observable<Object>{
      return this.httpClient.delete("http://localhost:8091/AnnulerUnOrdre/"+`${id}`);
    }
  
    getOrdre(id: number): Observable<OrderResponse>{
      return this.httpClient.get<OrderResponse>("http://localhost:8091/Ordres/"+`${id}`);
    }
}

