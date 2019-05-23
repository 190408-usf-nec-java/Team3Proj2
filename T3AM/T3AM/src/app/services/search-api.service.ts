import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SearchApiService {
  apiUrl: string = 'https://pokeapi.co/api/v2/';
  apiUrl2: string = 'https://api.yummly.com/v1';

  constructor(private httpClient: HttpClient) { }
}
