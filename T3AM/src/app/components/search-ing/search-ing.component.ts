import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { SearchService } from 'src/app/services/search.service';

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

  constructor(private searchService: SearchService, private router: Router) { }
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
  }

}
