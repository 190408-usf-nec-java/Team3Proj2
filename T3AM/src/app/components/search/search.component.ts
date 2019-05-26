import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { SearchService } from 'src/app/services/search.service';
import { Recipe } from 'src/app/classes/recipe';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  
  searched = '';
  searched2 = '';
  searchResponse: Subscription;
  require: any;
  token = sessionStorage.getItem('token');
  recipeArray = new Array<Recipe>();

  constructor(private searchService: SearchService, private router: Router, private httpClient: HttpClient) { }
  clearStorage() {
    console.log('clearing session storage...');
    sessionStorage.clear();
    console.log('session storage cleard...');
  }  
  
  tokenValid() {
    return this.token;
  }
  
  search(search: string): void {
    const payload = {
      recipe: search
    };

    console.log(payload);

    this.httpClient.post('http://localhost:8081/recipe/search/', payload, {
        observe: 'response'
      }).pipe(map(response => response.body as Array <Recipe>))
      .subscribe(response => {
        response.forEach(element => {
          this.recipeArray.push(element);
        });
        }, err => {

        });

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
    this.search('Scrambled Eggs');
  }

}
