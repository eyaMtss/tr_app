import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BreakpointObserver } from '@angular/cdk/layout';
import { StepperOrientation } from '@angular/material/stepper';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from 'src/app/models/user';
import { Client } from 'src/app/models/client';
import { InsuranceAdmin } from 'src/app/models/insurance-admin';
import { SocieteRemorquageAdmin } from 'src/app/models/societe-remorquage-admin';
import { Vehicle } from 'src/app/models/vehicle';
import { UserService } from 'src/app/services/api/user.service';
import { VehicleService } from 'src/app/services/api/vehicle.service';
import { KeycloakService } from 'keycloak-angular';
import { AuthService } from 'src/app/services/auth/auth.service';
import { KeycloakLoginOptions } from 'keycloak-js';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})

export class SignUpComponent implements OnInit {
  stepperOrientation: Observable<StepperOrientation>; // stepper

  client: Client = new Client();
  insuranceAdmin: InsuranceAdmin = new InsuranceAdmin();
  societeRemorquageAdmin: SocieteRemorquageAdmin = new SocieteRemorquageAdmin();
  // informationsForm
  informationsForm!: FormGroup;
  currentRole: number = 1; //user is the default user
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

  registration = {
    username: 'myusername',
    email: 'eya.mattoussiii@gmail.com',
    password: 'mypassword',
  };
  constructor(breakpointObserver: BreakpointObserver, private userService: UserService,
    private authService: AuthService) {
    // responsive stepper
    this.stepperOrientation = breakpointObserver
      .observe('(min-width: 800px)')
      .pipe(map(({ matches }) => (matches ? 'horizontal' : 'vertical')));
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

  getCurrentRole(currentRole: number) {
    this.currentRole = currentRole;
  }

  getInformationsForm(informationsForm: FormGroup) {
    this.informationsForm = informationsForm;
    if (this.informationsForm.valid) {
      this.isInformationsNextBtnDisabled = false; // enable next btn
      this.currentRole = this.informationsForm.controls['role'].value;
      if (this.currentRole == 1) {
        this.client.firstName = this.informationsForm.controls['firstname'].value;
        this.client.lastName = this.informationsForm.controls['lastname'].value;
        this.client.email = this.informationsForm.controls['email'].value;
        this.client.phoneNumber = this.informationsForm.controls['phone'].value;
        this.client.gender = this.informationsForm.controls['gender'].value;
        this.client.birthdate = this.informationsForm.controls['birthdate'].value;
      }
      else if (this.currentRole == 2) { // insurance
        this.insuranceAdmin.firstName = this.informationsForm.controls['firstname'].value;
        this.insuranceAdmin.lastName = this.informationsForm.controls['lastname'].value;
        this.insuranceAdmin.email = this.informationsForm.controls['email'].value;
        this.insuranceAdmin.phoneNumber = this.informationsForm.controls['phone'].value;
        this.insuranceAdmin.gender = this.informationsForm.controls['gender'].value;
        this.insuranceAdmin.birthdate = this.informationsForm.controls['birthdate'].value;
        this.insuranceAdmin.insuranceCompanyId = this.informationsForm.controls['comapny'].value;
        this.insuranceAdmin.matriculeFiscale = this.informationsForm.controls['matriculeFiscale'].value;
      }
      else if (this.currentRole == 3) { // societe remorquage
        this.societeRemorquageAdmin.firstName = this.informationsForm.controls['firstname'].value;
        this.societeRemorquageAdmin.lastName = this.informationsForm.controls['lastname'].value;
        this.societeRemorquageAdmin.email = this.informationsForm.controls['email'].value;
        this.societeRemorquageAdmin.phoneNumber = this.informationsForm.controls['phone'].value;
        this.societeRemorquageAdmin.gender = this.informationsForm.controls['gender'].value;
        this.societeRemorquageAdmin.birthdate = this.informationsForm.controls['birthdate'].value;
        this.societeRemorquageAdmin.companyId = this.informationsForm.controls['comapny'].value;
        this.societeRemorquageAdmin.matriculeFiscale = this.informationsForm.controls['matriculeFiscale'].value;
      }

    }
    else
      this.isInformationsNextBtnDisabled = true; // disable next btn
  }

  getAddressForm(addressForm: FormGroup) {
    this.addressForm = addressForm;
    if (this.addressForm.valid) {
      this.isAddressNextBtnDisabled = false; // enable next btn
      if (this.currentRole == 1) {
        this.client.country = this.addressForm.controls['country'].value;
        this.client.governorate = this.addressForm.controls['governorate'].value;
        this.client.city = this.addressForm.controls['city'].value;
        this.client.zipCode = this.addressForm.controls['zipCode'].value;
      }
      else if (this.currentRole == 2) { // insurance
        this.insuranceAdmin.country = this.addressForm.controls['country'].value;
        this.insuranceAdmin.governorate = this.addressForm.controls['governorate'].value;
        this.insuranceAdmin.city = this.addressForm.controls['city'].value;
        this.insuranceAdmin.zipCode = this.addressForm.controls['zipCode'].value;
      }
      else if (this.currentRole == 3) { // societe remorquage
        this.societeRemorquageAdmin.country = this.addressForm.controls['country'].value;
        this.societeRemorquageAdmin.governorate = this.addressForm.controls['governorate'].value;
        this.societeRemorquageAdmin.city = this.addressForm.controls['city'].value;
        this.societeRemorquageAdmin.zipCode = this.addressForm.controls['zipCode'].value;
      }
    }
    else {
      this.isAddressNextBtnDisabled = true; // disable next btn
    }
  }

  getCredentialsForm(credentialsForm: FormGroup) {
    this.credentialsForm = credentialsForm;
    if (this.credentialsForm.valid) {
      this.isCredentialsNextBtnDisabled = false; // enable next btn
      if (this.currentRole == 1) {
        this.client.password = this.credentialsForm.controls['password'].value;
        this.client.confirmPassword = this.credentialsForm.controls['confirmPassword'].value;
      }
      else if (this.currentRole == 2) { // insurance
        this.insuranceAdmin.password = this.credentialsForm.controls['password'].value;
        this.insuranceAdmin.confirmPassword = this.credentialsForm.controls['confirmPassword'].value;
      }
      else if (this.currentRole == 3) { // societe remorquage
        this.societeRemorquageAdmin.password = this.credentialsForm.controls['password'].value;
        this.societeRemorquageAdmin.confirmPassword = this.credentialsForm.controls['confirmPassword'].value;
      }
    }
    else {
      this.isCredentialsNextBtnDisabled = true; // disable next btn
    }
  }

  signup() {
    switch (this.currentRole) {
      case 1: { //client
        this.userService.createClient(this.client).subscribe(res => {
          console.log(res);
          this.onUpload(res.userId);

        });

        break;
      }
      case 2: { //insurance admin
        this.userService.createInsuranceAdmin(this.insuranceAdmin).subscribe(res => {
          console.log(res);
          this.onUpload(res.userId);
        });

        break;
      }
      case 3: { //societeRemorquage admin
        this.userService.createSocieteRemorquageAdmin(this.societeRemorquageAdmin).subscribe(res => {
          console.log(res);
          this.onUpload(res.userId);
        });

        break;
      }
    }
    this.signin();
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
      redirectUri: window.location.origin + "/order"
    };
    this.authService.login(loginOptions);
  }

}