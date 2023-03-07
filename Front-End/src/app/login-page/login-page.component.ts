import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { emailOrUsernameValidator } from '../shared/validator/email-or-username.validator';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  loginForm: FormGroup; //form
  constructor(private fb: FormBuilder, private router: Router) {
    this.loginForm = this.fb.group({
      username: ["", Validators.required, emailOrUsernameValidator(/[a-zA-Z0-9]{3,}/)],
      password: ["", Validators.required],
      rememberMe: [false]
    })
  }

  ngOnInit(): void {
  }

  onSubmit()
  {
    console.log(this.loginForm);
    this.router.navigate(['/order']);
    
    //{ queryParams: { label: this.currentLabelKey, soggetto: this.datiForm.get("soggetto")?.value, tipo: this.datiForm.get("tipo")?.value } })
    
  }

}

