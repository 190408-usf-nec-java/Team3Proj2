import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  
  searched = '';
  searched2 = '';
  searchResponse: Subscription;

  constructor(private searchService: SearchService, private router: Router) { }

  search() {
    console.log('searching recipe...');
    this.searchService.search(this.searched);
  }

  searchIng() {
    console.log('searching ingredient...');
    this.searchService.searchIng(this.searched2);
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
