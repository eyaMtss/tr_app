import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from 'src/app/models/company';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AgenceLocationService {
  private _URL = environment.domain + ":" + environment.port + "/agenceLocation/";
  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Company[]> {
    return this.httpClient.get<Company[]>(this._URL + "getAll")
  }
}
