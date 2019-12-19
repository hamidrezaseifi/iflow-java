import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';

import { GlobalService } from '../../../services/global.service';
import { InvoiceWorkflowEditService } from '../../../services/workflow/invoice/invoice-workflow-edit.service';
import { LoadingServiceService } from '../../../services/loading-service.service';
import { ErrorServiceService } from '../../../services/error-service.service';

import { User, Department, DepartmentGroup, GeneralData } from '../../../ui-models';
import { WorkflowProcessCommand, Workflow, AssignItem, FileTitle, AssignType, WorkflowUploadFileResult, InvoiceType } from '../../../wf-models';
import { InvoiceWorkflowSaveRequest } from '../../../wf-models/invoice-workflow-save-request';
import { InvoiceWorkflowSaveRequestInit } from '../../../wf-models/invoice-workflow-save-request-init';
import { InvoiceTypeControllValidator } from '../../../custom-validators/invoice-type-controll-validator';

@Component({
  selector: 'app-create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.css']
})
export class CreateInvoiceComponent implements OnInit {

	invoiceEditForm: FormGroup;

	workflowListUrl :string = "/workflow/list";

	workflowSaveRequest :InvoiceWorkflowSaveRequest = new InvoiceWorkflowSaveRequest();
	users : User[] = [];
	departments : Department[] = [];
	
	fileTitles : FileTitle[] = [];
	
	showDebug : boolean = false;
	
	showAssignModal :boolean = false;
	
	selectAssign : boolean[][] = [];

