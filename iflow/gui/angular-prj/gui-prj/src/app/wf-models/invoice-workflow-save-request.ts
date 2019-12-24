
import { InvoiceWorkflow } from './invoice-workflow';
import { WorkflowProcessCommand } from '../wf-models';
import { AssignItem } from '../wf-models';

export class InvoiceWorkflowSaveRequest {
	
	workflow :InvoiceWorkflow = new InvoiceWorkflow();
	expireDays :number = 0;
	assigns :AssignItem[] = [];
	command :WorkflowProcessCommand = WorkflowProcessCommand.NONE;
	sessionKey :string = "";

}

