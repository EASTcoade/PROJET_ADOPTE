import { TestBed } from '@angular/core/testing';

import { StyleMusicalService } from './style-musical.service';

describe('StyleMusicalService', () => {
  let service: StyleMusicalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StyleMusicalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
