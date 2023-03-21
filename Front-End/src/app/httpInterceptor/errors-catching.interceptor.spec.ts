import { TestBed } from '@angular/core/testing';

import { ErrorsCatchingInterceptor } from './errors-catching.interceptor';

describe('ErrorsCatchingInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      ErrorsCatchingInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: ErrorsCatchingInterceptor = TestBed.inject(ErrorsCatchingInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
