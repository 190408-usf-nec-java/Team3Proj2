import { TestBed } from '@angular/core/testing';

import { AddrecipesService } from './addrecipes.service';

describe('AddrecipesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddrecipesService = TestBed.get(AddrecipesService);
    expect(service).toBeTruthy();
  });
});
