import { TestBed } from '@angular/core/testing';

import { RegistroProducaoService } from './registro-producao.service';

describe('RegistroProducaoService', () => {
  let service: RegistroProducaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistroProducaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
