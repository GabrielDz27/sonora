import { Component, inject, signal, output, Input, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { PecaDto, statusPeca } from '../../models/peca.models';
import { LucideAngularModule } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-formulario-peca',
  standalone: true,
  imports: [ReactiveFormsModule, LucideAngularModule],
  templateUrl: './formulario-peca.component.html'
})
export class FormularioPecaComponent implements OnInit {
  private fb = inject(FormBuilder);
  
  @Input() dadosIniciais?: PecaDto;
  salvarPeca = output<PecaDto>();
  cancelar = output<void>();

  pecaForm = this.fb.group({
    id: [null as string | null],
    nome: ['', [Validators.required]],
    codigoDesenho: ['', [Validators.required]],
    valor: [0, [Validators.required, Validators.min(0)]],
    tempoEstimadoMinutos: [0, [Validators.required, Validators.min(1)]],
    status: ['PENDENTE' as statusPeca, Validators.required],
    motivoPerda: ['']
  });

  ngOnInit() {
    if (this.dadosIniciais) {
      this.pecaForm.patchValue(this.dadosIniciais);
    }
  }

  enviar() {
    if (this.pecaForm.valid) {
      this.salvarPeca.emit(this.pecaForm.value as PecaDto);
    }
  }
}