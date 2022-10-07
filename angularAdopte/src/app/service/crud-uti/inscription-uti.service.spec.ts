import { TestBed } from '@angular/core/testing';

import { InscriptionUtiService } from './inscription-uti.service';

describe('InscriptionUtiService', () => {
  let service: InscriptionUtiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InscriptionUtiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
