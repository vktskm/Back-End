import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ISignupData } from '../interfaces/isignup-data';
import { ISigninData } from '../interfaces/isignin-data';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loggedIn: boolean = false;
  headers = new HttpHeaders();


  constructor(private http: HttpClient) {

  }

  getUsers() {
    // Soluzione senza Interceptor
    /* let json = localStorage.getItem('userLogin');
    if(json) {
      let userLogin = JSON.parse(json);
      this.headers = this.headers.set('Authorization', 'Bearer ' + userLogin.accessToken);
    }
    return this.http.get<ISignupData[]>('http://localhost:8080/api/test/angular', { headers: this.headers }); */
    return this.http.get<ISignupData[]>('http://localhost:8080/api/test/angular');
  }

  signup(user: ISignupData) {
    console.log(user);
    return this.http.post('http://localhost:8080/api/auth/register', user);
  }

  signin(user: ISigninData) {
    console.log(user);
    return this.http.post('http://localhost:8080/api/auth/login', user);
  }

  isAuth() {
    // return false;
    // return this.loggedIn;
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve(this.loggedIn)
      }, 1000)
    })
  }
}
