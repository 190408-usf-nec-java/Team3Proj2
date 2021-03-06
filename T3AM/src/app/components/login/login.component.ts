import { Component, OnInit, OnDestroy } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {

  searched = '';
  searched2 = '';
  username = '';
  password = '';
  loginResponse: Subscription;
  lastStatus = 200;
  token = sessionStorage.getItem('token');

  constructor(private loginService: LoginService, private router: Router, private searchService: SearchService) { }

  clearStorage() {
    console.log('clearing session storage...');
    sessionStorage.clear();
    console.log('session storage cleard...');
  }

  tokenValid() {
    return this.token;
  }

  search() {
    console.log('searching recipe...');
    this.searchService.search(this.searched);
    this.router.navigateByUrl('search');
  }

  searchIng() {
    console.log('searching ingredient...');
    this.searchService.searchIng(this.searched2);
    this.router.navigateByUrl('searchIng');
  }

  openNav() {
    document.getElementById('mySidenav').style.width = '15%';
  }

  closeNav() {
    document.getElementById('mySidenav').style.width = '0';
  }

  ngOnInit() {
    this.loginResponse = this.loginService.$loginStatus.subscribe(status => {
      // do something with the status here
      if (status === 200) {
        this.router.navigateByUrl('home');
      } else {
        // set status to lastStatus to display appropriate error message
        this.lastStatus = status;
      }
    });
  }

  ngOnDestroy() {
    if (this.loginResponse) {
      this.loginResponse.unsubscribe();
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

  showUsernameValidation(): string {
    if (this.usernameValidation()) {
      return 'form-control is-valid';
    } else {
      return 'form-control is-invalid';
    }
  }

  formValidation(): boolean {
    return this.username.length > 5 && this.password.length > 7;
  }

  submit() {
    console.log('submitted');
    console.log('username = ' + this.username + ' | password = ' + this.password);
    this.loginService.login(this.username, this.password);
  }
}

