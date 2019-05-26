import { Component, OnInit } from '@angular/core';
import { SearchService } from 'src/app/services/search.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  images = [1, 2, 3].map(() => `https://picsum.photos/900/500?random&t=${Math.random()}`);
  searched = '';
  searched2 = '';
  token = sessionStorage.getItem('token');
  token_user = JSON.parse(localStorage.getItem('token')).username;

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
