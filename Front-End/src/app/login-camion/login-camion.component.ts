import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-camion',
  templateUrl: './login-camion.component.html',
  styleUrls: ['./login-camion.component.css']
})
export class LoginCamionComponent implements OnInit{
  camionLoginForm: FormGroup; //form
  isFailed: boolean = false; // Authentication failed after login (Invalid username or password)
  fieldTextType: boolean = false; // show or hide password
  constructor(private fb: FormBuilder, private router: Router) {
    this.camionLoginForm = this.fb.group({
      immatriculation: ["", Validators.required],
    });
  }

  ngOnInit(): void {
  }

 
  onSubmit() {
    this.router.navigate(["/driver"])
    //verify if the camion exists
    //if yes: navigate to driver interface
    //if no: logout
  }


}

