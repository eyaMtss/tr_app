import { Component, ElementRef, ViewChild } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-vehicle-modal',
  templateUrl: './vehicle-modal.component.html',
  styleUrls: ['./vehicle-modal.component.css']
})
export class VehicleModalComponent {
  @ViewChild('closeModal') private closeModal!: ElementRef; //to close the modal
  constructor(public activeModal: NgbActiveModal){
    
  }
}
