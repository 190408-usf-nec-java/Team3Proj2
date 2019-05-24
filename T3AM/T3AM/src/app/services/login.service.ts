import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginStatusSubject = new Subject<number>();
  public  $loginStatus = this.loginStatusSubject.asObservable();
  
  private loggedInStatus = JSON.parse(localStorage.getItem('loggedIn') || 'false')

  constructor(private httpClient: HttpClient) { }


  login(username: string, password: string): void {
    const payload = {
      username: username,
      password: password
    };

    console.log(payload);

    this.httpClient.post('http://localhost:8081/users/login/', payload, {
        observe: 'response'
      }).subscribe(response => {
        console.log('request sent');
        sessionStorage.setItem('token', response.body.toString());
        this.loginStatusSubject.next(200);
      }, err => {
        this.loginStatusSubject.next(err.status);
      });
  }
}
