import { TestBed } from '@angular/core/testing';

import { CustomWriteServiceService } from './custom-write-service.service';

describe('CustomWriteServiceService', () => {
  let service: CustomWriteServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomWriteServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
