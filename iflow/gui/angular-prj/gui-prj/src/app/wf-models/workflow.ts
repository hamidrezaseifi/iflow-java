
import { User } from '../ui-models';
import { WorkflowType } from '../wf-models';
import { WorkflowTypeStep } from '../wf-models';
import { WorkflowFile } from '../wf-models';
import { WorkflowAction } from '../wf-models';

export class Workflow {
	identity: string;
	status: string;
	workflowType: WorkflowType;
	currentStep: WorkflowTypeStep;
	currentStepIdentity: string;
	controllerIdentity: string;
	controllerUser: User;
	comments: string;

	assigned: string;
	initializing: string;
	meAssigned: string;
	notAssigned: string;


	files: WorkflowFile[];
	actions: WorkflowAction[];


}

