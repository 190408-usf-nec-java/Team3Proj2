import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { HomeComponent } from './components/home/home.component';
import { SearchComponent } from './components/search/search.component';
import { LoginService } from './services/login.service';
import { SignupService } from './services/signup.service';
import { ProfileComponent } from './components/profile/profile.component';
import { AboutComponent } from './components/about/about.component';
import { SearchService } from './services/search.service';
import { FindstoresComponent } from './components/findstores/findstores.component';
import { FindstoresService } from './services/findstores.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    SearchComponent,
    ProfileComponent,
    AboutComponent,
    FindstoresComponent
  ],
  imports: [
    FormsModule,
    NgbModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    LoginService,
    SignupService,
    SearchService,
    FindstoresService
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
