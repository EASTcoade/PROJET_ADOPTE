import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContenuAdminComponent } from './contenu-admin.component';

describe('ContenuAdminComponent', () => {
  let component: ContenuAdminComponent;
  let fixture: ComponentFixture<ContenuAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContenuAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContenuAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
