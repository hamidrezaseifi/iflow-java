import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { DateAdapter } from '@angular/material';

import { GlobalService } from '../services/global.service';
import { InvoiceWorkflowEditService } from '../services/workflow/invoice/invoice-workflow-edit.service';
import { LoadingServiceService } from '../services/loading-service.service';
import { ErrorServiceService } from '../services/error-service.service';

import { User, Department, DepartmentGroup, GeneralData } from '../ui-models';
import { WorkflowProcessCommand, Workflow, AssignItem, FileTitle, AssignType, WorkflowUploadFileResult, 
	InvoiceType } from '../wf-models';
import { InvoiceWorkflowSaveRequest } from '../wf-models/invoice-workflow-save-request';
import { InvoiceWorkflowSaveRequestInit } from '../wf-models/invoice-workflow-save-request-init';
import { InvoiceTypeControllValidator } from '../custom-validators/invoice-type-controll-validator';
import { GermanDateAdapter, parseDate, formatDate } from '../helper';


export class InvoiceBaseComponent implements OnInit {

	pageTitle :string = "not-initialized!";

	paymentamountOtherTypesTitle :string = "";
	paymentamountTypePaymentTitle :string = "";

	
	invoiceEditForm: FormGroup;

	workflowListUrl :string = "/workflow/list";

	workflowSaveRequest :InvoiceWorkflowSaveRequest = new InvoiceWorkflowSaveRequest();
	
	users : User[] = [];
	departments : Department[] = [];
	
	fileTitles : FileTitle[] = [];
		
	showAssignModal :boolean = false;
	
	selectAssign : boolean[][] = [];

	invoiceTypes : any[] = [];
	
	assignTypeUser :AssignType = AssignType.USER;
	assignTypeDepartment :AssignType = AssignType.DEPARTMENT;
	assignTypeDepartmentGroup :AssignType = AssignType.DEPARTMENTGROUP;
	
	//discountEnterDate
//discountDeadline
//discountDate

	calcDiscountDate(){
		//alert("calcDiscountDate ---");
		
		var enterDate :Date = this.invoiceEditForm.controls["discountEnterDate"].value;
		var deadline : number= this.invoiceEditForm.controls["discountDeadline"].value;
		
		if(enterDate != null && deadline != null && deadline > 0){
			this.invoiceEditForm.controls["discountDate"].setValue( new Date(enterDate.getFullYear(), enterDate.getMonth(), enterDate.getDate() + deadline) );
		}

	}
	
	fileTitleProgress(fileInput: any, file :FileTitle, fileIndex) {
		
		if(fileInput.target.files && fileInput.target.files != null && file){
			file.file = <File>fileInput.target.files[0];
		}
		
	}
	

	
	get assignedUsers() : AssignItem[]{
		if(this.workflowSaveRequest != null){
			return this.workflowSaveRequest.assigns;
		}
		return [];
	}
	
	get paymentamountTitle() :string{
		
		return this.isPaymentInvoiceType() ? this.paymentamountTypePaymentTitle : this.paymentamountOtherTypesTitle;
	}
	
	isPaymentInvoiceType() :boolean{		
		return this.invoiceEditForm.controls["invoiceType"].value === "PAYMENT";
	}
	
	constructor(
		    protected router: Router,
			protected global: GlobalService,
			protected translate: TranslateService,
			protected editService :InvoiceWorkflowEditService,
			protected loadingService: LoadingServiceService,
			protected http: HttpClient,
			protected errorService: ErrorServiceService,
		  	protected formBuilder: FormBuilder,
		  	protected dateAdapter: DateAdapter<Date>,
	) {
				
		this.dateAdapter.setLocale('de');
		
		for(var o in InvoiceType){
			var str = o + "";
			var num = <number>new Number(o);
			if(isNaN(num)){
				translate.get('invoice-invoicetype-' + str.toLowerCase()).subscribe((res: string) => {
					this.invoiceTypes.push({value: o, title: res});
		        });
			}
			
		}
		
		this.translate.get('invoice-paymentamount').subscribe((res: string) => {
        	this.paymentamountOtherTypesTitle = res;
        });

		this.translate.get('invoice-paymentamount-payment').subscribe((res: string) => {
        	this.paymentamountTypePaymentTitle = res;
        });
		
		
	}
	
	ngOnInit() {
		
		this.invoiceEditForm = this.formBuilder.group({
			expireDays: [10, Validators.required],

			controllerIdentity: ['', Validators.required],
			comments: [''],

			sender: ['', Validators.required],
			registerNumber: ['', Validators.required],
			invocieDate: [new Date(), Validators.required],
			partnerCode: ['', Validators.required],
			vendorNumber: ['', Validators.required],
			vendorName: ['', Validators.required],
			isDirectDebitPermission: [false],
			invoiceType: [InvoiceType.NO_TYPE, [InvoiceTypeControllValidator]],
			
			discountEnterDate: [new Date(), Validators.required],
			discountDeadline: [0, Validators.required],
			discountRate: [0, Validators.required],
			discountDate: [new Date(), Validators.required],
			
			paymentAmount: [0, Validators.required],
			
        });

		
	}
	
	reload() {
		
		this.loadInitialData();
	
	}
	
	protected loadInitialData(){
	 		
	 	if(this.global.loadedGeneralData !== null){
	 		this.users = this.global.loadedGeneralData.company.users;
	 		this.departments = this.global.loadedGeneralData.company.departments;
	 	}
	 	else{
	 		this.subscribeToGeneralData();
	 		this.global.loadAllSetting(null);
	 	}
	 	
	}
	
