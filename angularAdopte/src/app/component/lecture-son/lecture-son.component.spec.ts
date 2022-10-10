import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LectureSonComponent } from './lecture-son.component';

describe('LectureSonComponent', () => {
  let component: LectureSonComponent;
  let fixture: ComponentFixture<LectureSonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LectureSonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LectureSonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
