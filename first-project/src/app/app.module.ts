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

@NgModule({
  declarations: [
    AppComponent,
    Test1Component,
    Test2Component,
    DateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    DatumModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
