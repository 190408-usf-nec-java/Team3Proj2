import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { SearchService } from 'src/app/services/search.service';
import { Ingredient } from 'src/app/classes/ingredient';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-search-ing',
  templateUrl: './search-ing.component.html',
  styleUrls: ['./search-ing.component.css']
})
export class SearchIngComponent implements OnInit {

  searched = '';
  searched2 = '';
  searchResponse: Subscription;
  require: any;
  token = sessionStorage.getItem('token');
  ingredientArray = new Array<Ingredient>();

  constructor(private searchService: SearchService, private router: Router, private httpClient: HttpClient) { }
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

  searchIng(search: string): void {
    const payload = {
      item: search
    };

    console.log(payload);

    this.httpClient.post('http://localhost:8081/ingredient/search/', payload, {
        observe: 'response'
      }).pipe(map(response => response.body as Array <Ingredient>))
      .subscribe(response => {
        response.forEach(element => {
          console.log('ingredient found...');
          this.ingredientArray.push(element);
        });
        console.log(this.ingredientArray);
        }, err => {

        });
  }

  openNav() {
    document.getElementById('mySidenav').style.width = '15%';
  }

  closeNav() {
    document.getElementById('mySidenav').style.width = '0';
  }

  ngOnInit() {
    this.searchIng('butter');
  }

}
