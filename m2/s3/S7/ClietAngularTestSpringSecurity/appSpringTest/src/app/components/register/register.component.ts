import { AuthService } from './../../services/auth.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  @ViewChild('f') form!: NgForm;
  error: undefined | string;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    if(  this.form.value.username.trim() !== ''
      && this.form.value.email.trim() !== ''
      && this.form.value.password.trim() !== '') {
        this.authService.signup(this.form.value).subscribe(
          resp => {
            console.log(resp);
            this.error = undefined;
            this.router.navigate(['/login'])
          }, err => {
            console.log(err.error.message);
            this.error = err.error.message;
          }
        );
    } else {
      this.error = 'Field Required';
    }

  }

}
