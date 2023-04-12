import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DrivercamionComponent } from './drivercamion.component';

describe('DrivercamionComponent', () => {
  let component: DrivercamionComponent;
  let fixture: ComponentFixture<DrivercamionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DrivercamionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DrivercamionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
