import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { DateAdapter } from '@angular/material/core';
import { Observable } from 'rxjs';

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
	
	generalDataObs :Observable<GeneralData> = null;
	
	fileTitles : FileTitle[] = [];
			
	selectAssign : boolean[][] = [];

	invoiceTypes : any[] = [];
		
	calcDiscountDate(){
		//alert("calcDiscountDate ---");
		
		var enterDate :Date = this.invoiceEditForm.controls["discountEnterDate"].value;
		var deadline : number= this.invoiceEditForm.controls["discountDeadline"].value;
		
		if(enterDate != null && deadline != null && deadline > 0){
			var date = new Date(enterDate.getFullYear(), enterDate.getMonth(), enterDate.getDate() + deadline);
			this.invoiceEditForm.controls["discountDate"].setValue( formatDate(date, 'dd.mm.yyyy') );
		}

	}
	
	invoiceDateChanges(){
		var enterDate :Date = this.invoiceEditForm.controls["discountEnterDate"].value;
	
		if(enterDate === null && this.invoiceEditForm.controls["invocieDate"].value !== null){
			this.invoiceEditForm.controls["discountEnterDate"].setValue( this.invoiceEditForm.controls["invocieDate"].value );
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
		
		this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
		
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
			discountDate: ["", Validators.required],
			
			paymentAmount: [0, Validators.required],
			
        });

		
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
				
			if( (this.workflowSaveRequest.workflow.discountEnterDate === null || this.workflowSaveRequest.workflow.discountEnterDate === '') 
					&& this.workflowSaveRequest.workflow.invocieDate !== null){
				this.workflowSaveRequest.workflow.discountEnterDate = this.workflowSaveRequest.workflow.invocieDate;
			}
			
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
		this.workflowSaveRequest.workflow.invocieDate = formatDate(this.invoiceEditForm.controls["invocieDate"].value, 'dd.mm.yyyy'); 
		this.workflowSaveRequest.workflow.partnerCode = this.invoiceEditForm.controls["partnerCode"].value; 
		this.workflowSaveRequest.workflow.vendorNumber = this.invoiceEditForm.controls["vendorNumber"].value; 
		this.workflowSaveRequest.workflow.vendorName = this.invoiceEditForm.controls["vendorName"].value; 
		this.workflowSaveRequest.workflow.isDirectDebitPermission = this.invoiceEditForm.controls["isDirectDebitPermission"].value; 
		this.workflowSaveRequest.workflow.invoiceType = this.invoiceEditForm.controls["invoiceType"].value; 
		this.workflowSaveRequest.workflow.discountEnterDate = formatDate(this.invoiceEditForm.controls["discountEnterDate"].value, 'dd.mm.yyyy'); 
		this.workflowSaveRequest.workflow.discountDeadline = this.invoiceEditForm.controls["discountDeadline"].value; 
		this.workflowSaveRequest.workflow.discountRate = this.invoiceEditForm.controls["discountRate"].value; 
		this.workflowSaveRequest.workflow.discountDate = this.invoiceEditForm.controls["discountDate"].value; 
		this.workflowSaveRequest.workflow.paymentAmount = this.invoiceEditForm.controls["paymentAmount"].value; 
	}
	
	  
	get forms() { return this.invoiceEditForm.controls; }
	
	onUsersSelected(assigns: AssignItem[]) {
		this.workflowSaveRequest.assigns = [];
		
		for(var item in assigns){
			var assign = new AssignItem;
			assign.itemIdentity = assigns[item].itemIdentity;
			assign.itemType = assigns[item].itemType;
			
			this.workflowSaveRequest.assigns.push(assign);						
		}
		
	}	

}
