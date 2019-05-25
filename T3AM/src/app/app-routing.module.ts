import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { SignupComponent } from './components/signup/signup.component';
import { SearchComponent } from './components/search/search.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AboutComponent } from './components/about/about.component';
import { FindstoresComponent } from './components/findstores/findstores.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  }, {
    path: 'home',
    component: HomeComponent
  }, {
    path: 'signup',
    component: SignupComponent 
  }, {
    path: 'search',
    component: SearchComponent
  }, {
    path: 'profile',
    component: ProfileComponent
  }, {
    path: 'about',
    component: AboutComponent
  }, {
    path: 'find',
    component: FindstoresComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
