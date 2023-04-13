import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-lavagiste-admin',
  templateUrl: './lavagiste-admin.component.html',
  styleUrls: ['./lavagiste-admin.component.css']
})
export class LavagisteAdminComponent implements OnInit{
  constructor(private authService: AuthService){}
  ngOnInit(): void {
    const userDetails = this.authService.getUserDetails();
    console.log(userDetails)
  }

}
