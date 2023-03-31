import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { AuthService } from '../services/auth/auth.service';
import { UserService } from '../services/api/user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Vehicle } from '../models/vehicle';
import { Router } from '@angular/router';
import { UpdatedUser } from '../models/updated-user';
import { Garage } from '../models/garage';
import { Lavage } from '../models/lavage';

@Component({
  selector: 'app-complete-registration',
  templateUrl: './complete-registration.component.html',
  styleUrls: ['./complete-registration.component.css']
})
export class CompleteRegistrationComponent implements OnInit {
  user: UpdatedUser = new UpdatedUser();
  completedRegistrationForm: FormGroup;
  currentRole!: string;
  currentUsername!: string;
  addressForm!: FormGroup; // address form
  // image
  selectedUserImage!: File;// image
  retrievedImage: any;
  viewedImage: any = "/assets/auth/user.png" // default image
  temporaryRetrievedImage: any;
  // vahicule
  maxVehicleNumber: number = 5; // 
  currentVehicleNumber: number = 1; // user must have at least 1 vehicule
  vehicleValues: Vehicle[] = []; //user can have several vehicules, we put them in a list: vehicleValues
  // garage
  maxGarageNumber: number = 5; // 
  currentGarageNumber: number = 1; // user must have at least 1 garage
  garageValues: Garage[] = []; //user can have several vehicules, we put them in a list: vehicleValues
  // lavage
  maxLavageNumber: number = 5; // 
  currentLavageNumber: number = 1; // user must have at least 1 lavage
  lavageValues: Lavage[] = []; //user can have several vehicules, we put them in a list: vehicleValues

  matriculeFiscaleValue!: string; // ngModel
  constructor(private keycloakService: KeycloakService, private authService: AuthService, private userService: UserService,
    private fb: FormBuilder, private router: Router) {
    this.completedRegistrationForm = this.fb.group({
      img: [''],
      matriculeFiscale: ['', Validators.required]
    })
  }
  ngOnInit(): void {
    this.currentRole = this.authService.getRoles()[0]; // role is CLIENT by default
    if (this.currentRole == 'CLIENT') {
      this.completedRegistrationForm.controls['matriculeFiscale'].disable();
    }
    else {
      this.completedRegistrationForm.controls['matriculeFiscale'].enable();
    }
    this.currentUsername = this.authService.getUsername(); // get username from token
    this.user.username = this.currentUsername; // set username
    console.log(this.currentRole);
    console.log(this.currentUsername);
    if (this.currentRole == "CLIENT") {
      this.onAddVehicleBtn()
      //by default, there is only one input of vehicleValues
    }
    else if (this.currentRole == "GARAGISTE_ADMIN") {
      this.onAddGarageBtn()
      //by default, there is only one input of garageValues
    }
    else if (this.currentRole == "LAVAGISTE_ADMIN") {
      this.onAddLavageBtn()
      //by default, there is only one input of lavageValues
    }
  }

  onConfirm() {

    // save user's registration data && mark registration as complete(completed_registration attribute)
    this.userService.completeRegistration(this.user).subscribe(data => {
      this.setTokenRegistration();
      console.log(data);
    })
    this.navigate();
  }

  navigate() {
    this.router.navigate(["/tunidesign"]); //path : registrationGUARD
  }

  setTokenRegistration(): void {
    // mark registration as complete
    const userDetails = this.authService.getUserDetails();
    console.log(userDetails);
    if (userDetails) {
      userDetails['completed_registration'] = 'true';
      this.keycloakService.updateToken(5).then(() => {
        console.log('User details updated with completed_registration attribute');
        console.log(userDetails.completed_registration)
      });
    }
  }

  // Image
  public onFileChanged(event: any) {  //Gets called when the user selects an image
    //Select File
    this.selectedUserImage = event.target.files[0];
    console.log(this.selectedUserImage)
    var reader = new FileReader();
    reader.readAsDataURL(this.selectedUserImage);
    reader.onload = (_event) => {
      this.viewedImage = reader.result;
    }
    this.completedRegistrationForm.controls['img'].setValue(this.selectedUserImage);
  }

  //Gets called when the user clicks on save to upload the image
  onUpload(userId: number) {
    if (this.completedRegistrationForm.controls['img'].value != undefined) { // if we change the image
      //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
      const uploadImageData = new FormData();
      uploadImageData.append('imageFile', this.completedRegistrationForm.controls['img'].value);
      //uploadImageData.append('profileId', (this.profile.profileId).toString());
      this.userService.uploadImage(userId, uploadImageData).subscribe(response => { // get api
        this.viewedImage = this.temporaryRetrievedImage; // view the new image
      });
    }
  }

