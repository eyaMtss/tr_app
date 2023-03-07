import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { emailOrUsernameValidator } from '../shared/validator/email-or-username.validator';
import { AuthService } from '../services/authentication/auth.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  loginForm: FormGroup; //form
  isFailed: boolean = false; // Authentication failed after login (Invalid username or password)
  constructor(private fb: FormBuilder, private router: Router, private authService: AuthService) {
    this.loginForm = this.fb.group({
      username: ["", Validators.required],// emailOrUsernameValidator(/[a-zA-Z0-9]{3,}/)],
      password: ["", Validators.required],
      rememberMe: [false]
    });
  }

  ngOnInit(): void {
  }

  onForgotPasswordButton(){
    this.router.navigate(['/password_reset']);
  }

  onSubmit() {
   
    this.authService.login(this.loginForm.controls['username'].value, this.loginForm.controls['password'].value)
      .then(() => {
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
      });
  }

}

