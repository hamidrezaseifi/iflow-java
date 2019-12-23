import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { DateAdapter } from '@angular/material';

import { GlobalService } from '../../../services/global.service';
import { TestthreetaskWorkflowEditService } from '../../../services/workflow/testthreetask/testthreetask-workflow-edit.service';
import { LoadingServiceService } from '../../../services/loading-service.service';
import { ErrorServiceService } from '../../../services/error-service.service';

import { User, Department, DepartmentGroup, GeneralData } from '../../../ui-models';
import { WorkflowProcessCommand, Workflow, AssignItem, FileTitle, AssignType, WorkflowUploadFileResult } from '../../../wf-models';
import { WorkflowSaveRequest } from '../../../wf-models/workflow-save-request';
import { WorkflowSaveRequestInit } from '../../../wf-models/workflow-save-request-init';
import { GermanDateAdapter, parseDate, formatDate } from '../../../helper';

@Component({
  selector: 'app-edit-testthree-task',
  templateUrl: './edit-testthree-task.component.html',
  styleUrls: ['./edit-testthree-task.component.css'],
  providers: [{provide: DateAdapter, useClass: GermanDateAdapter}]
})
export class EditTestthreeTaskComponent implements OnInit {

	saveMessage :string = "";

	workflowIdentity :string = "";
	
	workflowEditForm: FormGroup;
	
	workflowListUrl :string = "/workflow/list";
	
	workflowSaveRequest :WorkflowSaveRequest = new WorkflowSaveRequest();

	viewWorkflowModel :Workflow = null;
	
	users : User[] = [];
	departments : Department[] = [];
	
	fileTitles : FileTitle[] = [];
		
	showAssignModal :boolean = false;
	
	selectAssign : boolean[][] = [];
	
	assignTypeUser :AssignType = AssignType.USER;
	assignTypeDepartment :AssignType = AssignType.DEPARTMENT;
	assignTypeDepartmentGroup :AssignType = AssignType.DEPARTMENTGROUP;
	
	
	
	fileTitleProgress(fileInput: any, file :FileTitle, fileIndex) {
		
		if(fileInput.target.files && fileInput.target.files != null && file){
			file.file = <File>fileInput.target.files[0];
		}
		
	    //this.preview();
	}
	
	
	
	get assignedUsers() : AssignItem[]{
		if(this.workflowSaveRequest != null){
			return this.workflowSaveRequest.assigns;
		}
		return [];
	}
	
	
	get debugData() :string{
		var ss = formatDate(new Date(), 'dd.mm.yyyy');
		ss += " -- " + parseDate(ss, 'dd.mm.yyyy');
		return ss;
	}
	
	get isWorkflowDone() :boolean{
		if(this.workflowSaveRequest.workflow){
			return this.workflowSaveRequest.workflow.isDone;
		}
		return false;
	}
	
	get isWorkflowInLastStep() :boolean{
		if(this.workflowSaveRequest.workflow){
			return this.workflowSaveRequest.workflow.isLastStep;
		}
		return false;		
	}
	
	get canSave() :boolean{
		if(this.workflowSaveRequest.workflow){
			return this.workflowSaveRequest.workflow.canSave;
		}
		return false;
	}
	
	get canDone() :boolean{
		if(this.workflowSaveRequest.workflow){
			return this.workflowSaveRequest.workflow.canDone;
		}
		return false;
	}
	
	get canArchive() :boolean{
		if(this.workflowSaveRequest.workflow){
			return this.workflowSaveRequest.workflow.canArchive;
		}
		return false;
	}
	
	get canAssign() :boolean{
		if(this.workflowSaveRequest.workflow){
			return this.workflowSaveRequest.workflow.canAssign;
		}
		return true;
	}
	
	
	
	constructor(
		    private router: Router,
			private global: GlobalService,
			private translate: TranslateService,
			private editService :TestthreetaskWorkflowEditService,
			private loadingService: LoadingServiceService,
			private http: HttpClient,
			private errorService: ErrorServiceService,
		  	private formBuilder: FormBuilder,
		  	private dateAdapter: DateAdapter<Date>,
		  	private route: ActivatedRoute,
	) {
		
		
		this.router.events.subscribe((evt) => {
			if (evt instanceof NavigationEnd) {
				this.workflowIdentity = this.route.snapshot.params['identity'];
				this.loadInitialData();
			}
		});
		
		this.dateAdapter.setLocale('de');
		
	}
	
	ngOnInit() {
	
		this.workflowEditForm = this.formBuilder.group({
			expireDays: [10, Validators.required],
	
			controllerIdentity: ['', Validators.required],
			comments: [''],
			
	    });
	
		
	}
	
	reload() {
		
		this.loadInitialData();
	
	}
	
	private loadInitialData(){
		
		if(this.workflowIdentity == ''){
			return;
		}
		
	 	if(this.global.loadedGeneralData !== null){
	 		this.users = this.global.loadedGeneralData.company.users;
	 		this.departments = this.global.loadedGeneralData.company.departments;
	 	}
	 	else{
	 		this.subscribeToGeneralData();
	 		this.global.loadAllSetting(null);
	 	}
	
	 	this.loadWorkflowData();
	 	
	}
	