	invoiceTypes : any[] = []; //{InvoiceType.NO_TYPE, InvoiceType.SUPPLIER , InvoiceType.WORKER , InvoiceType.PAYMENT };
	
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
		var ssignstr : string =  (this.workflowSaveRequest) ? JSON.stringify(this.workflowSaveRequest) : '--';
		return ssignstr;
	}
	
	
	constructor(
		    private router: Router,
			private global: GlobalService,
			translate: TranslateService,
			private editService :InvoiceWorkflowEditService,
			private loadingService: LoadingServiceService,
			private http: HttpClient,
			private errorService: ErrorServiceService,
		  	private formBuilder: FormBuilder,
	) {
		
		this.router.events.subscribe((evt) => {
			if (evt instanceof NavigationEnd) {
		    	this.loadInitialData();
			}
		});
		
		//this.invoiceTypes.push(InvoiceType.NO_TYPE);
		//this.invoiceTypes.push(InvoiceType.SUPPLIER);
		//this.invoiceTypes.push(InvoiceType.WORKER);
		//this.invoiceTypes.push(InvoiceType.PAYMENT);
		for(var o in InvoiceType){
			var str = o + "";
			var num = <number>new Number(o);
			if(isNaN(num)){
				translate.get('invoice-invoicetype-' + str.toLowerCase()).subscribe((res: string) => {
					this.invoiceTypes.push({value: o, title: res});
		        });
			}
			
		}
		
	}
	
	ngOnInit() {
	
		//this.loginForm.controls["username"].value,
		
		this.invoiceEditForm = this.formBuilder.group({
			expireDays: [10, Validators.required],

			controllerIdentity: ['', Validators.required],
			comments: [''],

			sender: ['', Validators.required],
			registerNumber: ['', Validators.required],
			invoceDate: [new Date(), Validators.required],
			partnerCode: ['', Validators.required],
			vendorNumber: ['', Validators.required],
			vendorName: ['', Validators.required],
			isDirectDebitPermission: [false],
			invoiceType: [InvoiceType.NO_TYPE, [Validators.required, InvoiceTypeControllValidator]],
			
			discountEnterDate: [new Date(), Validators.required],
			discountDeadline: [0, Validators.required],
			discountRate: [0, Validators.required],
			discountDate: [new Date(), Validators.required],
			
			paymentAmount: [0, Validators.required],
			
        });

		this.loadInitialData();
		
	}
	
	reload() {
		
		this.loadInitialData();
	
	}
	
	private loadInitialData(){
	 	if(this.editService.workflowSaveRequestInit !== null){
	 		this.workflowSaveRequest = this.editService.workflowSaveRequestInit.workflowSaveRequest;
	 		this.setToControlValues();
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
	
	setToControlValues(){
		if(this.workflowSaveRequest && this.workflowSaveRequest.workflow){
			this.invoiceEditForm.controls["expireDays"].setValue(this.workflowSaveRequest.expireDays);
			
			this.invoiceEditForm.controls["controllerIdentity"].setValue(this.workflowSaveRequest.workflow.controllerIdentity);
			this.invoiceEditForm.controls["comments"].setValue(this.workflowSaveRequest.workflow.comments);
			
			this.invoiceEditForm.controls["sender"].setValue(this.workflowSaveRequest.workflow.sender);
			this.invoiceEditForm.controls["registerNumber"].setValue(this.workflowSaveRequest.workflow.registerNumber);
			this.invoiceEditForm.controls["invoceDate"].setValue(this.workflowSaveRequest.workflow.invoceDate);
			this.invoiceEditForm.controls["partnerCode"].setValue(this.workflowSaveRequest.workflow.partnerCode);
			this.invoiceEditForm.controls["vendorNumber"].setValue(this.workflowSaveRequest.workflow.vendorNumber);
			this.invoiceEditForm.controls["vendorName"].setValue(this.workflowSaveRequest.workflow.vendorName);
			this.invoiceEditForm.controls["isDirectDebitPermission"].setValue(this.workflowSaveRequest.workflow.isDirectDebitPermission);
			this.invoiceEditForm.controls["invoiceType"].setValue(this.workflowSaveRequest.workflow.invoiceType);
			this.invoiceEditForm.controls["discountEnterDate"].setValue(this.workflowSaveRequest.workflow.discountEnterDate);
			this.invoiceEditForm.controls["comments"].setValue(this.workflowSaveRequest.workflow.comments);
			this.invoiceEditForm.controls["discountDeadline"].setValue(this.workflowSaveRequest.workflow.discountDeadline);
			this.invoiceEditForm.controls["discountRate"].setValue(this.workflowSaveRequest.workflow.discountRate);
			this.invoiceEditForm.controls["discountDate"].setValue(this.workflowSaveRequest.workflow.discountDate);
			this.invoiceEditForm.controls["paymentAmount"].setValue(this.workflowSaveRequest.workflow.paymentAmount);
						
		}
	}
	
	setFormControlValues(){
		
		this.workflowSaveRequest.expireDays = this.invoiceEditForm.controls["expireDays"].value;
		
		this.workflowSaveRequest.workflow.controllerIdentity = this.invoiceEditForm.controls["controllerIdentity"].value; 
		this.workflowSaveRequest.workflow.comments = this.invoiceEditForm.controls["comments"].value; 
		
		this.workflowSaveRequest.workflow.sender = this.invoiceEditForm.controls["sender"].value; 
		this.workflowSaveRequest.workflow.registerNumber = this.invoiceEditForm.controls["registerNumber"].value;  
		this.workflowSaveRequest.workflow.invoceDate = this.invoiceEditForm.controls["invoceDate"].value; 
		this.workflowSaveRequest.workflow.partnerCode = this.invoiceEditForm.controls["partnerCode"].value; 
		this.workflowSaveRequest.workflow.vendorNumber = this.invoiceEditForm.controls["vendorNumber"].value; 
		this.workflowSaveRequest.workflow.vendorName = this.invoiceEditForm.controls["vendorName"].value; 
		this.workflowSaveRequest.workflow.isDirectDebitPermission = this.invoiceEditForm.controls["isDirectDebitPermission"].value; 
		this.workflowSaveRequest.workflow.invoiceType = this.invoiceEditForm.controls["invoiceType"].value; 
		this.workflowSaveRequest.workflow.discountEnterDate = this.invoiceEditForm.controls["discountEnterDate"].value; 
		this.workflowSaveRequest.workflow.comments = this.invoiceEditForm.controls["comments"].value; 
		this.workflowSaveRequest.workflow.discountDeadline = this.invoiceEditForm.controls["discountDeadline"].value; 
		this.workflowSaveRequest.workflow.discountRate = this.invoiceEditForm.controls["discountRate"].value; 
		this.workflowSaveRequest.workflow.discountDate = this.invoiceEditForm.controls["discountDate"].value; 
		this.workflowSaveRequest.workflow.paymentAmount = this.invoiceEditForm.controls["paymentAmount"].value; 
	}
	
	  
	get forms() { return this.invoiceEditForm.controls; }
	
	private subscribeToSearchInitialData(){
		this.editService.workflowSaveRequestInitSubject.subscribe((data : InvoiceWorkflowSaveRequestInit) => {
	    	
			console.log("set gloabl-data from workflow-create. : ", data);
			//alert("from app-comp: \n" + JSON.stringify(data));
	 		
			if(data && data !== null){
				this.workflowSaveRequest = data.workflowSaveRequest;
				this.setToControlValues();
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
	
	save(){
		
		this.setFormControlValues();
		//return;
		
		this.loadingService.showLoading();
		
		if(this.fileTitles.length > 0){
			this.editService.uploadFiles(this.fileTitles).subscribe(
			        (result :WorkflowUploadFileResult) => {		        	
			            console.log("Create workflow upload file result", result);
			            
			            this.workflowSaveRequest.sessionKey = result.sessionKey;
			            
			            this.editService.saveWorkflow(this.workflowSaveRequest).subscribe(
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
	        
	        this.editService.saveWorkflow(this.workflowSaveRequest).subscribe(
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
