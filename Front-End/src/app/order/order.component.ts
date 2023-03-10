import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  test=true;
  name="foulen"
  surname="falten"
  minutes=23;
  constructor() { }

  ngOnInit(): void {
  }

}
