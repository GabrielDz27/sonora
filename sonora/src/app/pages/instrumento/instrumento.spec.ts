import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Instrumento } from './instrumento';

describe('Instrumento', () => {
  let component: Instrumento;
  let fixture: ComponentFixture<Instrumento>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Instrumento]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Instrumento);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
