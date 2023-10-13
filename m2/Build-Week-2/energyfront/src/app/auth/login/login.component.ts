import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  @ViewChild('f') form!: NgForm;
  error: undefined | string;

  constructor(private svc: AuthService, private router: Router) {}

  ngOnInit(): void {}

  onSubmit() {
    if (
      this.form.value.username.trim() !== '' &&
      this.form.value.password.trim() !== ''
    ) {
      this.svc.signin(this.form.value).subscribe(
        (resp) => {
          console.log(resp);
          this.error = undefined;
          this.svc.loggedIn = true;
          localStorage.setItem('user', JSON.stringify(resp));
          this.router.navigate(['/home']);
        },
        (err) => {
          console.log(err.error.message);
          this.error = err.error.message;
        }
      );
      this.error = undefined;
    } else {
      this.error = 'Field Required';
    }
  }
}
