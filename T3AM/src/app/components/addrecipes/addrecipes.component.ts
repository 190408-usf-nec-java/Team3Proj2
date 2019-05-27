import { Component, OnInit } from '@angular/core';
import { AddrecipesService } from 'src/app/services/addrecipes.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { NgbPaginationNumber } from '@ng-bootstrap/ng-bootstrap';
import { Users } from 'src/app/classes/users';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-addrecipes',
  templateUrl: './addrecipes.component.html',
  styleUrls: ['./addrecipes.component.css']
})
export class AddrecipesComponent implements OnInit {
  name = ' ' ;
  searched = '';
  searched2 = '';
  directions  = ' ';
  user = JSON.parse(localStorage.getItem('token')).userID;
  token = sessionStorage.getItem('token');
  tags: number;
 
  submitSucceeded = undefined;
  sumbitResponse: Subscription;
  laststatus = 200;

  constructor(private addrecipeService: AddrecipesService, private router: Router, private searchService: SearchService) { }
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
    this.sumbitResponse = this.addrecipeService.$submitStatus.subscribe(status => {
      if (status === 200){
        alert('recipe submitted');
       }else {
        this.laststatus = status;
      }
    });
  }

  submit() {
    console.log(this.name,  this.directions);
    this.addrecipeService.add(this.name, this.directions, this.user, this.tags ).subscribe(result => {
        this.submitSucceeded = true;
        alert('Request has submitted');
      }, error => {
        this.submitSucceeded = false;
      });
  }


}
