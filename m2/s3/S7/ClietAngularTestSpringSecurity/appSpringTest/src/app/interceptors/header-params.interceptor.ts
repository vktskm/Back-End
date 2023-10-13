import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class HeaderParamsInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    console.log(request);
    let json = localStorage.getItem('userLogin');
    if(json && request.url !== 'http://localhost:8080/api/auth/login' && request.url !== 'http://localhost:8080/api/auth/register') {
      let userLogin = JSON.parse(json);
      let myRequest = request.clone(
        {
          headers: request.headers.set('Authorization', 'Bearer ' + userLogin.accessToken)
        });
      return next.handle(myRequest);
    } else {
      return next.handle(request);
    }

  }
}
