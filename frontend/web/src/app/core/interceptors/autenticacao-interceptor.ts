import { HttpErrorResponse, HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

export const autenticacaoInterceptor: HttpInterceptorFn = (req, next) => {
  const token = localStorage.getItem('access_token');

  const router = inject(Router);

  if (!token || req.url.includes('/platform/authentication/actions/login')) {
    return next(req);
  }

  const authReq = req.clone({
    setHeaders: {
      Authorization: `Bearer ${token}`,
    },
  });

  return next(authReq).pipe(
    catchError((error: HttpErrorResponse) => {
      if (error.status === 401 || error.status === 403) {
        console.warn('Sessão expirada ou acesso negado. Limpando token...');
        
        localStorage.clear();
        router.navigate(['/login']); 
      }
      
      return throwError(() => error);
    })
  );
};
