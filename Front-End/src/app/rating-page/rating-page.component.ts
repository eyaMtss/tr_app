import { Component, OnInit } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-rating-page',
  templateUrl: './rating-page.component.html',
  styleUrls: ['./rating-page.component.css']
})
export class RatingPageComponent implements OnInit {
  starRating = 0;
  orderTime="22 Nov 22-12:33"
  startTime="22 Nov 22-12:46"
  endTime="22 Nov 22-12:27"
  duration="41:00"
  distance="23.4"
  feedback!:string;

  constructor() { }

  ngOnInit(): void {

  }

submit()
{
  console.log(this.starRating);
  console.log(this.feedback)
}

}
