import { TestBed } from '@angular/core/testing';

import { ZustaendigkeitsService } from './zustaendigkeits.service';

describe('ZustaendigkeitsService', () => {
  let service: ZustaendigkeitsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZustaendigkeitsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
