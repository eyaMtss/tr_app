import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuiviOrdreComponent } from './suivi-ordre.component';

describe('SuiviOrdreComponent', () => {
  let component: SuiviOrdreComponent;
  let fixture: ComponentFixture<SuiviOrdreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuiviOrdreComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SuiviOrdreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
