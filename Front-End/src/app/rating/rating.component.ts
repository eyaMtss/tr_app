import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../models/order';
import { OrderService } from '../services/api/order.service';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {
  ratingForm: FormGroup;
  id!:number;
  order: Order = new Order();
  starRating = 0;
  duree!:number;
  distance!:any;
  constructor(private fb: FormBuilder, private router: Router, private route: ActivatedRoute, private orderService: OrderService) {
  
    this.ratingForm = this.fb.group({
    
      orderTimeRequest: ["", Validators.required],
      orderTimeAccept: ["", Validators.required],
     

    })
  }
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getRating(1);
  }

  getRating(id:number){
    this.orderService.getById(id).subscribe(data => {
      this.order = data;
      console.log(data.id)
      console.log(data.order_time_accept)

      console.log(data.order_time_request)
      this.order.order_time_request = new Date(data.order_time_request);
      this.order.order_time_accept = new Date(data.order_time_accept);
      this.duree = (this.order.order_time_accept.valueOf() - this.order.order_time_request.valueOf()) / (1000 * 3600 * 24);
      console.log(this.duree)
      this.distance="100km";
      console.log(data.order_time_request.valueOf())
    });
  }
  submit(){
    console.log(this.starRating)
  }
}
