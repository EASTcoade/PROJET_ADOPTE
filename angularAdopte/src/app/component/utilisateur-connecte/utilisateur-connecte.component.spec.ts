import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtilisateurConnecteComponent } from './utilisateur-connecte.component';

describe('UtilisateurConnecteComponent', () => {
  let component: UtilisateurConnecteComponent;
  let fixture: ComponentFixture<UtilisateurConnecteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UtilisateurConnecteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UtilisateurConnecteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
