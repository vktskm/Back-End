import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Cliente } from '../interfaces/cliente';
import { Fattura } from '../interfaces/fattura';

@Injectable({
  providedIn: 'root',
})
export class ClienteServiceService {

  constructor(private http: HttpClient) {}

  headers = new HttpHeaders();

  getToken(): string {
    const user = localStorage.getItem('user');
    if (user) {
      const userData = JSON.parse(user);
      return userData.accessToken;
    } else {
      return '';
    }
  }

  getAll() {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.getToken()
    );
    return this.http.get<Cliente[]>('http://localhost:8080/api/clienti/set', {
      headers: this.headers
    });
  }

  getById(id:number) {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.getToken()
    );
    return this.http.get<Cliente>('http://localhost:8080/api/clienti/'+ id, {
      headers: this.headers
    });
  }

}
