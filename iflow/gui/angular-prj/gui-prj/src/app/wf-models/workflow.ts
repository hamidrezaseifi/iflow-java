
import { User } from '../ui-models';
import { WorkflowType } from '../wf-models';
import { WorkflowTypeStep } from '../wf-models';
import { WorkflowFile } from '../wf-models';
import { WorkflowAction } from '../wf-models';

export class Workflow {
	public identity: string;
	public status: string;
	public workflowType: WorkflowType;
	public currentStep: WorkflowTypeStep;
	public currentStepIdentity: string;
	public controllerIdentity: string;
	public controllerUser: User;
	public comments: string;


	public files: WorkflowFile[];
	public actions: WorkflowAction[];


}

