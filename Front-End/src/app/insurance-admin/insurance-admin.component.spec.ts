import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsuranceAdminComponent } from './insurance-admin.component';

describe('InsuranceAdminComponent', () => {
  let component: InsuranceAdminComponent;
  let fixture: ComponentFixture<InsuranceAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsuranceAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsuranceAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
