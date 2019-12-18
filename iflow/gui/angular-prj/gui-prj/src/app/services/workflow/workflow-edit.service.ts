import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { LoadingServiceService } from '../loading-service.service';
import { HttpHepler } from '../../helper/http-hepler';

import { WorkflowSaveRequestInit } from '../../wf-models/workflow-save-request-init';
import { WorkflowSaveRequest } from '../../wf-models/workflow-save-request';

import { WorkflowProcessCommand, Workflow, AssignItem, FileTitle, AssignType } from '../../wf-models';


@Injectable({
  providedIn: 'root'
})
export class WorkflowEditService {

	public workflowSaveRequestInitSubject: BehaviorSubject<WorkflowSaveRequestInit> = new BehaviorSubject<WorkflowSaveRequestInit>(null);

	workflowSaveRequestInit :WorkflowSaveRequestInit = null;

	initCreateUrl :string = "/workflow/singletask/data/initcreate";
	createWorkflowUrl :string = "/workflow/singletask/data/create";
	uploadFileUrl :string = "/workflow/singletask/data/createfile";
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
	
	uploadFiles(fileTitles : FileTitle[]){
		
	    const formData = new FormData();
	    		
		for (var i = 0; i < fileTitles.length; i++) {
		    formData.append('files', fileTitles[i].file);
		    formData.append('titles', fileTitles[i].title);
		    formData.append('wids', i + "");
		}
    	
        const httpFileUploadOptions = { headers: HttpHepler.generateFileUploadHeader() };
        
	    return this.http.post(this.uploadFileUrl, formData, httpFileUploadOptions);
		
	}
	
	
	saveWorkflow(workflowSaveRequest :WorkflowSaveRequest){
    	
        const httpOptions = { headers: HttpHepler.generateJsonHeader() };
        
        return this.http.post(this.createWorkflowUrl , workflowSaveRequest, httpOptions);	       	

	}
	
}
