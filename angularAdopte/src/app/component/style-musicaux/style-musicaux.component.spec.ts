import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StyleMusicauxComponent } from './style-musicaux.component';

describe('StyleMusicauxComponent', () => {
  let component: StyleMusicauxComponent;
  let fixture: ComponentFixture<StyleMusicauxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StyleMusicauxComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StyleMusicauxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
