import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChoixInstrumentComponent } from './choix-instrument.component';

describe('ChoixInstrumentComponent', () => {
  let component: ChoixInstrumentComponent;
  let fixture: ComponentFixture<ChoixInstrumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChoixInstrumentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChoixInstrumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
