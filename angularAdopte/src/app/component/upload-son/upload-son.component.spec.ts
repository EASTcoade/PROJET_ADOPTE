import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadSonComponent } from './upload-son.component';

describe('UploadSonComponent', () => {
  let component: UploadSonComponent;
  let fixture: ComponentFixture<UploadSonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UploadSonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UploadSonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
