import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-add-lavage',
  templateUrl: './add-lavage.component.html',
  styleUrls: ['./add-lavage.component.css']
})
export class AddLavageComponent {
  lavageForm: FormGroup;
  // lavage 
  lavageType: string = "";
  lavageTypeValue!: string; // ngModel
  @Output() lavageFormEvent = new EventEmitter<FormGroup>();
  private subscription!: Subscription;
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

  getAddressMap(address: string){
    this.lavageForm.controls['address'].setValue(address);
    console.log(address);
  }

  emitInformationForm(value: FormGroup) {
    this.lavageFormEvent.emit(value);
  }

  getPhone(phone: any){
    this.lavageForm.controls['phone'].setValue(phone);
    console.log(phone);
  }
  
  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
