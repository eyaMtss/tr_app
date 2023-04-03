import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { VehicleModalComponent } from '../vehicle-modal/vehicle-modal.component';

@Component({
  selector: 'app-view-vehicle',
  templateUrl: './view-vehicle.component.html',
  styleUrls: ['./view-vehicle.component.css']
})
export class ViewVehicleComponent {
 
  vehicleForm: FormGroup;
  //contractForm: FormGroup;
  constructor(private _formBuilder: FormBuilder, private modalService: NgbModal){
    this.vehicleForm = this._formBuilder.group({
      registrationType: ["", Validators.required],
      registrationNumber: ["", Validators.required],
      confirmRegistrationNumber: ["", Validators.required],
      chassisNumber: ["", Validators.required],
      
      brand: ["", Validators.required],
      model: [{value: "", disabled: true}, Validators.required],
      year: ["", [Validators.required, Validators.max(4), Validators.min(4)]],
      vehicleCondition: ["", Validators.required],
      kilometrage: ["", Validators.required],
      boite: ["", Validators.required],
      cylindree: ["", Validators.required],
      carburant: ["", Validators.required],
      carrosserieType: ["", Validators.required],
      color: ["", Validators.required],
      doorsNumber: ["", Validators.required],
      power: ["", Validators.required],
      contractNumber: ["", Validators.required],
      startContract: ["", Validators.required],
      endContract: ["", Validators.required],
      contractFile: [""],
      chassisFile: [""]
    });
  }

  onEditVehicleButton(){

  }

  openEditVehicleModal(event: any) { //open a modal according to each key
    //let order = new Order(1, 5,52557641, 1, 1, 0, new Date(), new Date(), 100, "12254,225", "12254,225",
    //"12254,225", "12254,225", "12254,225", "12254,225");
    //let targetFieldId = event.currentTarget.id
    const modalRef = this.modalService.open(VehicleModalComponent, {
      fullscreen: false,
      scrollable: true,
      size: 'lg'
    });
    //modalRef.componentInstance.currentOrder = order;
  }
}
