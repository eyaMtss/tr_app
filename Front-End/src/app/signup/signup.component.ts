import { Component, OnInit } from '@angular/core';
import { KeycloakLoginOptions } from 'keycloak-js';
import { Client } from '../models/client';
import { InsuranceAdmin } from '../models/insurance-admin';
import { SocieteRemorquageAdmin } from '../models/societe-remorquage-admin';
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
  // image
  retrievedImage: any;
  viewedImage: any;
  temporaryRetrievedImage: any;

  // addressForm
  addressForm!: FormGroup;
  isAddressNextBtnDisabled: Boolean = true;
  //vehicule section when role = user
  //maxVehicleNumber: number = 5; // 
  //currentVehicleNumber: number = 1; // user must have at least 1 vehicule
  //vehiculeValues: Vehicle[] = []; //user can have several vehicules, we put them in a list: vehiculeValues

  // credentialsForm
  credentialsForm!: FormGroup;
  isCredentialsNextBtnDisabled: Boolean = true;

  constructor(private userService: UserService, private authService: AuthService) {
  }

  ngOnInit(): void {
    //this.onAddVehicleBtn(); //by default, there is only one input of vehiculeValues
  }

  /*onAddVehicleBtn() { // add a new vehicule
    if (this.vehiculeValues.length < this.maxVehicleNumber) {
      this.vehiculeValues.push(new Vehicle());
      this.currentVehicleNumber += 1;
      console.log(this.vehiculeValues);
    }
  }*/

  /*onDeleteButton(i: any): void {  //delete the i input field for vehiculesValues list
    if (this.vehiculeValues.length == 1)   //always keep a field
      this.vehiculeValues[i] = new Vehicle()
    else {
      this.vehiculeValues.splice(i, 1);
      this.currentVehicleNumber -= 1;
    }
  }*/

  getCurrentRole(currentRole: string) {
    this.currentRole = currentRole;
  }

  getInformationsForm(informationsForm: FormGroup) {
    this.informationsForm = informationsForm;
    if (this.informationsForm.valid) {
      this.isInformationsNextBtnDisabled = false; // enable next btn
      this.currentRole = this.informationsForm.controls['role'].value;

      this.user.firstName = this.informationsForm.controls['firstname'].value;
      this.user.lastName = this.informationsForm.controls['lastname'].value;
      this.user.email = this.informationsForm.controls['email'].value;
      this.user.phoneNumber = this.informationsForm.controls['phone'].value;
      this.user.gender = this.informationsForm.controls['gender'].value;
      this.user.birthdate = this.informationsForm.controls['birthdate'].value;
    }
    if (this.currentRole != "CLIENT") { // !!!!!!!!!!!
      this.user.username = this.informationsForm.controls['username'].value;

    }
    else
      this.isInformationsNextBtnDisabled = true; // disable next btn
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
    this.userService.create(this.user).subscribe(res => {
      console.log(res);
      this.signin();
    });
  }

  //Gets called when the user clicks on save to upload the image
  onUpload(userId: number) {
    if (this.informationsForm.controls['img'].value != undefined) { // if we change the image
      //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
      const uploadImageData = new FormData();
      uploadImageData.append('imageFile', this.informationsForm.controls['img'].value);
      //uploadImageData.append('profileId', (this.profile.profileId).toString());
      this.userService.uploadImage(userId, uploadImageData).subscribe(response => { // get api
        this.viewedImage = this.temporaryRetrievedImage; // view the new image
      });
    }
  }

  // redirect to signin interface after inscription
  signin() {
    const loginOptions: KeycloakLoginOptions = {
      redirectUri: window.location.origin + "/tunidesign"
    };
    this.authService.login(loginOptions);
  }
}
