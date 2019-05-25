import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindstoresComponent } from './findstores.component';

describe('FindstoresComponent', () => {
  let component: FindstoresComponent;
  let fixture: ComponentFixture<FindstoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindstoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindstoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
