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

  completeRegistration(formData: FormData, username: string, country: string, governorate: string,
    city: string, zipCode: number, matriculeFiscale: string, cin: number): Observable<User>{
    /*const boundary = Math.random().toString().substr(2);
    formData.set('Content-Type', `multipart/form-data; boundary=${boundary}`);

    console.log(formData.get('imageFile'));
    console.log(formData.get('username'));
    const headers = new HttpHeaders({
      'Content-Type': `multipart/form-data; boundary=${boundary}`,
    });
    const options = { headers, withCredentials: true };*/
    
    return this.httpClient.put<User>(this._URL + "completeRegistration/" + username + "/" + country + "/" + 
    governorate + "/" + city + "/" + zipCode + "/" + matriculeFiscale + "/" + cin, formData);
  }
  
  getAll(): Observable<User[]> {
    return this.httpClient.get<User[]>(this._URL + "getAll")
  }

  getById(id: number): Observable<User>{
    return this.httpClient.get<User>(this._URL + "getById/" + id);
  }

  getByUsername(username: string): Observable<User>{
    return this.httpClient.get<User>(this._URL + "getByUsername/" + username);
  }

  deleteUser(id: number){
    return this.httpClient.delete<User>(this._URL + "delete/" + id);
  }

  public uploadImage(username: string, uploadImageData: FormData): Observable<any>{
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    return this.httpClient.post(this._URL + "uploadImage/" + username, uploadImageData);
  }
  public getImage(profileId: number): Observable<any>{
    return this.httpClient.get(this._URL + "getImage/" + profileId);
  }

  updateCompletedRegistration(username: string): Observable<any>{
    return this.httpClient.put(this._URL + "updateCompletedRegistration/"+ username, {})
  }
}
