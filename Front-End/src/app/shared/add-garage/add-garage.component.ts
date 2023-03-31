import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-garage',
  templateUrl: './add-garage.component.html',
  styleUrls: ['./add-garage.component.css']
})
export class AddGarageComponent {
  garageForm: FormGroup;
  // garage 
  garageType: string = "";
  garageTypeValue!: string; // ngModel
  @Output() garageFormEvent = new EventEmitter<FormGroup>();
  constructor(private _formBuilder: FormBuilder){
    this.garageForm = this._formBuilder.group({
      name: ["", Validators.required],
      capacity: ["", Validators.required],
      garageOwner: ["", Validators.required],
      email: ["", [Validators.required, Validators.email]],
      phone: ["", Validators.required],
      address: ["", Validators.required],
      garageType: ["", Validators.required]
    });
  }

  onGarageTypeChange(){
    let garageTypeValue = this.garageForm.controls['garageType'].value;
    console.log(garageTypeValue)
    console.log(garageTypeValue.includes("wrench"))
    if(garageTypeValue.includes("wrench")){
      this.garageType = "mecanique";
    }
    else if(garageTypeValue.includes("plug")){
      this.garageType = "electrique";
    }
    else if(garageTypeValue.includes("tire")){
      this.garageType = "pneumatique";
    }
    console.log(this.garageType);
  }

  onFormChange(){
    if(this.garageForm.valid){
        this.emitInformationForm(this.garageForm);
      } 
  }

  emitInformationForm(value: FormGroup) {
    this.garageFormEvent.emit(value);
  }
}
