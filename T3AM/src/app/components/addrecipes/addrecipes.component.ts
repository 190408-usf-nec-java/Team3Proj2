import { Component, OnInit } from '@angular/core';
import { AddrecipesService } from 'src/app/services/addrecipes.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { NgbPaginationNumber } from '@ng-bootstrap/ng-bootstrap';
import { Users } from 'src/app/classes/users';
@Component({
  selector: 'app-addrecipes',
  templateUrl: './addrecipes.component.html',
  styleUrls: ['./addrecipes.component.css']
})
export class AddrecipesComponent implements OnInit {
  name = ' ' ;
 
  directions  = ' ';
  user = JSON.parse(localStorage.getItem('token')).userID;
  tags: number;
 
  submitSucceeded = undefined;
  sumbitResponse: Subscription;
  laststatus = 200;

  constructor(private addrecipeService: AddrecipesService, private router: Router) { }

  ngOnInit() {
    this.sumbitResponse = this.addrecipeService.$submitStatus.subscribe(status => {
      if (status === 200){
        alert('recipe submitted');
       }else {
        this.laststatus = status;
      }
    });
  }

  submit() {
    console.log(this.name,  this.directions);
    this.addrecipeService.add(this.name, this.directions, this.user, this.tags ).subscribe(result => {
        this.submitSucceeded = true;
        alert('Request has submitted');
      }, error => {
        this.submitSucceeded = false;
      });
  }


}
