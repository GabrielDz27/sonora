import { Component, inject, signal, output, Input } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { PecaDto, statusPeca } from '../../models/peca.models';
import { LucideAngularModule, Package, FileText, Timer, DollarSign, Layers, ChevronDown, AlertTriangle, X, CheckCircle } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-formulario-peca',
  standalone: true,
  imports: [ReactiveFormsModule, LucideAngularModule],
  templateUrl: './formulario-peca.component.html'
})
export class FormularioPecaComponent {
  private fb = inject(FormBuilder);
  
  readonly Package = Package;
  readonly FileText = FileText;
  readonly Timer = Timer;
  readonly DollarSign = DollarSign;
  readonly Layers = Layers;
  readonly ChevronDown = ChevronDown;
  readonly AlertTriangle = AlertTriangle;
  readonly Xicon = X;
  readonly CheckCircle = CheckCircle;

  private _dadosIniciais?: PecaDto;
  @Input() set dadosIniciais(value: PecaDto | undefined) {
    this._dadosIniciais = value;
    if (value) {
      this.pecaForm.patchValue(value);
    } else {
      this.pecaForm.reset();
    }
  }
  salvar = output<PecaDto>();
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

  enviar() {
    if (this.pecaForm.valid) {
      console.log('Formulário válido, emitindo dados:', this.pecaForm.value);
      this.salvar.emit(this.pecaForm.value as PecaDto);
    }
  }
}