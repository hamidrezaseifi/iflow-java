import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { Observable } from 'rxjs';

import { GlobalService } from '../../../services/global.service';
import { TestthreetaskWorkflowEditService } from '../../../services/workflow/testthreetask/testthreetask-workflow-edit.service';
import { LoadingServiceService } from '../../../services/loading-service.service';
import { ErrorServiceService } from '../../../services/error-service.service';

import { User, Department, DepartmentGroup, GeneralData, UploadedFile, UploadedResult } from '../../../ui-models';
import { WorkflowProcessCommand, Workflow, AssignItem, FileTitle, AssignType, WorkflowUploadFileResult, WorkflowUploadedFile } 
	from '../../../wf-models';
import { WorkflowSaveRequest } from '../../../wf-models/workflow-save-request';
import { WorkflowSaveRequestInit } from '../../../wf-models/workflow-save-request-init';

@Component({
  selector: 'app-create-testthreetask',
  templateUrl: './create-testthreetask.component.html',
  styleUrls: ['./create-testthreetask.component.css'],
providers: [TestthreetaskWorkflowEditService]
})
export class CreateTestthreetaskComponent implements OnInit {

	workflowListUrl :string = "/workflow/list";

	workflowSaveRequest :WorkflowSaveRequest = null;
	users : User[] = [];
	departments : Department[] = [];
	generalDataObs :Observable<GeneralData> = null;
	
	showDebug : boolean = false;
	
	showAssignModal :boolean = false;
	
	selectAssign : boolean[][] = [];
	
	assignTypeUser :AssignType = AssignType.USER;
	assignTypeDepartment :AssignType = AssignType.DEPARTMENT;
	assignTypeDepartmentGroup :AssignType = AssignType.DEPARTMENTGROUP;

	uploadedFiles :UploadedFile[] = [];	

	get expireDays() : number{
		if(this.workflowSaveRequest != null){
			return this.workflowSaveRequest.expireDays;
		}
		return 0;
	}
	set expireDays(days: number){
		if(this.workflowSaveRequest != null){
			this.workflowSaveRequest.expireDays = days;
		}
		
	}
	
	get controllerIdentity() : string{
		if(this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null){
			return this.workflowSaveRequest.workflow.controllerIdentity;
		}
		return "";
	}
	set controllerIdentity(value: string){
		if(this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null){
			this.workflowSaveRequest.workflow.controllerIdentity = value;
		}
		
	}
	
	get assignedUsers() : AssignItem[]{
		if(this.workflowSaveRequest != null){
			return this.workflowSaveRequest.assigns;
		}
		return [];
	}
	
	get comments() : string{
		if(this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null){
			return this.workflowSaveRequest.workflow.comments;
		}
		return "";
	}
	set comments(value: string){
		if(this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null){
			this.workflowSaveRequest.workflow.comments = value;
		}
		
	}
	
	
	get debugData() :string{
		var ssignstr : string =  (this.workflowSaveRequest && this.workflowSaveRequest.assigns) ? JSON.stringify(this.workflowSaveRequest.assigns) : '--';
		return ssignstr + "<hr>" + JSON.stringify(this.selectAssign);
	}
	
	
	constructor(
		    private router: Router,
			private global: GlobalService,
			public  translate: TranslateService,
			public  editService :TestthreetaskWorkflowEditService,
			private loadingService: LoadingServiceService,
			private http: HttpClient,
			private errorService: ErrorServiceService,
	) {
		
		this.router.events.subscribe((evt) => {
			if (evt instanceof NavigationEnd) {
		    	this.loadInitialData();
			}
		});
		
		this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
	}
	
	ngOnInit() {
		
		this.loadInitialData();
	
	}
	
	onUploadedFilesChanged(uploadedFileList: UploadedFile[]) {
		
		this.uploadedFiles = uploadedFileList;
	}
	
