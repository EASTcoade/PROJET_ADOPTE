import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeInstrumentComponent } from './liste-instrument.component';

describe('ListeInstrumentComponent', () => {
  let component: ListeInstrumentComponent;
  let fixture: ComponentFixture<ListeInstrumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeInstrumentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeInstrumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
