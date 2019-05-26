import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchIngComponent } from './search-ing.component';

describe('SearchIngComponent', () => {
  let component: SearchIngComponent;
  let fixture: ComponentFixture<SearchIngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchIngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchIngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
