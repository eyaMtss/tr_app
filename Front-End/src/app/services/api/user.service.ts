import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UpdatedUser } from 'src/app/models/user/updated-user';
import { User } from 'src/app/models/user/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private _URL = environment.domain + ":" + environment.port + "/users/";
  constructor(private httpClient: HttpClient) { }

  create(user: User): Observable<User> { // signup
    return this.httpClient.post<User>(this._URL + "add", user);
  }

  completeRegistration(user: UpdatedUser): Observable<User>{
    return this.httpClient.put<User>(this._URL + "completeRegistration/", user);
  }
  
  getAll(): Observable<User[]> {
    return this.httpClient.get<User[]>(this._URL + "getAll")
  }

  getById(id: number): Observable<User>{
    return this.httpClient.get<User>(this._URL + "getById/" + id);
  }

  deleteUser(id: number){
    return this.httpClient.delete<User>(this._URL + "delete/" + id);
  }

  public uploadImage(userId: number, uploadImageData: FormData): Observable<any>{
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    return this.httpClient.post(this._URL + "uploadImage/" + userId, uploadImageData);
  }
  public getImage(profileId: number): Observable<any>{
    return this.httpClient.get(this._URL + "getImage/" + profileId);
  }

  updateCompletedRegistration(username: string): Observable<any>{
    return this.httpClient.get(this._URL + "updateCompletedRegistration/"+ username)
  }
}
