import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  private signupStatusSubject = new Subject<number>();
  public $signupStatus = this.signupStatusSubject.asObservable();

  constructor(private httpClient: HttpClient) { }

  signup(firstname: string, lastname: string, email: string, username: string,
    password: string ): void {
      const payload = {
        firstname: firstname,
        lastname: lastname,
        email: email,
        username: username,
        password: password
      };

      console.log(payload);

      this.httpClient.post('', payload, {
        observe: 'response'
      }).subscribe(response => {
        console.log('request sent');
        this.signupStatusSubject.next(200);
      }, err => {
        this.signupStatusSubject.next(err.status);
      });

    }


}
