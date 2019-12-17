import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { LoadingServiceService } from '../loading-service.service';
import { HttpHepler } from '../../helper/http-hepler';

import { WorkflowProcessCommand, Workflow, AssignItem } from '../../wf-models';
import { WorkflowSaveRequest } from '../../wf-models/workflow-save-request';

@Injectable({
  providedIn: 'root'
})
export class WorkflowEditService {

	public workflowSaveRequestSubject: BehaviorSubject<WorkflowSaveRequest> = new BehaviorSubject<WorkflowSaveRequest>(null);

	workflowSaveRequest :WorkflowSaveRequest = null;

	initCreateUrl :string = "/workflow/singletask/data/initcreate";
	saveUrl :string = "/workflow/singletask/data/create";
	saveFileUrl :string = "/workflow/singletask/data/createfile";
	listUrl :string = "/workflow/list";
	
	//userAssignType = /*[[${UserAssign}]]*/ '';
	//departmentAssignType = /*[[${DepartmentAssign}]]*/ '';
	//departmentGroupAssignType = /*[[${DepartmentGroupAssign}]]*/ '';
	
	constructor(
			private http: HttpClient,
			private loadingService: LoadingServiceService,
	) { 
		
		
	}
	
	
	loadCreateInitialData(){
    	this.loadingService.showLoading();
    	
        const httpOptions = { headers: HttpHepler.generateFormHeader() };
        
        this.http.post(this.initCreateUrl, new HttpParams(), httpOptions).subscribe(
		        (initialData :WorkflowSaveRequest) => {
		        	
		            console.log("GET successful search inital data", initialData);
		            
		            this.workflowSaveRequest = <WorkflowSaveRequest> JSON.parse(JSON.stringify(initialData));
		            
		            this.workflowSaveRequestSubject.next(initialData);
		        	
		            
		        },
		        response => {
		        	console.log("Error in read create inital data", response);
		        },
		        () => {
		        	this.workflowSaveRequestSubject.complete();
		        	this.loadingService.hideLoading();	            
		        }
		    );	       	

	}
}
