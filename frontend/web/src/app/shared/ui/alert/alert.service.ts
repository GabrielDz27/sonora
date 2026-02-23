import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

export type AlertVariant = 'success' | 'error' | 'info' | 'warning';

@Injectable({
  providedIn: 'root'
})
export class AlertService {
  private readonly PRIMARY_COLOR = '#082f49';

  toast(variant: AlertVariant, title: string, text?: string) {
    return Swal.fire({
      toast: true,
      position: 'top-end',
      timer: 3500,
      timerProgressBar: true,
      showConfirmButton: false,
      icon: variant,
      title,
      text,
      didOpen: (toast) => {
        const progressBar = toast.querySelector('.swal2-timer-progress-bar') as HTMLElement;
        if (progressBar) progressBar.style.backgroundColor = this.PRIMARY_COLOR;
      }
    });
  }

  modal(variant: AlertVariant, title: string, text?: string) {
    return Swal.fire({
      icon: variant,
      title,
      text,
      confirmButtonText: 'Entendido',
      confirmButtonColor: this.PRIMARY_COLOR,
      background: '#f8fafc',
      customClass: {
        title: 'text-slate-900 font-bold',
        popup: 'rounded-2xl'
      }
    });
  }

}
