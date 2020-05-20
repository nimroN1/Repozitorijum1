import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DateCustomPrintComponent } from './date-custom-print/date-custom-print.component';



@NgModule({
  declarations: [DateCustomPrintComponent],
  imports: [
    CommonModule
  ],
  exports: [DateCustomPrintComponent]
})
export class DatumModule { }
