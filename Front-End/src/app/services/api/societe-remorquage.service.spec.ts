import { TestBed } from '@angular/core/testing';

import { SocieteRemorquageService } from './societe-remorquage.service';

describe('SocieteRemorquageService', () => {
  let service: SocieteRemorquageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SocieteRemorquageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
