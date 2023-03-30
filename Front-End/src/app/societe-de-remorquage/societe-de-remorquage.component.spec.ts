import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SocieteDeRemorquageComponent } from './societe-de-remorquage.component';

describe('SocieteDeRemorquageComponent', () => {
  let component: SocieteDeRemorquageComponent;
  let fixture: ComponentFixture<SocieteDeRemorquageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SocieteDeRemorquageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SocieteDeRemorquageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
