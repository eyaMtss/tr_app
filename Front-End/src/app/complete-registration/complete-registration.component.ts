import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { AuthService } from '../services/auth/auth.service';
import { UserService } from '../services/api/user.service';

@Component({
  selector: 'app-complete-registration',
  templateUrl: './complete-registration.component.html',
  styleUrls: ['./complete-registration.component.css']
})
export class CompleteRegistrationComponent implements OnInit {
  constructor(private keycloakService: KeycloakService, private authService: AuthService, private userService: UserService) { }
  ngOnInit(): void {
  }

  onSubmit(): void {
    // save user's registration data
    // ...

    // mark registration as complete
    const userDetails = this.keycloakService.getKeycloakInstance().idTokenParsed;
    console.log(userDetails);
    if (userDetails) {
      userDetails['completed_registration'] = 'true';
      this.keycloakService.updateToken(5).then(() => {
        console.log('User details updated with completed_registration attribute');
        console.log(userDetails.completed_registration)
      });
      this.userService.updateCompletedRegistration(userDetails["preferred_username"]).subscribe(data => {
        console.log(data)
      })
    }
    
  }
}