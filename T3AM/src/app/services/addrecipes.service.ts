import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddrecipesService {
  private submitStatusSubject = new Subject<number>();
  public $submitStatus = this.submitStatusSubject.asObservable();

  constructor(private httpClient: HttpClient) { }

  add(name: string, directions: string, user: number, tags: number, utensils: number, ingredients: string, 
     amounts: string, units: string): Observable<any> {
    const payload = {
      name: name,
      directions,
      user: user,
      tags: tags,
      utensils: utensils,
      ingredients: ingredients,
      amounts: amounts,
      units: units
      

    };

    return this.httpClient.post('http://localhost:8081/recipe/create/', payload);
}
}