import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeStyleComponent } from './liste-style.component';

describe('ListeStyleComponent', () => {
  let component: ListeStyleComponent;
  let fixture: ComponentFixture<ListeStyleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeStyleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeStyleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
