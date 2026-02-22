import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioRegistroProducaoComponent } from './formulario-registro-producao.component';

describe('FormularioRegistroProducaoComponent', () => {
  let component: FormularioRegistroProducaoComponent;
  let fixture: ComponentFixture<FormularioRegistroProducaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormularioRegistroProducaoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormularioRegistroProducaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
