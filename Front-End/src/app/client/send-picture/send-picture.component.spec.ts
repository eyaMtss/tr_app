import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendPictureComponent } from './send-picture.component';

describe('SendPictureComponent', () => {
  let component: SendPictureComponent;
  let fixture: ComponentFixture<SendPictureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendPictureComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SendPictureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
