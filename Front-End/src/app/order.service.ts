import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http'
import { Observable } from 'rxjs';
import { OrderRequest } from './order-request';
import { OrderResponse } from './order-response';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) { }

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
}
