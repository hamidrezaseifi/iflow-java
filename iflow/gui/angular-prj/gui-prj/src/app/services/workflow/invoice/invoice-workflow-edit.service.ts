import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { LoadingServiceService } from '../../loading-service.service';
import { HttpHepler } from '../../../helper/http-hepler';

import { InvoiceWorkflowSaveRequestInit } from '../../../wf-models/invoice-workflow-save-request-init';
import { InvoiceWorkflowSaveRequest } from '../../../wf-models/invoice-workflow-save-request';

import { WorkflowProcessCommand, Workflow, AssignItem, FileTitle, AssignType } from '../../../wf-models';

@Injectable({
  providedIn: 'root'
})
export class InvoiceWorkflowEditService {

	public workflowSaveRequestInitSubject: BehaviorSubject<InvoiceWorkflowSaveRequestInit> = new BehaviorSubject<InvoiceWorkflowSaveRequestInit>(null);

	workflowSaveRequestInit :InvoiceWorkflowSaveRequestInit = null;

	getInitCreateUrl() :string{
		return "/workflow/invoice/data/initcreate";
	}
	
	getCreateWorkflowUrl() :string{
		return "/workflow/invoice/data/create";
	}
	
	getUploadFileUrl() :string{
		return "/workflow/invoice/data/createfile";
	}
	
	
	//userAssignType = /*[[${UserAssign}]]*/ '';
	//departmentAssignType = /*[[${DepartmentAssign}]]*/ '';
	//departmentGroupAssignType = /*[[${DepartmentGroupAssign}]]*/ '';
	
	constructor(
			protected http: HttpClient,
			protected loadingService: LoadingServiceService,
	) { 
		
		
	}
	
	
	loadCreateInitialData(){
    	this.loadingService.showLoading();
    	
        const httpOptions = { headers: HttpHepler.generateFormHeader() };
        
        this.http.post(this.getInitCreateUrl(), new HttpParams(), httpOptions).subscribe(
		        (initialData :InvoiceWorkflowSaveRequestInit) => {
		        	
		            console.log("GET successful edit inital data", initialData);
		            
		            this.workflowSaveRequestInit = <InvoiceWorkflowSaveRequestInit> JSON.parse(JSON.stringify(initialData));
		            
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
        
	    return this.http.post(this.getUploadFileUrl(), formData, httpFileUploadOptions);
		
	}
	
	
	saveWorkflow(workflowSaveRequest :InvoiceWorkflowSaveRequest){
    	
        const httpOptions = { headers: HttpHepler.generateJsonHeader() };
        
        return this.http.post(this.getCreateWorkflowUrl() , workflowSaveRequest, httpOptions);	       	

	}	
	
}
