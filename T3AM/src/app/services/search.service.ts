import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { map } from 'rxjs/operators';
import { Recipe } from '../classes/recipe';
import { Ingredient } from '../classes/ingredient';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private searchStatusSubject = new Subject<number>();
  public  $searchStatus = this.searchStatusSubject.asObservable();
  recipeArray = new Array<Recipe>();
  ingredientArray = new Array<Ingredient>();

  constructor(private httpClient: HttpClient) { }

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



}
