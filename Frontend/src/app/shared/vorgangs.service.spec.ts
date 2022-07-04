import { TestBed } from '@angular/core/testing';

import { VorgangsService } from './vorgangs.service';

describe('VorgangsService', () => {
  let service: VorgangsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VorgangsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
