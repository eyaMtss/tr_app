import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { AuthService } from '../services/auth/auth.service';
import { UserService } from '../services/api/user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Vehicle } from '../models/vehicle/vehicle';
import { Router } from '@angular/router';
import { UpdatedUser } from '../models/user/updated-user';
import { Garage } from '../models/garage/garage';
import { Lavage } from '../models/lavage/lavage';
import { Office } from '../models/office/office';
import { VehicleService } from '../services/api/vehicle.service';
import { GarageService } from '../services/api/garage.service';
import { LavageService } from '../services/api/lavage.service';

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
  // office
  maxOfficeNumber: number = 5; // 
  currentOfficeNumber: number = 1; // user must have at least 1 office
  officeValues: Office[] = []; //user can have several vehicules, we put them in a list: vehicleValues

  matriculeFiscaleValue!: string; // ngModel
  constructor(private keycloakService: KeycloakService, private authService: AuthService, private userService: UserService,
    private fb: FormBuilder, private router: Router, private vehicleService: VehicleService,
    private garageService: GarageService, private lavageService: LavageService) {
    this.completedRegistrationForm = this.fb.group({
      img: [''],
      matriculeFiscale: ['', Validators.required],
      cin: ['', Validators.required]
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
    else if (this.currentRole == "EXPERT") {
      this.onAddOfficeBtn()
      //by default, there is only one input of officeValues
    }
  }

  onConfirm() {
    
    this.navigate();
  }

  navigate() {
    //this.router.navigate(["/tunidesign"]); //path : registrationGUARD
    let role = this.currentRole;
    if(role == "CLIENT") this.router.navigate(["/client"]);
    else if(role == "GARAGISTE_ADMIN") this.router.navigate(["/garagisteAdmin"]);
    else if(role == "LAVAGISTE_ADMIN") this.router.navigate(["/lavagisteAdmin"]);
    else if(role == "INSURANCE_ADMIN") this.router.navigate(["/insuranceAdmin"]);
    else if(role == "AGENCE_LOCATION_ADMIN") this.router.navigate(["/agenceLocationAdmin"]);
    else if(role == "DRIVER") this.router.navigate(['camion-login']);
    else if(role == "TA") this.router.navigate(["/ta"]);
    else if(role == "SOCIETE_REMORQUAGE_ADMIN") this.router.navigate(["/societe"]);
    else if(role == "EXPERT") this.router.navigate(["/expert"]);
    else this.router.navigate(["/home"]);
  }

  setTokenRegistration(): void {
    // mark registration as complete
    const userDetails = this.authService.getUserDetails();
    console.log(userDetails);
    if (userDetails) {
      userDetails['completed_registration'] = '1';
      this.keycloakService.updateToken(5).then(() => {
        console.log('User details updated with completed_registration attribute');
        console.log(userDetails.completed_registration)
      });
    }
    console.log(userDetails);
  }

  // Image
  public onFileChanged(event: any) {  //Gets called when the user selects an image
    //Select File
    this.selectedUserImage = event.target.files[0];
    console.log(this.selectedUserImage)
    var reader = new FileReader();
    reader.readAsDataURL(this.selectedUserImage);
    reader.onload = (_event) => {
      this.temporaryRetrievedImage = reader.result;
      this.viewedImage = this.temporaryRetrievedImage;
    }
    this.completedRegistrationForm.controls['img'].setValue(this.selectedUserImage);
  }

  //Gets called when the user clicks on save to upload the image
  onUpload(username: string) {
    if (this.completedRegistrationForm.controls['img'].value != undefined) { // if we change the image
      //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
      const uploadImageData = new FormData();
      uploadImageData.append('imageFile', this.completedRegistrationForm.controls['img'].value);
      //uploadImageData.append('profileId', (this.profile.profileId).toString());
      this.userService.uploadImage(username, uploadImageData).subscribe(response => { // get api
        this.viewedImage = this.temporaryRetrievedImage; // view the new image
        console.log(response);
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

  onAddOfficeBtn() {
    if (this.officeValues.length < this.maxOfficeNumber) {
      this.officeValues.push(new Office());
      this.currentOfficeNumber += 1;
      console.log(this.officeValues);
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

  onDeleteOfficeButton(i: any): void {  //delete the i input field for officeValues list
    if (this.officeValues.length == 1)   //always keep a field
      this.officeValues[i] = new Office()
    else {
      this.officeValues.splice(i, 1);
      this.currentOfficeNumber -= 1;
    }
  }


  getVehicleForm(vehicleForm: FormGroup, index: number) {
    console.log(index);
    console.log(vehicleForm);
    this.vehicleValues[index].typeImmat = vehicleForm.controls['registrationType'].value;
    this.vehicleValues[index].numImmat = vehicleForm.controls['registrationNumber'].value;
    this.vehicleValues[index].confirmNumImmat = vehicleForm.controls['confirmRegistrationNumber'].value;
    this.vehicleValues[index].numChassis = vehicleForm.controls['chassisNumber'].value;
    this.vehicleValues[index].marque = vehicleForm.controls['brand'].value;
    this.vehicleValues[index].modele = vehicleForm.controls['model'].value;
    this.vehicleValues[index].annee = vehicleForm.controls['year'].value;
    this.vehicleValues[index].etatVehicule = vehicleForm.controls['vehicleCondition'].value;
    this.vehicleValues[index].boite = vehicleForm.controls['boite'].value;
    this.vehicleValues[index].cylindree = vehicleForm.controls['cylindree'].value;
    this.vehicleValues[index].carburant = vehicleForm.controls['carburant'].value;
    this.vehicleValues[index].typeCarrosserie = vehicleForm.controls['brand'].value;
    this.vehicleValues[index].puissance = vehicleForm.controls['power'].value;
    this.vehicleValues[index].kilometrage = vehicleForm.controls['kilometrage'].value;
    this.vehicleValues[index].nbPortes = vehicleForm.controls['doorsNumber'].value;
    this.vehicleValues[index].couleur = vehicleForm.controls['color'].value;

    //this.vehicleValues[index].idAssurance = vehicleForm.controls['insuranceId'].value;
    //this.vehicleValues[index].idAgence = vehicleForm.controls['agencyId'].value;
    this.vehicleValues[index].numContrat = vehicleForm.controls['contractNumber'].value;
    //this.vehicleValues[index].dateDebut = vehicleForm.controls['contractStart'].value;
    //this.vehicleValues[index].dateFin = vehicleForm.controls['contractEnd'].value;
    this.vehicleValues[index].cin = vehicleForm.controls['cin'].value;
    
  }

  getGarageForm(garageForm: FormGroup, index: number) {
    console.log(index);
    console.log(garageForm);
    this.garageValues[index].name = garageForm.controls['name'].value;
    this.garageValues[index].capacite = garageForm.controls['capacity'].value;
    this.garageValues[index].garageType = garageForm.controls['garageType'].value;
    this.garageValues[index].email = garageForm.controls['email'].value;
    this.garageValues[index].phone = garageForm.controls['phone'].value['number'];
    this.garageValues[index].countryCode = garageForm.controls['phone'].value['countryCode'];
    this.garageValues[index].dialCode = garageForm.controls['phone'].value['dialCode'];
    this.garageValues[index].adresse = garageForm.controls['address'].value;
    //this.garageValues[index].garageOwner = this.currentUsername; //from token
  }

  getLavageForm(garageForm: FormGroup, index: number) {
    console.log(index);
    console.log(garageForm);
    this.lavageValues[index].name = garageForm.controls['name'].value;
    this.lavageValues[index].capacity = garageForm.controls['capacity'].value;
    this.lavageValues[index].email = garageForm.controls['email'].value;
    this.lavageValues[index].phone = garageForm.controls['phone'].value['number'];
    this.lavageValues[index].countryCode = garageForm.controls['phone'].value['countryCode'];
    this.lavageValues[index].dialCode = garageForm.controls['phone'].value['dialCode'];
    this.lavageValues[index].address = garageForm.controls['address'].value;
    //this.lavageValues[index].lavageOwner = this.currentUsername; 
    this.lavageValues[index].currentNbVehicle = 0; //by default
  }

  getOfficeForm(officeForm: FormGroup, index: number) {
    console.log(index);
    console.log(officeForm);
    this.officeValues[index].name = officeForm.controls['name'].value;
    this.officeValues[index].email = officeForm.controls['email'].value;
    this.officeValues[index].phone = officeForm.controls['phone'].value;
    this.officeValues[index].address = officeForm.controls['address'].value;
    //this.officeValues[index].officeOwner = this.currentUsername; //from token
  }

  onMatriculeFiscaleChange() {
    console.log(this.completedRegistrationForm.controls['matriculeFiscale'].value);
    this.user.matriculeFiscale = this.completedRegistrationForm.controls['matriculeFiscale'].value;
  }
}