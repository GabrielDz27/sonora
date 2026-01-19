import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormBase } from './form-base';

describe('FormBase', () => {
  let component: FormBase;
  let fixture: ComponentFixture<FormBase>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormBase]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormBase);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
