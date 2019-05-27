import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { map } from 'rxjs/operators';
import { Users } from '../classes/users';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginStatusSubject = new Subject<number>();
  public  $loginStatus = this.loginStatusSubject.asObservable();
  public user: Users;

  constructor(private httpClient: HttpClient) { }


  login(username: string, password: string): void {
    const payload = {
      username: username,
      password: password
    };

    console.log(payload);

    this.httpClient.post('http://localhost:8081/users/login/', payload, {
        observe: 'response'
      }).pipe(map(response => response.body as Users )).subscribe(response => {
        console.log(response);
        sessionStorage.setItem('token', response.toString());
        localStorage.setItem('token', JSON.stringify(response));
        this.loginStatusSubject.next(200);
    }, err => {
      this.loginStatusSubject.next(err.status);
    });
  }
      }
      // subscribe(response => {
      //   console.log('request sent');
      //   sessionStorage.setItem('token', response.body.toString());
      //   localStorage.setItem('token', JSON.stringify(response.body.toString()));
      //   this.loginStatusSubject.next(200);
      // }, err => {
      //   this.loginStatusSubject.next(err.status);
      // });
