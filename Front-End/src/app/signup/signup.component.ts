import { Component, OnInit } from '@angular/core';
import { KeycloakLoginOptions } from 'keycloak-js';
import { FormGroup } from '@angular/forms';
import { UserService } from '../services/api/user.service';
import { AuthService } from '../services/auth/auth.service';
import { User } from '../models/user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user: User = new User();
  // informationsForm
  informationsForm!: FormGroup;
  currentRole!: string; //user is the default user
  isInformationsNextBtnDisabled: Boolean = true;
  company!: string;
  // credentialsForm
  credentialsForm!: FormGroup;
  isCredentialsNextBtnDisabled: Boolean = true;

  constructor(private userService: UserService, private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  getCurrentRole(currentRole: string) {
    this.currentRole = currentRole;
  }

  getInformationsForm(informationsForm: FormGroup) {
    console.log(informationsForm)
    this.informationsForm = informationsForm;
    if (this.informationsForm.valid) {
      console.log(this.informationsForm.valid)
      console.log(this.isInformationsNextBtnDisabled)
      this.isInformationsNextBtnDisabled = false; // enable next btn
      this.currentRole = this.informationsForm.controls['role'].value;

      this.user.role = this.currentRole;
      this.user.firstName = this.informationsForm.controls['firstname'].value;
      this.user.lastName = this.informationsForm.controls['lastname'].value;
      this.user.email = this.informationsForm.controls['email'].value;
      this.user.phoneNumber = this.informationsForm.controls['phone'].value['number'];
      this.user.countryCode = this.informationsForm.controls['phone'].value['countryCode']
      this.user.dialCode = this.informationsForm.controls['phone'].value['dialCode']
      this.user.birthdate = this.informationsForm.controls['birthdate'].value;
      this.user.gender = this.informationsForm.controls['gender'].value;
      this.company = this.informationsForm.controls['company'].value;
      console.log(this.user.countryCode)
      if (this.currentRole == "CLIENT" || this.currentRole == "GARAGISTE" || this.currentRole == "LAVAGISTE" ||
      this.currentRole == "EXPERT") { 
        this.user.username = this.informationsForm.controls['username'].value;
      }
      else {
        this.user.username = this.generateUsername();
      }
    }
    
    else
      this.isInformationsNextBtnDisabled = true; // disable next btn
  }

  generateUsername(){
    return this.company + "_" + this.user.firstName + this.user.lastName
  }

  getCredentialsForm(credentialsForm: FormGroup) {
    this.credentialsForm = credentialsForm;
    if (this.credentialsForm.valid) {
      this.isCredentialsNextBtnDisabled = false; // enable next btn
      this.user.password = this.credentialsForm.controls['password'].value;
      this.user.confirmPassword = this.credentialsForm.controls['confirmPassword'].value;
    }
    else {
      this.isCredentialsNextBtnDisabled = true; // disable next btn
    }
  }

  signup() {
    if (this.currentRole == "SOCIETE_REMORQUAGE_ADMIN" || this.currentRole == "AGENCE_LOCATION_ADMIN" ||
      this.currentRole == "INSURANCE_ADMIN"){
        window.alert("Votre nom d'utilisateur est: " + this.user.username)
      }
    
    this.userService.create(this.user).subscribe(res => {
      console.log(res);
      this.signin();
    });
  }
  
  // redirect to signin interface after inscription
  signin() {
    const loginOptions: KeycloakLoginOptions = {
      redirectUri: window.location.origin + "/tunidesign"
    };
    this.authService.login(loginOptions);
  }
}
