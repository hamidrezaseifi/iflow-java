
import { AbstractControl } from '@angular/forms';
import { InvoiceType } from '../wf-models';

export function InvoiceTypeControllValidator(control: AbstractControl): { [key: string]: boolean } {
	if (control.value === InvoiceType.SUPPLIER || control.value === InvoiceType.WORKER || control.value === InvoiceType.PAYMENT ) {
		return { invoiceTypeValid: true };
	}
	return null;
}