  getAddressForm(addressForm: FormGroup) {
    console.log(addressForm);
    this.addressForm = addressForm;
    if (this.addressForm.valid) {
      this.user.country = this.addressForm.controls['country'].value;
      this.user.governorate = this.addressForm.controls['governorate'].value;
      this.user.city = this.addressForm.controls['city'].value;
      this.user.zipCode = this.addressForm.controls['zipCode'].value;
    }
  }

  onAddVehicleBtn() {
    if (this.vehicleValues.length < this.maxVehicleNumber) {
      this.vehicleValues.push(new Vehicle());
      this.currentVehicleNumber += 1;
      console.log(this.vehicleValues);
    }
  }

  onAddGarageBtn() {
    if (this.garageValues.length < this.maxGarageNumber) {
      this.garageValues.push(new Garage());
      this.currentGarageNumber += 1;
      console.log(this.garageValues);
    }
  }

  onAddLavageBtn() {
    if (this.lavageValues.length < this.maxLavageNumber) {
      this.lavageValues.push(new Lavage());
      this.currentLavageNumber += 1;
      console.log(this.lavageValues);
    }
  }

  onDeleteVehicleButton(i: any): void {  //delete the i input field for vehiculesValues list
    if (this.vehicleValues.length == 1)   //always keep a field
      this.vehicleValues[i] = new Vehicle()
    else {
      this.vehicleValues.splice(i, 1);
      this.currentVehicleNumber -= 1;
    }
  }

  onDeleteGarageButton(i: any): void {  //delete the i input field for garageValues list
    if (this.garageValues.length == 1)   //always keep a field
      this.garageValues[i] = new Garage()
    else {
      this.garageValues.splice(i, 1);
      this.currentGarageNumber -= 1;
    }
  }

  onDeleteLavageButton(i: any): void {  //delete the i input field for lavageValues list
    if (this.lavageValues.length == 1)   //always keep a field
      this.lavageValues[i] = new Lavage()
    else {
      this.lavageValues.splice(i, 1);
      this.currentLavageNumber -= 1;
    }
  }


  getVehicleForm(vehicleForm: FormGroup, index: number) {
    console.log(index);
    console.log(vehicleForm);
    this.vehicleValues[index].typeImmat = vehicleForm.controls['registrationType'].value;
    this.vehicleValues[index].numImmat = vehicleForm.controls['registrationNumber'].value;
    this.vehicleValues[index].confirmNumImmat = vehicleForm.controls['confirmRegistrationNumber'].value;
    this.vehicleValues[index].marque = vehicleForm.controls['brand'].value;
    this.vehicleValues[index].numChassis = vehicleForm.controls['chassisNumber'].value;
    this.vehicleValues[index].numContrat = vehicleForm.controls['contractNumber'].value;
    this.vehicleValues[index].couleur = vehicleForm.controls['color'].value;
    this.vehicleValues[index].kilometrage = vehicleForm.controls['kilometrage'].value;
    this.vehicleValues[index].puissance = vehicleForm.controls['power'].value;
    this.vehicleValues[index].nbPortes = vehicleForm.controls['doorsNumber'].value;
    this.vehicleValues[index].poids = vehicleForm.controls['weight'].value;
  }

  getGarageForm(garageForm: FormGroup, index: number) {
    console.log(index);
    console.log(garageForm);
    this.garageValues[index].name = garageForm.controls['name'].value;
    this.garageValues[index].capacity = garageForm.controls['capacity'].value;
    this.garageValues[index].garageType = garageForm.controls['garageType'].value;
    this.garageValues[index].email = garageForm.controls['email'].value;
    this.garageValues[index].phone = garageForm.controls['phone'].value;
    this.garageValues[index].address = garageForm.controls['address'].value;
    this.garageValues[index].garageOwner = 125; //from token
  }

  getLavageForm(garageForm: FormGroup, index: number) {
    console.log(index);
    console.log(garageForm);
    this.lavageValues[index].name = garageForm.controls['name'].value;
    this.lavageValues[index].capacity = garageForm.controls['capacity'].value;
    this.lavageValues[index].email = garageForm.controls['email'].value;
    this.lavageValues[index].phone = garageForm.controls['phone'].value;
    this.lavageValues[index].address = garageForm.controls['address'].value;
    this.lavageValues[index].lavageOwner = 125; //from token
    this.lavageValues[index].currentNbVehicle = 0; //by default
  }

  onMatriculeFiscaleChange() {
    console.log(this.completedRegistrationForm.controls['matriculeFiscale'].value);
    this.user.matriculeFiscale = this.completedRegistrationForm.controls['matriculeFiscale'].value;
  }
}