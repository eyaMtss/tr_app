import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-multi',
  templateUrl: './multi.component.html',
  styleUrls: ['./multi.component.css']
})
export class MultiComponent implements OnInit {
  constructor(private router: Router, private authService:AuthService){
    
  }
  ngOnInit(): void {
    let role = this.authService.getRoles()[0];
    if(role == "CLIENT"){
      this.router.navigate(["/share"]);
    }
    else this.router.navigate(["/order"]);
  }

}
