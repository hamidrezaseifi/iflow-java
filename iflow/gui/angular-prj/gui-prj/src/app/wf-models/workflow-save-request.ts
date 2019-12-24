
import { Workflow } from '../wf-models';
import { WorkflowProcessCommand } from '../wf-models';
import { AssignItem } from '../wf-models';

export class WorkflowSaveRequest {
	
	workflow :Workflow = null;
	expireDays :number = 0;
	assigns :AssignItem[] = [];
	command :WorkflowProcessCommand = WorkflowProcessCommand.NONE;
	sessionKey :string = "";

}

