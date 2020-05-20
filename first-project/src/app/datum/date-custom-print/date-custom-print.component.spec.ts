import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DateCustomPrintComponent } from './date-custom-print.component';

describe('DateCustomPrintComponent', () => {
  let component: DateCustomPrintComponent;
  let fixture: ComponentFixture<DateCustomPrintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DateCustomPrintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DateCustomPrintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
