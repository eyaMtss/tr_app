import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-profile-client',
  templateUrl: './profile-client.component.html',
  styleUrls: ['./profile-client.component.css']
})
export class ProfileClientComponent {
  isProfileViewMode: boolean = true;
  addressForm!: FormGroup; // address form
  profileForm: FormGroup;
  constructor(private _formBuilder: FormBuilder){
    this.profileForm = this._formBuilder.group({
      firstname: ["Eya", Validators.required],
      lastname: ["Mattoussi", Validators.required],
      email: ["eya@gmail.com", [Validators.required, Validators.email]],
      phone: ["52557641", [Validators.required, Validators.minLength(8)]],
      birthdate: ["1998-09-02", Validators.required],
      country: ["Tunisie", Validators.required],
      governorate: ["Tunis", Validators.required],
      city: ["Cité khadhra", Validators.required],
      zipCode: ["1003", Validators.required],
      homeCode: ["255", Validators.required],
    })
  }

  onProfileEditButton(){
    this.isProfileViewMode = false;
  }

  onProfileConfirmButton(){
    this.isProfileViewMode = true;
  }

  onProfileCancelButton(){
    this.isProfileViewMode = true;
  }

  getAddressForm(addressForm: FormGroup) {
    console.log(addressForm);
    this.addressForm = addressForm;
    if (this.addressForm.valid) {
      this.profileForm.controls['country'].setValue(this.addressForm.controls['country'].value);
      this.profileForm.controls['governorate'].setValue(this.addressForm.controls['governorate'].value);
      this.profileForm.controls['city'].setValue(this.addressForm.controls['city'].value);
      this.profileForm.controls['zipCode'].setValue(this.addressForm.controls['zipCode'].value);
      this.profileForm.controls['homeCode'].setValue(this.addressForm.controls['homeCode'].value);
    }
  }
}
