import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { HomeComponent } from './components/home/home.component';
import { SearchComponent } from './components/search/search.component';
import { LoginService } from './services/login.service';
import { SignupService } from './services/signup.service';
import { ProfileComponent } from './components/profile/profile.component';
import { SearchApiService } from './services/search-api.service';
import { AboutComponent } from './components/about/about.component';
import { SearchService } from './services/search.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    SearchComponent,
    ProfileComponent,
    AboutComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [LoginService, SignupService, SearchApiService, SearchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
