import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';

import { GlobalService } from '../../../services/global.service';
import { WorkflowEditService } from '../../../services/workflow/workflow-edit.service';
import { LoadingServiceService } from '../../../services/loading-service.service';

import { User, Department, DepartmentGroup, GeneralData } from '../../../ui-models';
import { WorkflowProcessCommand, Workflow, AssignItem, FileTitle, AssignType } from '../../../wf-models';
import { WorkflowSaveRequest } from '../../../wf-models/workflow-save-request';
import { WorkflowSaveRequestInit } from '../../../wf-models/workflow-save-request-init';

@Component({
  selector: 'app-create-singletask',
  templateUrl: './create-singletask.component.html',
  styleUrls: ['./create-singletask.component.css']
})
export class CreateSingletaskComponent implements OnInit {

	workflowSaveRequest :WorkflowSaveRequest = null;
	users : User[] = [];
	departments : Department[] = [];

	fileTitles : FileTitle[] = [];

	showDebug : boolean = false;

	assignTypeUser :AssignType = AssignType.USER;
	assignTypeDepartment :AssignType = AssignType.DEPARTMENT;
	assignTypeDepartmentGroup :AssignType = AssignType.DEPARTMENTGROUP;


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
		return (this.workflowSaveRequest && this.workflowSaveRequest != null) ? JSON.stringify(this.workflowSaveRequest): " -- debug";
	}
	
	
	constructor(
		    private router: Router,
			private global: GlobalService,
			translate: TranslateService,
			private editService :WorkflowEditService,
			private loadingService: LoadingServiceService,
			
	) {
		
		this.router.events.subscribe((evt) => {
			if (evt instanceof NavigationEnd) {
		    	this.loadInitialData();
			}
		});
	}

	ngOnInit() {
		
		this.loadInitialData();
	
	}
	
	private loadInitialData(){
	 	if(this.editService.workflowSaveRequestInit !== null){
	 		this.workflowSaveRequest = this.editService.workflowSaveRequestInit.workflowSaveRequest;
	 		
	 	}
	 	else{
	 		this.subscribeToSearchInitialData();
	 		this.editService.loadCreateInitialData();
	 	}

     	if(this.global.loadedGeneralData !== null){
     		this.users = this.global.loadedGeneralData.company.users;
	 		this.departments = this.global.loadedGeneralData.company.departments;
     	}
     	else{
     		this.subscribeToGeneralData();
     		this.global.loadAllSetting(null);
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
	}
	
	private subscribeToGeneralData(){
		this.global.currentSessionDataSubject.subscribe((data : GeneralData) => {
	    	
			console.log("set gloabl-data from workflow-create. appIsLogged: ");
			//alert("from app-comp: \n" + JSON.stringify(data));
	    	
			if(data && data !== null){
				
				var value = data.isLogged + "";
				
				if(value === "true" === true){
	 	 			this.users = data.company.users;
	 	 			this.departments = data.company.departments;
	 	 	  		
				}
				else{
					this.users =[];
	 	 			this.departments = data.company.departments;
				}
		 	  		
			}
			else{
				this.users =[];
 	 			this.departments = data.company.departments;
			}
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
	
	removeFile(index){
		this.fileTitles.splice(index, 1);
	}
	
	addFile(){
		var ft :FileTitle = new FileTitle();
		ft.title = "";
		ft.file = false;
		
		this.fileTitles.push(ft);
	}
	
	save(){
		
	}
	
	isItemAssigned(identity :string , type: AssignType){
		//var type = itype == 'user' ? userAssignType : itype == 'department' ? departmentAssignType : departmentGroupAssignType;

		for(var index in this.workflowSaveRequest.assigns){
			var assign = this.workflowSaveRequest.assigns[index];
			
		    if(assign.itemIdentity == identity && assign.itemType == type){
		    	return true;
		    }
		}
		
		return false;
	}
	
	applyUserSelect(){
		this.workflowSaveRequest.assigns = [];
		
		
		/*$(".assign-checkbox:checked").each(function(index, item){
			var jitem = $(item);
			
			var type = jitem.data("assigntype") == 'user' ? userAssignType : jitem.data("assigntype") == 'department' ? departmentAssignType : departmentGroupAssignType;
			
			this.workflowSaveRequest.assigns.push({itemIdentity: jitem.val(),  itemType: type, title: jitem.data("assigntitle")});
		});
    	$('#assignlistdialog').modal('hide');*/
		
	}
}
