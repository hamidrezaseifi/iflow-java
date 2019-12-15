
import { User } from '../ui-models';
import { WorkflowFileVersion } from '../wf-models';

export class WorkflowFile {
	private identity :string;
	private createdByIdentity :string;
	private title :string;
	private extention :string;
	private activeFilePath :string;
	private comments :string;
	private activeFileVersion :Number;
	private assignToUser :User;
	private status :Number;
	private fileVersions :WorkflowFileVersion[];

}

