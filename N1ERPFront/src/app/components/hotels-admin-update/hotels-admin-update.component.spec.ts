import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelsAdminUpdateComponent } from './hotels-admin-update.component';

describe('HotelsAdminUpdateComponent', () => {
  let component: HotelsAdminUpdateComponent;
  let fixture: ComponentFixture<HotelsAdminUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HotelsAdminUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelsAdminUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
