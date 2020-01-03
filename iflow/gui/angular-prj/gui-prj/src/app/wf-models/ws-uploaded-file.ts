
import { UploadedFile } from '../ui-models';

export class WorkflowUploadedFile {
		
	fileName: string = "";
	filePathHashed: string = "";

	constructor(
			uploadedFile?: UploadedFile,
	) {
		if(uploadedFile){
			this.fileName = uploadedFile.fileName;
			this.filePathHashed = uploadedFile.scanedPdfPath;
		}
		
	}
}
