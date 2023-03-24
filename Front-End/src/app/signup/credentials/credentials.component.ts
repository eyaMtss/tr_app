import { Component, EventEmitter, Output } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';

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
      password: ["", [Validators.required,  Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]],
      confirmPassword: ["", [Validators.required,  Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]]
    });
    this.credentialsForm.addValidators(
      matchValidator(
        this.credentialsForm.get('password')!,
        this.credentialsForm.get('confirmPassword')!
      )
     );
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

function matchValidator(
  control: AbstractControl,
  controlTwo: AbstractControl
): ValidatorFn {
  return () => {
    if (control.value !== controlTwo.value)
      return { match_error: 'Passwords does not match' };
    return null;
  };

}
