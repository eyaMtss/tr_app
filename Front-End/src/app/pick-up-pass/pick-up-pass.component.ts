import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pick-up-pass',
  templateUrl: './pick-up-pass.component.html',
  styleUrls: ['./pick-up-pass.component.css']
})
export class PickUpPassComponent implements OnInit {
  test=!false;
  disabled = true;
  date:String=new Date().toString().slice(0,25);
  adress="187 TUNIS 9110"
  time="23:13"
  distance="13,2 "
  constructor() { }

  ngOnInit(): void {
  }

}
