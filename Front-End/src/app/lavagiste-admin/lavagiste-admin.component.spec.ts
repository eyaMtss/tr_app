import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LavagisteAdminComponent } from './lavagiste-admin.component';

describe('LavagisteAdminComponent', () => {
  let component: LavagisteAdminComponent;
  let fixture: ComponentFixture<LavagisteAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LavagisteAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LavagisteAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
