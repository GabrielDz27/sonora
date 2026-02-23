import { Component, Input } from '@angular/core';

type ButtonVariant = 'primary' | 'outline' | 'danger' | 'success';

@Component({
  selector: 'app-button',
  imports: [],
  templateUrl: './button.component.html',
  styleUrl: './button.component.css'
})
export class ButtonComponent {
  @Input() variant: ButtonVariant = 'primary';
  @Input() type: 'button' | 'submit' | 'reset' = 'button';
  @Input() disabled = false;
  @Input() fullWidth = false;

  get classes(): string {
    const base =
      'inline-flex items-center justify-center gap-2 rounded-xl transition font-normal ' +
      'focus:outline-none focus:ring-2 focus:ring-emerald-500/40 cursor-pointer px-4 py-2.5';

    const variants: Record<ButtonVariant, string> = {
      primary:
        'bg-[var(--color-industrial-blue)] text-white hover:opacity-90 focus:ring-sky-400',
      outline:
        'border border-slate-300 bg-white text-slate-900 hover:bg-slate-50 focus:ring-slate-300',
      danger:
        'bg-red-600 text-white hover:bg-red-700 focus:ring-red-300',
      success:
        'bg-emerald-600 text-white hover:bg-emerald-700 focus:ring-emerald-300',
    };

    return `${base} ${variants[this.variant]}`;
  }

}
