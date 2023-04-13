import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lavage } from 'src/app/models/lavage/lavage';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LavageService {
  private _URL = environment.domain + ":" + environment.port + "/lavage/";
  constructor(private httpClient: HttpClient) { }

  create(lavage: Lavage): Observable<Lavage> {
    return this.httpClient.post<Lavage>(this._URL + "add", lavage);
  }

  addList(userId: number, lavages: Lavage[]): Observable<Lavage[]> {
    return this.httpClient.post<Lavage[]>(this._URL + "addAll/" + userId, lavages);
  }
}
