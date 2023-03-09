import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{
  @Input() isLoggedIn!: boolean;
  constructor(private router: Router, private authService: AuthService) {
    
  }
  ngOnInit(): void {
    if (this.authService.getIsLoggedIn())
      this.isLoggedIn = true;
    this.isLoggedIn = false;
    localStorage.setItem("isLoggedIn", this.isLoggedIn.toString()); // set isLoggedIn attribute in LocalStorage

  }

  home() {
    this.router.navigate(['/']);
  }

  signin() {
    this.router.navigate(['/auth']);
  }

  signup() {
    this.authService.logout();
  }

  logout(){
    this.router.navigate(['/auth/signup']);
  }
}
