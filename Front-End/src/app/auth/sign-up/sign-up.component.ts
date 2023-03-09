import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  username!: string;
  email!: string;
  firstName!: string;
  lastName!: string;
  password!: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  onRegister(): void {
    console.log("register")
    /*const user = new User(this.username, this.email, this.firstName, this.lastName, this.password);
    this.userService.create(user).subscribe(
      data => {
        console.log(data);
        this.volver();
      },
      err => console.log(err)
    );*/
  }

  volver(): void {
    this.router.navigate(['/order']);
  }
}
