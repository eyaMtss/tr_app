import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CountryISO, SearchCountryField } from 'ngx-intl-tel-input';

@Component({
  selector: 'app-add-lavage',
  templateUrl: './add-lavage.component.html',
  styleUrls: ['./add-lavage.component.css']
})
export class AddLavageComponent {
  CountryISO = CountryISO;
  SearchCountryField = SearchCountryField;

  lavageForm: FormGroup;
  // lavage 
  lavageType: string = "";
  lavageTypeValue!: string; // ngModel
  @Output() lavageFormEvent = new EventEmitter<FormGroup>();
  constructor(private _formBuilder: FormBuilder){
    this.lavageForm = this._formBuilder.group({
      name: ["", Validators.required],
      capacity: ["", Validators.required],
      lavageOwner: ["", Validators.required],
      email: ["", [Validators.required, Validators.email]],
      phone: ["", Validators.required],
      address: ["", Validators.required]
    });
  }

  onFormChange(){
    if(this.lavageForm.valid){
        this.emitInformationForm(this.lavageForm);
      } 
  }

  emitInformationForm(value: FormGroup) {
    this.lavageFormEvent.emit(value);
  }
}
