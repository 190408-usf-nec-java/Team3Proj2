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

  add(name: string, directions: string, user: number, tags: number): Observable<any>{ 
    const payload = {
      name: name,
      directions:directions,
      user: user,
      tags: tags,
      };

return this.httpClient.post('http://localhost:8081/recipe/create/', payload);
}
}