	private loadInitialData(){
	 	if(this.editService.workflowSaveRequestInit !== null){
	 		this.workflowSaveRequest = this.editService.workflowSaveRequestInit.workflowSaveRequest;
	 		
	 	}
	 	else{
	 		this.subscribeToSearchInitialData();
	 		this.editService.loadCreateInitialData();
	 	}
	 	
	}
	
	private subscribeToSearchInitialData(){
		this.editService.workflowSaveRequestInitSubject.subscribe((data : WorkflowSaveRequestInit) => {
	    	
			console.log("set gloabl-data from workflow-create. : ", data);
			//alert("from app-comp: \n" + JSON.stringify(data));
	 		
			if(data && data !== null){
				this.workflowSaveRequest = data.workflowSaveRequest;
				
			}
			else{
				this.workflowSaveRequest = null;
			}
		  });
		
		this.generalDataObs.subscribe( (generalData :GeneralData) => {
			this.users = generalData.company.users;
			this.departments = generalData.company.departments;
		});
	}
		
	get hasNoAssigns() :boolean{
		if(this.workflowSaveRequest && this.workflowSaveRequest.assigns){
			return this.workflowSaveRequest.assigns.length == 0;
		}
		return false;
	}
	
	removeAssign(identity :string , type: AssignType){
		this.workflowSaveRequest.assigns = this.workflowSaveRequest.assigns.filter(function(value, index, arr){
	
		    return value.itemIdentity != identity || value.itemType != type;
	
		});
		
	}
	
	
	save(){
		
		this.workflowSaveRequest.uploadedFiles = WorkflowUploadedFile.loadUploadedFiles(this.uploadedFiles);

		this.loadingService.showLoading();
		
        this.editService.createWorkflow(this.workflowSaveRequest).subscribe(
		        (result) => {		        	
		            console.log("Create workflow result", result);
		            
		            this.router.navigate([this.workflowListUrl]);
		        },
		        response => {
		        	console.log("Error in create workflow", response);
		        	
		        	this.errorService.showErrorResponse(response);
		        	this.loadingService.hideLoading();	 
		        },
		        () => {
		        	
		        	this.loadingService.hideLoading();	 
		        }
		    );	       	
		
	}
			
	showAssignSelect(){
		
		this.selectAssign = [];
		
		for(var index in this.workflowSaveRequest.assigns){
			var assign :AssignItem = this.workflowSaveRequest.assigns[index];
				
			if(this.selectAssign[assign.itemType] === undefined){
				this.selectAssign[assign.itemType] = [];
			}
			this.selectAssign[assign.itemType][assign.itemIdentity] = true;				
		}
		
		this.showAssignModal = true;
	}
	
	hideAssignSelect(){
		this.showAssignModal = false;
	}
	
	onUsersSelected(assigns: AssignItem[]) {
		this.workflowSaveRequest.assigns = [];
		
		for(var item in assigns){
			var assign = new AssignItem;
			assign.itemIdentity = assigns[item].itemIdentity;
			assign.itemType = assigns[item].itemType;
			
			this.workflowSaveRequest.assigns.push(assign);						
		}
		
		this.hideAssignSelect();
	}	
		
	
	getAssignItemTitle(item :AssignItem){

		if(item.itemType === AssignType.USER){
			for(var index in this.users){
				if(this.users[index].identity === item.itemIdentity){
					return this.users[index].fullName;
				}
			}
			return 'Unknown!';
		}
		
		if(item.itemType === AssignType.DEPARTMENT){
			for(var index in this.departments){
				if(this.departments[index].identity === item.itemIdentity){
					return this.departments[index].title;
				}
			}
			return 'Unknown!';
		}
		
		if(item.itemType === AssignType.DEPARTMENTGROUP){
			for(var index in this.departments){
				for(var gindex in this.departments[index].departmentGroups){
					if(this.departments[index].departmentGroups[gindex].identity === item.itemIdentity){
						return this.departments[index].departmentGroups[gindex].title;
					}
				}
			}
			return 'Unknown!';
		}
		
	}

}
