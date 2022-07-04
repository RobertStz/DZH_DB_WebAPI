import { TestBed } from '@angular/core/testing';

import { BehoerdenService } from './behoerden.service';

describe('BehoerdenService', () => {
  let service: BehoerdenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BehoerdenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
