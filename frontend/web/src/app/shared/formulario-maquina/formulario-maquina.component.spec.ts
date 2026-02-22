import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioMaquinaComponent } from './formulario-maquina.component';

describe('FormularioMaquinaComponent', () => {
  let component: FormularioMaquinaComponent;
  let fixture: ComponentFixture<FormularioMaquinaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormularioMaquinaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormularioMaquinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
