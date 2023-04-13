import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-add-office',
  templateUrl: './add-office.component.html',
  styleUrls: ['./add-office.component.css']
})
export class AddOfficeComponent implements OnInit {
  officeForm: FormGroup;
  @Output() officeFormEvent = new EventEmitter<FormGroup>();
  private subscription!: Subscription;
  constructor(private _formBuilder: FormBuilder) {
    this.officeForm = this._formBuilder.group({
      name: ["", Validators.required],
      officeOwner: ["", Validators.required],
      email: ["", [Validators.required, Validators.email]],
      phone: ["", Validators.required],
      address: ["", Validators.required],
    });

  }

  ngOnInit(): void {
  }

  onFormChange() {
    if (this.officeForm.valid) {
      this.emitInformationForm(this.officeForm);
    }
  }

  getAddressMap(address: string){
    this.officeForm.controls['address'].setValue(address);
    console.log(address);
  }

  getPhone(phone: any){
    this.officeForm.controls['phone'].setValue(phone);
    console.log(phone);
  }

  emitInformationForm(value: FormGroup) {
    this.officeFormEvent.emit(value);
  }
  
  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}

