import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgenceLocationAdminComponent } from './agence-location-admin.component';

describe('AgenceLocationAdminComponent', () => {
  let component: AgenceLocationAdminComponent;
  let fixture: ComponentFixture<AgenceLocationAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgenceLocationAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgenceLocationAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
