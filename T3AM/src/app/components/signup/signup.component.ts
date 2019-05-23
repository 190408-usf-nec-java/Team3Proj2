import { Component, OnInit } from '@angular/core';
import { SignupService } from 'src/app/services/signup.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  passwordConfirmationFailed = false;
  fname = '';
  lname = '';
  email = '';
  username = '';
  password = '';
  password2 = '';
  signupResponse: Subscription;
  lastStatus = 200;
  signupForm;

  constructor(private signupService: SignupService, private router: Router) { }

  confirmPassword() {
    if (this.password === this.password2) {
      this.passwordConfirmationFailed = false;
    } else {
      this.passwordConfirmationFailed = true;
    }
  }

ngOnInit() {
    this.signupResponse = this.signupService.$signupStatus.subscribe(status => {
      if (status === 200) {
        //do something with the status here
        this.router.navigateByUrl('login');
      } else {
        //set status to lastStatus to display appropriate error messages
        this.lastStatus = status;
      }
    });
  }

  ngOnDestroy() {
    if (this.signupResponse) {
      this.signupResponse.unsubscribe();
    }
  }

  usernameValidation(): boolean {
    return this.username.length > 5;
  }

  passwordValidation(): boolean {
    return this.password.length > 7;
  }

  showPasswordValidation(): string {
    if (this.passwordValidation()) {
      return 'form-control is-valid';
    } else {
      return 'form-control is-invalid';
    }
  }

  showPasswordValidation2(): string {
    if (this.passwordValidation()) {
      return 'form-control is-valid';
    } else {
      return 'form-control is-invalid';
    }
  }

  showUsernameValidation(): string {
    if (this.usernameValidation()) {
      return 'form-control is-valid';
    } else {
      return 'form-control is-invalid';
    }
  }

  formValidation(): boolean {
    return this.fname.length > 0 && this.lname.length > 0 && this.email.length > 0 &&
    this.username.length > 5 && this.password.length > 7;
  }

  submit() {
      console.log('submitted');
      this.signupService.signup(this.fname, this.lname,
        this.email, this.username, this.password);
  }

}
