import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { emailOrUsernameValidator } from '../shared/validator/email-or-username.validator';
import { AuthService } from '../services/auth/auth.service';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakLoginOptions } from 'keycloak-js';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  loginForm: FormGroup; //form
  isFailed: boolean = false; // Authentication failed after login (Invalid username or password)
  fieldTextType: boolean = false; // show or hide password
  constructor(private fb: FormBuilder, private router: Router, private authService: AuthService,
    private keycloakService: KeycloakService) {
    this.loginForm = this.fb.group({
      username: ["", Validators.required],// emailOrUsernameValidator(/[a-zA-Z0-9]{3,}/)],
      password: ["", Validators.required],
      rememberMe: [false]
    });
  }

  ngOnInit(): void {
  }

  toggleFieldTextType() {
    this.fieldTextType = !this.fieldTextType;
  }

  onForgotPasswordButton() {
    this.router.navigate(['/auth/password_reset']);
  }

  signup(){
    this.router.navigate(['/auth/signup']);
  }

  onSubmit() {
    // Define the login options
    const options: KeycloakLoginOptions = {
      redirectUri: window.location.origin + "/order"
    };

    // Call the login function with the options
    this.keycloakService.login(options);
    //this.keycloakService.getKeycloakInstance().redirectUri = "localhost:4200/order"
    //this.router.navigate(['/order']);
    /*.then(() => {
      this.isFailed = false; 
      // User is authenticated, navigate to home page or other protected page
      console.log(this.loginForm);
      console.log(this.authService.getLoggedUser())
      console.log(this.authService.getToken())
      this.router.navigate(['/order']);
      //{ queryParams: { label: this.currentLabelKey, soggetto: this.datiForm.get("soggetto")?.value, tipo: this.datiForm.get("tipo")?.value } })
      
    })
    .catch(() => {
      this.isFailed = true; // Authentication failed, show error message
    });*/
  }

  /*async login() {
    this.keycloakService.getKeycloakInstance().createLoginUrl({
      username: this.loginForm.controls['username'].value,
      password: this.loginForm.controls['password'].value,
    })
    try {
      await this.keycloakService.login({
        username: this.loginForm.controls['username'].value,
        password: this.loginForm.controls['password'].value,
      });

      const redirectUri = this.keycloakService.getRedirectUri();

      window.location.href = redirectUri;
    } catch (error) {
      console.error('Authentication failed', error);
    }
  }*/


}

