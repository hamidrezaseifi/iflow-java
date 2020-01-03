
import { InvoiceWorkflow } from './invoice-workflow';
import { WorkflowProcessCommand, AssignItem, WorkflowUploadedFile } from '../wf-models';
import { UploadedFile } from '../ui-models';

export class InvoiceWorkflowSaveRequest {
	
	workflow :InvoiceWorkflow = new InvoiceWorkflow();
	expireDays :number = 0;
	assigns :AssignItem[] = [];
	command :WorkflowProcessCommand = WorkflowProcessCommand.NONE;
	uploadedFiles :WorkflowUploadedFile[] = [];

	loadUploadedFiles(uploadedFiles :UploadedFile[]){
		for(var index in uploadedFiles){
			var wUploadedFile :WorkflowUploadedFile = new WorkflowUploadedFile(uploadedFiles[index]);
			this.uploadedFiles.push(wUploadedFile);
		}
		
	}
	
}

