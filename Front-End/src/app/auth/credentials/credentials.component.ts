import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-credentials',
  templateUrl: './credentials.component.html',
  styleUrls: ['./credentials.component.css']
})
export class CredentialsComponent {
  credentialsForm: FormGroup;
  fieldTextTypeForPassword: boolean = false; // show or hide password
  fieldTextTypeForConfirmPassword: boolean = false; // show or hide confirmPassword
  @Output() credentialsFormEvent = new EventEmitter<FormGroup>();
  constructor(private _formBuilder: FormBuilder){
    this.credentialsForm = this._formBuilder.group({
      password: ["", Validators.required],
      confirmPassword: ["", Validators.required]
    });
  }

  onFormChange(){
    this.credentialsForm.valueChanges.subscribe(val => {
      if(this.credentialsForm.valid &&
        this.credentialsForm.controls['password'].value == this.credentialsForm.controls['confirmPassword'].value){
        this.emitCredentialsForm(this.credentialsForm);
      }
    });  
  }

  emitCredentialsForm(value: FormGroup) {
    this.credentialsFormEvent.emit(value);
  }

  toggleFieldTextTypeForPassword() {
    this.fieldTextTypeForPassword = !this.fieldTextTypeForPassword;
  }

  toggleFieldTextTypeForConfirmPassword(){
    this.fieldTextTypeForConfirmPassword = !this.fieldTextTypeForConfirmPassword;
  }
}
