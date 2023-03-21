import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PickUpPassComponent } from './pick-up-pass.component';

describe('PickUpPassComponent', () => {
  let component: PickUpPassComponent;
  let fixture: ComponentFixture<PickUpPassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PickUpPassComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PickUpPassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
