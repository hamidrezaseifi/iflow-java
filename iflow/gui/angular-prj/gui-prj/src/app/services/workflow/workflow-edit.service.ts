import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { LoadingServiceService } from '../loading-service.service';
import { HttpHepler } from '../../helper/http-hepler';

import { WorkflowProcessCommand, Workflow, AssignItem } from '../../wf-models';
import { WorkflowSaveRequestInit } from '../../wf-models/workflow-save-request-init';

@Injectable({
  providedIn: 'root'
})
export class WorkflowEditService {

	public workflowSaveRequestInitSubject: BehaviorSubject<WorkflowSaveRequestInit> = new BehaviorSubject<WorkflowSaveRequestInit>(null);

	workflowSaveRequestInit :WorkflowSaveRequestInit = null;

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
		        (initialData :WorkflowSaveRequestInit) => {
		        	
		            console.log("GET successful edit inital data", initialData);
		            
		            this.workflowSaveRequestInit = <WorkflowSaveRequestInit> JSON.parse(JSON.stringify(initialData));
		            
		            this.workflowSaveRequestInitSubject.next(initialData);
		        	
		            
		        },
		        response => {
		        	console.log("Error in read edit inital data", response);
		        },
		        () => {
		        	this.workflowSaveRequestInitSubject.complete();
		        	this.loadingService.hideLoading();	            
		        }
		    );	       	

	}
}
