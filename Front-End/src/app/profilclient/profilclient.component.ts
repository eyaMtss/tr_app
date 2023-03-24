import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../services/api/user.service';

@Component({
  selector: 'app-profilclient',
  templateUrl: './profilclient.component.html',
  styleUrls: ['./profilclient.component.css']
})
export class ProfilclientComponent {
  profilclientForm: FormGroup ;
  userId!:number;
  user: User = new User();
  constructor(private fb: FormBuilder, private router: Router, private route: ActivatedRoute, private userService: UserService) {
  
    this.profilclientForm = this.fb.group({
    
      firstName: ["", Validators.required],
      lastName: ["", Validators.required],
      phoneNumber: ["", Validators.required],
      birthdate: ["", Validators.required],
      country: ["", Validators.required],
      email: ["", Validators.required],

    })
  }
  ngOnInit(): void {
    this.userId = this.route.snapshot.params['userId'];
    this.getProfileclient(1);
  }
  getProfileclient(userId:number){
    this.userService.getById(userId).subscribe(data => {
      this.user = data;
     // console.log(data.userId)
      console.log(data.firstName)


    });
  }
  ok()
  {
    console.log("ok")
  }
}
