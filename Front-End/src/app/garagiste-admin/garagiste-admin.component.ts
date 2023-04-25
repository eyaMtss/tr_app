import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/api/user.service';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-garagiste-admin',
  templateUrl: './garagiste-admin.component.html',
  styleUrls: ['./garagiste-admin.component.css']
})
export class GaragisteAdminComponent implements OnInit {
  currentUsername!: string;
  constructor(private userService: UserService, private authService: AuthService){

  }
  ngOnInit(): void {
    this.currentUsername = this.authService.getUsername();
    /*this.userService.updateCompletedRegistration(this.currentUsername).subscribe(data => {
      console.log(data);
    });*/
  }
}
