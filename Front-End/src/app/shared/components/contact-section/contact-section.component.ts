import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CountryISO, SearchCountryField } from 'ngx-intl-tel-input';
import { Phone } from 'src/app/models/useful/phone';
@Component({
  selector: 'app-contact-section',
  templateUrl: './contact-section.component.html',
  styleUrls: ['./contact-section.component.css']
})
export class ContactSectionComponent implements OnInit {
  CountryISO = CountryISO;
  SearchCountryField = SearchCountryField;
  contactForm: FormGroup;
  phoneValues: any[] = [];
  maxPhoneNumber: number = 2; // 
  currentPhoneNumber: number = 1; // 
  constructor(private _formBuilder: FormBuilder){
    this.contactForm = this._formBuilder.group({
      email: ["", [Validators.required, Validators.email]],
      phone1: ["", Validators.required],
      phone2: ["", Validators.required],
    })
  }
  ngOnInit(): void {
    this.onAddPhoneBtn()
  }

  onAddPhoneBtn() {
    if (this.phoneValues.length < this.maxPhoneNumber) {
      this.phoneValues.push(new Phone());
      this.currentPhoneNumber += 1;
      console.log(this.phoneValues);
    }
  }

  onDeletePhoneButton(i: any): void {  //delete the i input field for vehiculesValues list
    if (this.phoneValues.length == 1)   //always keep a field
      this.phoneValues[i] = new Phone()
    else {
      this.phoneValues.splice(i, 1);
      this.currentPhoneNumber -= 1;
    }
  }
}
