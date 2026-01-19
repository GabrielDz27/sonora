import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export class FormValidations {
  static equalTo(field: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      if (!control.parent) return null;
      const fieldToCompare = control.parent.get(field);
      if (!fieldToCompare) return null;
      return control.value === fieldToCompare.value ? null : { equalTo: true };
    };
  }
}
