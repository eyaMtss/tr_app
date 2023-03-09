import { Component } from '@angular/core';
import { AuthService } from './services/auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TuniDesign-UI';
  isLoggedIn!: boolean;
  constructor(private authService: AuthService){
    this.getIsLoggedIn();
  }

  getIsLoggedIn(){
    this.authService.getIsLogged().then(
      value => {
        console.log(value);
        this.isLoggedIn = value;
      }
    )
  }
}
