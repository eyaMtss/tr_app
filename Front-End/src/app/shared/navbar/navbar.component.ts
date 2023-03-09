import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{
  @Input() isLoggedIn!: boolean; // 
  username: string = "";
  constructor(private router: Router, private authService: AuthService) {
    
  }
  ngOnInit(): void {
    if (this.authService.getIsLoggedIn()){
      this.isLoggedIn = true;
      this.username = this.authService.getUsername();
    }
      
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
    this.router.navigate(['/auth/signup']);
  }

  logout(){
    this.authService.logout();
    
  }

  profile(){
    
  }

  orders(){
    
  }

  settings(){
    
  }
}
