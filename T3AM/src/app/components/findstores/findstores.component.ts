import { Component, OnInit } from '@angular/core';
import { FindstoresService } from 'src/app/services/findstores.service';

@Component({
  selector: 'app-findstores',
  templateUrl: './findstores.component.html',
  styleUrls: ['./findstores.component.css']
})

export class FindstoresComponent implements OnInit {

  zipcode = '';

  constructor(private findStoresService: FindstoresService) { }

  findStores(){
    console.log('finding stores...');
    this.findStoresService.find(this.zipcode);
  }

  ngOnInit() {
  }

}