	private loadWorkflowData(){
		
		this.loadingService.showLoading();	     
		this.editService.loadEditInitialData(this.workflowIdentity).subscribe(
	        (initialData :WorkflowSaveRequestInit) => {
	        	
				console.log("set inital-data from workflow-edit. : ", initialData);
				//alert("from app-comp: \n" + JSON.stringify(data));
		 		
				if(initialData && initialData !== null){
					this.workflowSaveRequest = initialData.workflowSaveRequest;
					this.viewWorkflowModel = this.workflowSaveRequest.workflow;
					this.setToControlValues();
					
				}
				else{
					this.workflowSaveRequest = null;
				}
	            
	        },
	        response => {
	        	console.log("Error in read edit inital data", response);
	        	this.errorService.showErrorResponse(response);
	        },
	        () => {
	        	
	        	this.loadingService.hideLoading();	            
	        }
	    );	       	
		
	}
	
	
	setToControlValues(){
		if(this.workflowSaveRequest && this.workflowSaveRequest.workflow){
			
			this.workflowEditForm.controls["expireDays"].setValue(this.workflowSaveRequest.expireDays);
			
			this.workflowEditForm.controls["controllerIdentity"].setValue(this.workflowSaveRequest.workflow.controllerIdentity);
			this.workflowEditForm.controls["comments"].setValue(this.workflowSaveRequest.workflow.comments);
									
		}
	}
	
	setFormControlValues(){
		
		this.workflowSaveRequest.expireDays = this.workflowEditForm.controls["expireDays"].value;
		
		this.workflowSaveRequest.workflow.controllerIdentity = this.workflowEditForm.controls["controllerIdentity"].value; 
		this.workflowSaveRequest.workflow.comments = this.workflowEditForm.controls["comments"].value; 
	}
	
	  
	get forms() { return this.workflowEditForm.controls; }
		
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
					this.users = [];
	 	 			this.departments = [];
				}
		 	  		
			}
			else{
				this.users = [];
		 			this.departments = [];
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
		ft.file = null;
		
		this.fileTitles.push(ft);
	}
	
	save(makeDone :boolean){
		
		this.setFormControlValues();
		//return;
		
		this.loadingService.showLoading();
		
		if(this.fileTitles.length > 0){
			this.editService.uploadFiles(this.fileTitles).subscribe(
			        (result :WorkflowUploadFileResult) => {		        	
			            console.log("Create workflow upload file result", result);
			            
			            this.workflowSaveRequest.sessionKey = result.sessionKey;
			            
			            if(makeDone){
			            	this.doneWorkflowData();
			            }
			            else{
			            	this.saveWorkflowData();
			            }
			                  	
			            
			        },
			        response => {
			        	console.log("Error in create workflow upload file", response);
			        	this.loadingService.hideLoading();	 
			        	this.errorService.showErrorResponse(response);
			        },
			        () => {
			        	
			        	           
			        }
			    );	       	
			
		}
		else{
	        this.workflowSaveRequest.sessionKey = 'not-set';
	        
	        if(makeDone){
	        	this.doneWorkflowData();
	        }
	        else{
	        	this.saveWorkflowData();
	        }
		}
	
	}
	
	
	archive(){
		
		this.setFormControlValues();
		//return;
		
		this.loadingService.showLoading();
		
		if(this.fileTitles.length > 0){
			this.editService.uploadFiles(this.fileTitles).subscribe(
			        (result :WorkflowUploadFileResult) => {		        	
			            console.log("Create workflow upload file result", result);
			            
			            this.workflowSaveRequest.sessionKey = result.sessionKey;			            
			            this.archiveWorkflowData();
			            
			        },
			        response => {
			        	console.log("Error in create workflow upload file", response);
			        	this.loadingService.hideLoading();	 
			        	this.errorService.showErrorResponse(response);
			        },
			        () => {
			        	
			        	           
			        }
			    );	       	
			
		}
		else{
	        this.workflowSaveRequest.sessionKey = 'not-set';
	        
	        this.archiveWorkflowData();
		}
		
		
		
	
	}	
	private saveWorkflowData(){
		
	    this.editService.saveWorkflow(this.workflowSaveRequest.workflow).subscribe(
		        (result) => {		        	
		            console.log("Create workflow result", result);
		            
		            this.translate.get('common.saved').subscribe((res: string) => {
		            	this.saveMessage = res;
		            });
		            
		            this.loadWorkflowData();

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
	
	private doneWorkflowData(){
		
	    this.editService.doneWorkflow(this.workflowSaveRequest).subscribe(
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
	
	private archiveWorkflowData(){
		
	    this.editService.archiveWorkflow(this.workflowSaveRequest.workflow).subscribe(
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
	
	isItemAssigned(identity :string , type: AssignType){
	
		if(this.selectAssign[type] === undefined){
			this.selectAssign[type] = [];
		}
		if(this.selectAssign[type][identity] === undefined){
			this.selectAssign[type][identity] = false;
		}
	
		return this.selectAssign[type][identity];
	}
	
	applyUserSelect(){
		this.workflowSaveRequest.assigns = [];
		
		for(var type in this.selectAssign){
			for(var identity in this.selectAssign[type]){
				
				if(this.selectAssign[type][identity]){
					var assign = new AssignItem;
					assign.itemIdentity = <string>identity;
					assign.itemType = <AssignType>type;
					
					this.workflowSaveRequest.assigns.push(assign);
					
				}
			}			
		}
		
		this.hideAssignSelect();
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
	
	toggleAssign(identity :string , type: AssignType, isChecked: boolean){
		if(this.selectAssign[type] === undefined){
			this.selectAssign[type] = [];
		}
		this.selectAssign[type][identity] = isChecked;
		
	}
	
	getAssignItemTitle(item :AssignItem){
		//assign.itemIdentity = <string>identity;
		//assign.itemType = <AssignType>type;
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
