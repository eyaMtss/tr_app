import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-send-picture',
  templateUrl: './send-picture.component.html',
  styleUrls: ['./send-picture.component.css']
})
export class SendPictureComponent implements OnInit {
  test=false;
  constructor() { }

  ngOnInit(): void {
  }
  confirm()
  {
    this.test=true;

  }

}
