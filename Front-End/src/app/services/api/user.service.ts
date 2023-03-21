import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from 'src/app/models/client';
import { InsuranceAdmin } from 'src/app/models/insurance-admin';
import { SocieteRemorquageAdmin } from 'src/app/models/societe-remorquage-admin';
import { User } from 'src/app/models/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private _URL = environment.domain + ":" + environment.port + "/users/";
  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<User[]> {
    return this.httpClient.get<User[]>(this._URL + "getAll")
  }

  getById(id: number): Observable<User>{
    return this.httpClient.get<User>(this._URL + "getById/" + id);
  }

  create(user: User): Observable<User> {
    return this.httpClient.post<User>(this._URL + "add", user);
  }

  createClient(client: Client): Observable<Client> {
    return this.httpClient.post<Client>(this._URL + "addClient", client);
  }

  createInsuranceAdmin(insuranceAdmin: InsuranceAdmin): Observable<User> {
    return this.httpClient.post<User>(this._URL + "addInsuranceAdmin", insuranceAdmin);
  }

  createSocieteRemorquageAdmin(societeRemorquageAdmin: SocieteRemorquageAdmin): Observable<User> {
    return this.httpClient.post<User>(this._URL + "addCompany", societeRemorquageAdmin);
  }

  deleteUser(id: number){
    return this.httpClient.delete<User>(this._URL + "delete/" + id);
  }
 
  editUser(user: User): Observable<User>{
    return this.httpClient.put<User>(this._URL + "update/", user);
  }

  public uploadImage(uploadImageData: FormData): Observable<any>{
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    return this.httpClient.post(this._URL+ "uploadImage", uploadImageData);
  }
  public getImage(profileId: number): Observable<any>{
    return this.httpClient.get(this._URL + "getImage/" + profileId);
  }
}
