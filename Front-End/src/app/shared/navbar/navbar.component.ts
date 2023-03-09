import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(private router: Router){

  }

  home(){
    this.router.navigate(['/']);
  }

  signin(){
    this.router.navigate(['/auth']);
  }

  signup(){
    this.router.navigate(['/auth/signup']);
  }
}
