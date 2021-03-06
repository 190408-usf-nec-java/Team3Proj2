import { Component, OnInit } from '@angular/core';
import { SearchService } from 'src/app/services/search.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  searched = '';
  searched2 = '';
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
