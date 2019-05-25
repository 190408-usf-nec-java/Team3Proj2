import { TestBed } from '@angular/core/testing';

import { FindstoresService } from './findstores.service';

describe('FindstoresService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FindstoresService = TestBed.get(FindstoresService);
    expect(service).toBeTruthy();
  });
});