	private setPageTitle(){
		var pageLabelId = "invoice-assignview-title";
		
		if(this.workflowSaveRequest.workflow.currentStepIndex === 1){
			pageLabelId = "invoice-assignview-title";
		}
		
		if(this.workflowSaveRequest.workflow.currentStepIndex === 2){
			pageLabelId = "invoice-testingview-title";
		}
		
		if(this.workflowSaveRequest.workflow.currentStepIndex === 3){
			pageLabelId = "invoice-releaseview-title";
		}
		
        this.translate.get(pageLabelId).subscribe((res: string) => {
        	this.pageTitle = res;
        });
		
	}
	
	setToControlValues(){
		if(this.workflowSaveRequest && this.workflowSaveRequest.workflow){
			this.setPageTitle();
						
			this.invoiceEditForm.controls["expireDays"].setValue(this.workflowSaveRequest.expireDays);
			
			this.invoiceEditForm.controls["controllerIdentity"].setValue(this.workflowSaveRequest.workflow.controllerIdentity);
			this.invoiceEditForm.controls["comments"].setValue(this.workflowSaveRequest.workflow.comments);
			
			this.invoiceEditForm.controls["sender"].setValue(this.workflowSaveRequest.workflow.sender);
			this.invoiceEditForm.controls["registerNumber"].setValue(this.workflowSaveRequest.workflow.registerNumber);
			this.invoiceEditForm.controls["invocieDate"].setValue(parseDate(this.workflowSaveRequest.workflow.invocieDate, 'dd.mm.yyyy'));
			this.invoiceEditForm.controls["partnerCode"].setValue(this.workflowSaveRequest.workflow.partnerCode);
			this.invoiceEditForm.controls["vendorNumber"].setValue(this.workflowSaveRequest.workflow.vendorNumber);
			this.invoiceEditForm.controls["vendorName"].setValue(this.workflowSaveRequest.workflow.vendorName);
			this.invoiceEditForm.controls["isDirectDebitPermission"].setValue(this.workflowSaveRequest.workflow.isDirectDebitPermission);
			this.invoiceEditForm.controls["invoiceType"].setValue(this.workflowSaveRequest.workflow.invoiceType);
			this.invoiceEditForm.controls["discountEnterDate"].setValue(parseDate(this.workflowSaveRequest.workflow.discountEnterDate, 'dd.mm.yyyy'));
			this.invoiceEditForm.controls["discountDeadline"].setValue(this.workflowSaveRequest.workflow.discountDeadline);
			this.invoiceEditForm.controls["discountRate"].setValue(this.workflowSaveRequest.workflow.discountRate);
			this.invoiceEditForm.controls["discountDate"].setValue(parseDate(this.workflowSaveRequest.workflow.discountDate, 'dd.mm.yyyy'));
			this.invoiceEditForm.controls["paymentAmount"].setValue(this.workflowSaveRequest.workflow.paymentAmount);
						
		}
	}
	
	setFormControlValues(){
		
		this.workflowSaveRequest.expireDays = this.invoiceEditForm.controls["expireDays"].value;
		
		this.workflowSaveRequest.workflow.controllerIdentity = this.invoiceEditForm.controls["controllerIdentity"].value; 
		this.workflowSaveRequest.workflow.comments = this.invoiceEditForm.controls["comments"].value; 
		
		this.workflowSaveRequest.workflow.sender = this.invoiceEditForm.controls["sender"].value; 
		this.workflowSaveRequest.workflow.registerNumber = this.invoiceEditForm.controls["registerNumber"].value;  
		this.workflowSaveRequest.workflow.invocieDate = formatDate(this.invoiceEditForm.controls["invocieDate"].value, 'dd.mm.yyyy'); 
		this.workflowSaveRequest.workflow.partnerCode = this.invoiceEditForm.controls["partnerCode"].value; 
		this.workflowSaveRequest.workflow.vendorNumber = this.invoiceEditForm.controls["vendorNumber"].value; 
		this.workflowSaveRequest.workflow.vendorName = this.invoiceEditForm.controls["vendorName"].value; 
		this.workflowSaveRequest.workflow.isDirectDebitPermission = this.invoiceEditForm.controls["isDirectDebitPermission"].value; 
		this.workflowSaveRequest.workflow.invoiceType = this.invoiceEditForm.controls["invoiceType"].value; 
		this.workflowSaveRequest.workflow.discountEnterDate = formatDate(this.invoiceEditForm.controls["discountEnterDate"].value, 'dd.mm.yyyy'); 
		this.workflowSaveRequest.workflow.discountDeadline = this.invoiceEditForm.controls["discountDeadline"].value; 
		this.workflowSaveRequest.workflow.discountRate = this.invoiceEditForm.controls["discountRate"].value; 
		this.workflowSaveRequest.workflow.discountDate = formatDate(this.invoiceEditForm.controls["discountDate"].value, 'dd.mm.yyyy'); 
		this.workflowSaveRequest.workflow.paymentAmount = this.invoiceEditForm.controls["paymentAmount"].value; 
	}
	
	  
	get forms() { return this.invoiceEditForm.controls; }
	
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
	
	removeFile(index){
		this.fileTitles.splice(index, 1);
	}
	
	addFile(){
		var ft :FileTitle = new FileTitle();
		ft.title = "";
		ft.file = null;
		
		this.fileTitles.push(ft);
	}

}
