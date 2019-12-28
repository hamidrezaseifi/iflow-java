import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { DateAdapter } from '@angular/material';

import { GlobalService } from '../../../services/global.service';
import { InvoiceWorkflowEditService } from '../../../services/workflow/invoice/invoice-workflow-edit.service';
import { LoadingServiceService } from '../../../services/loading-service.service';
import { ErrorServiceService } from '../../../services/error-service.service';
import { InvoiceBaseComponent } from '../../invoice-base.component';

import { User, Department, DepartmentGroup, GeneralData } from '../../../ui-models';
import { WorkflowProcessCommand, Workflow, AssignItem, FileTitle, AssignType, WorkflowUploadFileResult, InvoiceType } from '../../../wf-models';
import { InvoiceWorkflowSaveRequest } from '../../../wf-models/invoice-workflow-save-request';
import { InvoiceWorkflowSaveRequestInit } from '../../../wf-models/invoice-workflow-save-request-init';
import { InvoiceTypeControllValidator } from '../../../custom-validators/invoice-type-controll-validator';
import { GermanDateAdapter, parseDate, formatDate } from '../../../helper';

@Component({
  selector: 'app-create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.css'],
  providers: [{provide: DateAdapter, useClass: GermanDateAdapter}, InvoiceWorkflowEditService]
})
export class CreateInvoiceComponent extends InvoiceBaseComponent implements OnInit {

	ocrScanFile: File;
	showUploading :boolean = false;

	uplaodingMessage :string = "";
	uplaodingFileName :string = "...";

	uplaodingMessageUploading :string = "";
	uplaodingMessageFileAnalysing :string = "";
	uplaodingMessageShowResult :string = "";
	
	
	intervalId = 0;
	
	intervalValue = 0;


	get debugData() :string{
		var ss = formatDate(new Date(), 'dd.mm.yyyy');
		ss += " -- " + parseDate(ss, 'dd.mm.yyyy');
		return ss;
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
		super(router,
				global,
				translate,
				editService,
				loadingService,
				http,
				errorService,
			  	formBuilder,
			  	dateAdapter);
		
		this.router.events.subscribe((evt) => {
			if (evt instanceof NavigationEnd) {
		    	this.loadInitialData();
			}
		});

		translate.get('common.uploading').subscribe((res: string) => {
        	this.uplaodingMessageUploading =  res;
        });
		translate.get('common.file-analysing').subscribe((res: string) => {
        	this.uplaodingMessageFileAnalysing =  res;
        });
		translate.get('common.show-result').subscribe((res: string) => {
        	this.uplaodingMessageShowResult =  res;
        });
	}
	
	ngOnInit() {
		
		super.ngOnInit();
		
	}
	
	scanOcrProgress(fileInput: any) {
		
		this.ocrScanFile = <File>fileInput.target.files[0];
		this.uplaodingFileName = this.ocrScanFile.name;
	}
	
	uploadOcrScanFile(){
		
		this.intervalValue = 0;
		this.showUploading = true;
		this.uplaodingMessage = this.uplaodingMessageUploading + " ...";
		
		//uplaodingMessageUploading :string = "";
		//uplaodingMessageFileAnalysing :string = "";
		//uplaodingMessageShowResult :string = "";

		
		/*this.intervalId = setInterval(() =>{ 

			this.intervalValue += 10;
			
			if(this.intervalValue >= 70){
				clearInterval(this.intervalId);
				//this.showUploading = false;
			}
			
			
		}, 3000);*/
		
		this.editService.uploadOcrScanFiles(this.ocrScanFile).subscribe(
		        (result) => {		        	
		            console.log("upload invoice file result", result);
		            
		            this.intervalValue += 33;
		            this.uplaodingMessage = this.uplaodingMessageFileAnalysing + " ...";
		            
		            
		            
		        },
		        response => {
		        	console.log("Error in upload invoice file", response);
		        	this.showUploading = false;
		        	this.errorService.showErrorResponse(response);
		        },
		        () => {
		        	//this.intervalValue = 0;
		        	//this.showUploading = false;     
		        }
		    );	   
	}
	
	
	protected loadInitialData(){
		
	 	super.loadInitialData();

	 	if(this.editService.workflowSaveRequestInit !== null){
	 		this.workflowSaveRequest = this.editService.workflowSaveRequestInit.workflowSaveRequest;
	 		this.setToControlValues();
	 	}
	 	else{
	 		this.subscribeToSearchInitialData();
	 		this.editService.loadCreateInitialData();
	 	}
		 	
	}

	
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

	save(){
		
		this.setFormControlValues();
		//return;
		
		this.loadingService.showLoading();
		
		if(this.fileTitles.length > 0){
			this.editService.uploadFiles(this.fileTitles).subscribe(
			        (result :WorkflowUploadFileResult) => {		        	
			            console.log("Create workflow upload file result", result);
			            
			            this.workflowSaveRequest.sessionKey = result.sessionKey;
			            
			            this.createWorkflowData();      	
			            
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
	        
	        this.createWorkflowData();
		}
	
	}
	
	private createWorkflowData(){
		
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

}
