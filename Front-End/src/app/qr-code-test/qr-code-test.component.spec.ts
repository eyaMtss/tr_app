import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QrCodeTestComponent } from './qr-code-test.component';

describe('QrCodeTestComponent', () => {
  let component: QrCodeTestComponent;
  let fixture: ComponentFixture<QrCodeTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QrCodeTestComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QrCodeTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
