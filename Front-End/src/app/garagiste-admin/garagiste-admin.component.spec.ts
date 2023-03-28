import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GaragisteAdminComponent } from './garagiste-admin.component';

describe('GaragisteAdminComponent', () => {
  let component: GaragisteAdminComponent;
  let fixture: ComponentFixture<GaragisteAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GaragisteAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GaragisteAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
