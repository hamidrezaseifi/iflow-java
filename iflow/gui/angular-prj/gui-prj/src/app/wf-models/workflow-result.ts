
import { User } from '../ui-models';
import { WorkflowType } from '../wf-models';
import { WorkflowTypeStep } from '../wf-models';
import { WorkflowFile } from '../wf-models';
import { WorkflowAction } from '../wf-models';

export class WorkflowResult {
	public identity: string;
	public status: string;
	public workflowType: WorkflowType;
	public currentStep: WorkflowTypeStep;
	public workflowTypeIdentity: string;
	public currentStepIdentity: string;
	public controllerIdentity: string;
	public createdByIdentity: string;
	public currentUserIdentity: string;
	public controllerUser: User;
	public comments: string;


	public files: WorkflowFile[];
	public actions: WorkflowAction[];

}

