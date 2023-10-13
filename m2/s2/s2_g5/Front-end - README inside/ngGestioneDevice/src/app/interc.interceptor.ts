import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable, switchMap, take } from 'rxjs';
import { AuthService } from './services/auth.service';

@Injectable()
export class IntercInterceptor implements HttpInterceptor {
  constructor(private svc: AuthService) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    return this.svc.user$.pipe(
      take(1),
      switchMap((val) => {
        return val
          ? next.handle(
              request.clone({
                headers: request.headers.append(
                  'Authorization',
                  'Bearer ' + val.accessToken
                ),
              })
            )
          : next.handle(request);
      })
    );

    //alt
    // const req = request.clone({
    //   setHeaders: {
    //     Authorization:
    //       'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsaXpAbGl6Lml0IiwiaWF0IjoxNjkxMzIzOTA1LCJleHAiOjE2OTE0MTAzMDV9.5OmiERrZb_kn68DZLvdQdIhDevYMgQA1O_IhplsOH4ZWa0k5z_r0b4U6r-wzNPGq9HmtYILqg_oWS5GUjz0pIA',
    //   },
    // });
    // console.log(req);
    // return next.handle(req);
  }
}
