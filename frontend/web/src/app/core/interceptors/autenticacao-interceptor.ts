import { HttpInterceptorFn } from '@angular/common/http';

export const autenticacaoInterceptor: HttpInterceptorFn = (req, next) => {
  const token = localStorage.getItem('access_token');

  if (!token || req.url.includes('/platform/authentication/actions/login')) {
    return next(req);
  }

  const authReq = req.clone({
    setHeaders: {
      Authorization: `Bearer ${token}`,
    },
  });

  return next(authReq);
};
