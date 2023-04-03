import { TestBed } from '@angular/core/testing';

import { AgenceLocationService } from './agence-location.service';

describe('AgenceLocationService', () => {
  let service: AgenceLocationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AgenceLocationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
