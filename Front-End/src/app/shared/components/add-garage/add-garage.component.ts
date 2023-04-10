import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-add-garage',
  templateUrl: './add-garage.component.html',
  styleUrls: ['./add-garage.component.css']
})
export class AddGarageComponent implements OnInit {
  garageForm: FormGroup;
  // garage 
  garageType: string = "";
  garageTypeValue!: string; // ngModel
  @Output() garageFormEvent = new EventEmitter<FormGroup>();
  private subscription!: Subscription;
  constructor(private _formBuilder: FormBuilder) {
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

  ngOnInit(): void {
  }

  onGarageTypeChange() {
    let garageTypeValue = this.garageForm.controls['garageType'].value;
    console.log(garageTypeValue)
    console.log(garageTypeValue.includes("wrench"))
    if (garageTypeValue.includes("wrench")) {
      this.garageType = "mecanique";
    }
    else if (garageTypeValue.includes("plug")) {
      this.garageType = "electrique";
    }
    else if (garageTypeValue.includes("tire")) {
      this.garageType = "pneumatique";
    }
    console.log(this.garageType);
  }

  onFormChange() {
    if (this.garageForm.valid) {
      this.emitInformationForm(this.garageForm);
    }
  }

  getAddressMap(address: string){
    this.garageForm.controls['address'].setValue(address);
    console.log(address);
  }

  getPhone(phone: any){
    this.garageForm.controls['phone'].setValue(phone);
    console.log(phone);
  }

  emitInformationForm(value: FormGroup) {
    this.garageFormEvent.emit(value);
  }
  
  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}