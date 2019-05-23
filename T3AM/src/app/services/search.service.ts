import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private searchStatusSubject = new Subject<number>();
  public  $searchStatus = this.searchStatusSubject.asObservable();

  constructor(private httpClient: HttpClient) { }

  search(search: string): void {
    const payload = {
      search: search
    };

    console.log(payload);

    this.httpClient.get('http://localhost:8081/recipe/search/', payload, {
        observe: 'response'
      }).subscribe(response => {
        console.log('request sent');
        // sessionStorage.setItem('cache', response.body.toString());
        this.searchStatusSubject.next(200);
      }, err => {
        this.searchStatusSubject.next(err.status);
      });

  }
}
