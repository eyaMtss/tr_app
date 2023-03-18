import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Order } from '../models/order';
import { QrCodeComponent } from '../qr-code/qr-code.component';

@Component({
  selector: 'app-qr-code-test',
  templateUrl: './qr-code-test.component.html',
  styleUrls: ['./qr-code-test.component.css']
})
export class QrCodeTestComponent implements OnInit {
  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  openQrCodeModal(event: any) { //open a modal according to each key
    let order = new Order(1, 5,52557641, 1, 1, 0, new Date(), new Date(), 100, "12254,225", "12254,225",
    "12254,225", "12254,225", "12254,225", "12254,225");
    let targetFieldId = event.currentTarget.id
    const modalRef = this.modalService.open(QrCodeComponent, {
      fullscreen: false,
      scrollable: true,
      size: 'md'
    });
    modalRef.componentInstance.currentOrder = order;
  }}
