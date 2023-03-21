import { Component, ElementRef, Input, SimpleChanges, ViewChild } from '@angular/core';
import { Order } from '../models/order';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-qr-code',
  templateUrl: './qr-code.component.html',
  styleUrls: ['./qr-code.component.css']
})
export class QrCodeComponent {
  myOrderQrCode= new Order();
  @ViewChild('closeModal') private closeModal!: ElementRef; //to close the modal
  @Input() currentOrder!: Order;
  constructor (public activeModal: NgbActiveModal) {
    //this.myOrderQrCode = 'ItSoluionStuff.com';
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(this.currentOrder);
    this.myOrderQrCode = this.currentOrder;
  }

  setBackgroundColor(status: string){
    if (status == 'PICKED_UP')
      return "green";
    return "red";
  }
}
