import { TestBed } from '@angular/core/testing';

import { BehoerdenbeteiligungService } from './behoerdenbeteiligung.service';

describe('BehoerdenbeteiligungService', () => {
  let service: BehoerdenbeteiligungService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BehoerdenbeteiligungService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
