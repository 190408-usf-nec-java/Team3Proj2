import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FindstoresService {

  constructor(private httpClient: HttpClient) { }

  find(zipcode: string): void {
    const payload = {
      zipcode: zipcode
    };

    console.log(payload);

    this.httpClient.get('api.walmartlabs.com/v1/stores?apiKey={apiKey}&zip=77063&format=json');


  }
}
