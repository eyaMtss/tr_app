import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Suivi } from 'src/app/models/suivi';

@Injectable({
  providedIn: 'root'
})
export class SuiviService {

  constructor(private httpClient: HttpClient) { }
  getSuivi(id: number): Observable<Suivi>{
    return this.httpClient.get<Suivi>("http://localhost:8092/Suiviordre/"+`${id}`);
  }
}
