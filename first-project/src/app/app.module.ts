import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Test1Component } from './test1/test1.component';
import { Test2Component } from './test2/test2.component';
import { DateComponent } from './date/date.component';
import { from } from 'rxjs';
import { DatumModule } from './datum/datum.module';
import { CustomWriteServiceService } from 'src/custom-write-service.service';
import { HttpClientModule } from '@angular/common/http';
import { ArticlesComponent } from './articles/articles.component';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AboutAdminComponent } from './about/about-admin/about-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    Test1Component,
    Test2Component,
    DateComponent,
    ArticlesComponent,
    LoginComponent,
    AboutComponent,
    PageNotFoundComponent,
    AboutAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    DatumModule, 
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
