import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginStatusSubject = new Subject<number>();
  public  $loginStatus = this.loginStatusSubject.asObservable();

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
        localStorage.setItem('cache', response.body.toString());
        console.log(localStorage);
        this.loginStatusSubject.next(200);
      }, err => {
        this.loginStatusSubject.next(err.status);
      });
  }
}
