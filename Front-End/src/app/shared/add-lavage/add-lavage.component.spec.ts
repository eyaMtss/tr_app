import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLavageComponent } from './add-lavage.component';

describe('AddLavageComponent', () => {
  let component: AddLavageComponent;
  let fixture: ComponentFixture<AddLavageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddLavageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddLavageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
