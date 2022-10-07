import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminConnecteComponent } from './admin-connecte.component';

describe('AdminConnecteComponent', () => {
  let component: AdminConnecteComponent;
  let fixture: ComponentFixture<AdminConnecteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminConnecteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminConnecteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
