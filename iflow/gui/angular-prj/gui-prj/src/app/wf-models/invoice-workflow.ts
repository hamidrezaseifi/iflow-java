
import { User } from '../ui-models';
import { WorkflowType } from '../wf-models';
import { WorkflowTypeStep } from '../wf-models';
import { WorkflowFile } from '../wf-models';
import { WorkflowAction } from '../wf-models';
import { InvoiceType } from '../wf-models';

export class InvoiceWorkflow {
	identity: string;
	status: string;
	workflowType: WorkflowType;
	currentStep: WorkflowTypeStep;
	currentStepIdentity: string;
	controllerIdentity: string;
	controllerUser: User;
	comments: string;

	assigned: boolean;
	initializing: boolean;
	meAssigned: boolean;
	notAssigned: boolean;


	files: WorkflowFile[];
	actions: WorkflowAction[];

	sender: string;
	registerNumber: string;
	invoceDate: Date;
	partnerCode: string;
	vendorNumber: string;
	vendorName: string;
	isDirectDebitPermission: boolean;
	invoiceType: InvoiceType;
	
	discountEnterDate: Date;
	discountDeadline: number;
	discountRate: number;
	discountDate: Date;
	
	paymentAmount: number;

}




