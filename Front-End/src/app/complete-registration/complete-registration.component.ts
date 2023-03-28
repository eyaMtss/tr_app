import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { AuthService } from '../services/auth/auth.service';
import { UserService } from '../services/api/user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Vehicle } from '../models/vehicle';

@Component({
  selector: 'app-complete-registration',
  templateUrl: './complete-registration.component.html',
  styleUrls: ['./complete-registration.component.css']
})
export class CompleteRegistrationComponent implements OnInit {
  completedRegistrationForm: FormGroup;
  currentRole!: string;
  addressForm!: FormGroup; // address form
  // image
  selectedUserImage!: File;// image
  retrievedImage: any;
  viewedImage: any = "/assets/auth/user.png" // default image
  temporaryRetrievedImage: any;
  // vahicule
  maxVehicleNumber: number = 5; // 
  currentVehicleNumber: number = 1; // user must have at least 1 vehicule
  vehiculeValues: Vehicle[] = []; //user can have several vehicules, we put them in a list: vehiculeValues
  // garage 
  garageType: string = "";
  constructor(private keycloakService: KeycloakService, private authService: AuthService, private userService: UserService, private fb: FormBuilder) { 
    this.completedRegistrationForm = this.fb.group({
      img: [''],
      matriculeFiscale: ['', Validators.required],
      garageType: ['', Validators.required]
    })
  }
  ngOnInit(): void {
    this.currentRole = this.authService.getRoles()[0]; // role is CLIENT by default
    console.log(this.currentRole);
    this.onAddVehicleBtn(); //by default, there is only one input of vehiculeValues
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
      // save to entity !!! depending on role
    }
  }

  onAddVehicleBtn() { // add a new vehicule
    if (this.vehiculeValues.length < this.maxVehicleNumber) {
      this.vehiculeValues.push(new Vehicle());
      this.currentVehicleNumber += 1;
      console.log(this.vehiculeValues);
    }
  }

  onDeleteButton(i: any): void {  //delete the i input field for vehiculesValues list
    if (this.vehiculeValues.length == 1)   //always keep a field
      this.vehiculeValues[i] = new Vehicle()
    else {
      this.vehiculeValues.splice(i, 1);
      this.currentVehicleNumber -= 1;
    }
  }

  getVehicleForm(vehicleForm: FormGroup, index: number) {
    console.log(index);
    console.log(vehicleForm);
    this.vehiculeValues[index].typeImmat = vehicleForm.controls['registrationType'].value;
    this.vehiculeValues[index].numImmat = vehicleForm.controls['registrationNumber'].value;
    this.vehiculeValues[index].confirmNumImmat = vehicleForm.controls['confirmRegistrationNumber'].value;
    this.vehiculeValues[index].marque = vehicleForm.controls['brand'].value;
    this.vehiculeValues[index].numChassis = vehicleForm.controls['chassisNumber'].value;
    this.vehiculeValues[index].numContrat = vehicleForm.controls['contractNumber'].value;
    this.vehiculeValues[index].couleur = vehicleForm.controls['color'].value;
    this.vehiculeValues[index].kilometrage = vehicleForm.controls['kilometrage'].value;
    this.vehiculeValues[index].puissance = vehicleForm.controls['power'].value;
    this.vehiculeValues[index].nbPortes = vehicleForm.controls['doorsNumber'].value;
    this.vehiculeValues[index].poids = vehicleForm.controls['weight'].value;
  }

  onGarageTypeChange(){
    let garageTypeValue = this.completedRegistrationForm.controls['garageType'].value;
    if("wrench".includes(garageTypeValue)){
      this.garageType = "mecanique";
    }
    else if("plug".includes(garageTypeValue)){
      this.garageType = "electrique";
    }
    else if("tire".includes(garageTypeValue)){
      this.garageType = "pneumatique";
    }
  }
}