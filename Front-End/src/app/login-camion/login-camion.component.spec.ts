import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginCamionComponent } from './login-camion.component';

describe('LoginCamionComponent', () => {
  let component: LoginCamionComponent;
  let fixture: ComponentFixture<LoginCamionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginCamionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginCamionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
