import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { LoadingServiceService } from '../../loading-service.service';
import { HttpHepler } from '../../../helper/http-hepler';

import { WorkflowSaveRequestInit } from '../../../wf-models/workflow-save-request-init';
import { WorkflowSaveRequest } from '../../../wf-models/workflow-save-request';

import { WorkflowProcessCommand, Workflow, AssignItem, FileTitle, AssignType } from '../../../wf-models';

import { WorkflowEditBaseService } from '../workflow-edit-base.service';

@Injectable({
  providedIn: 'root'
})
export class TestthreetaskWorkflowEditService extends WorkflowEditBaseService {

	public workflowSaveRequestInitSubject: BehaviorSubject<WorkflowSaveRequestInit> = new BehaviorSubject<WorkflowSaveRequestInit>(null);

	workflowSaveRequestInit :WorkflowSaveRequestInit = null;

	//initCreateUrl :string = "/workflow/singletask/data/initcreate";
	//createWorkflowUrl :string = "/workflow/singletask/data/create";
	//uploadFileUrl :string = "/workflow/singletask/data/createfile";
	
	getInitCreateUrl() :string{
		return "/workflow/testthreetask/data/initcreate";
	}
	
	getCreateWorkflowUrl() :string{
		return "/workflow/testthreetask/data/create";
	}
	
	getUploadFileUrl() :string{
		return "/workflow/testthreetask/data/createfile";
	}
	
	//userAssignType = /*[[${UserAssign}]]*/ '';
	//departmentAssignType = /*[[${DepartmentAssign}]]*/ '';
	//departmentGroupAssignType = /*[[${DepartmentGroupAssign}]]*/ '';
	
	constructor(
			protected http: HttpClient,
			protected loadingService: LoadingServiceService,
	) { 
		super(http, loadingService);
		
	}

}
