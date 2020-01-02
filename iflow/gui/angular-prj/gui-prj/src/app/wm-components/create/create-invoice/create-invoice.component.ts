import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { DateAdapter } from '@angular/material';
import { Observable, throwError , Subscription } from 'rxjs';
import { StompService, StompState } from '@stomp/ng2-stompjs';
import { Message } from '@stomp/stompjs';
import $ from "jquery";

import { GlobalService } from '../../../services/global.service';
import { InvoiceWorkflowEditService } from '../../../services/workflow/invoice/invoice-workflow-edit.service';
import { LoadingServiceService } from '../../../services/loading-service.service';
import { ErrorServiceService } from '../../../services/error-service.service';
import { InvoiceBaseComponent } from '../../invoice-base.component';

import { User, Department, DepartmentGroup, GeneralData, OcrWord, UploadedFile, UploadedResult } from '../../../ui-models';
import { WorkflowProcessCommand, Workflow, AssignItem, FileTitle, AssignType, WorkflowUploadFileResult, InvoiceType } 
	from '../../../wf-models';
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

	listening :boolean = false;	
		
	private subscription: Subscription;
	private messages: Observable<Message>;
	public subscribed: boolean;
	stompClient = null;
	
	
	uploadedFiles :UploadedFile[] = [];
	
	scanningFileIndex :number = -1;
	scanningFile :UploadedFile = null;
	previewFile :UploadedFile = new UploadedFile;
	
	showOcrDetailsDialog :boolean = false;
	showFilePreviewDialog :boolean = false;

	fileExistsMessage :string = "common.file-exists";
	
	get debugData() :string{
		var ss = formatDate(new Date(), 'dd.mm.yyyy');
		ss += " -- " + parseDate(ss, 'dd.mm.yyyy');
		return ss;
	}
	
	scannedSelectedValues :string[] = [];
	
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
		  	private _stompService: StompService
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

		
		
		translate.get('common.file-exists').subscribe((res: string) => {
        	this.fileExistsMessage =  res;
        });

	}
	
	ngOnInit() {
		
		super.ngOnInit();
		
	}
		
	uploadFile(fileInput: any) {
		
		
		var file = <File>fileInput.target.files[0];
		console.log("file: ", file);
		//alert(file.name);
		if(this.existsUploadedByFileName(file.name)){
			$("#inlineuploadfile")[0].type = "text";
			$("#inlineuploadfile")[0].type = "file";

			this.errorService.showError(this.fileExistsMessage , "");	
			return;
		}
		
		$("#inlineuploadfile")[0].type = "text";
		$("#inlineuploadfile")[0].type = "file";
		
		this.loadingService.showLoading();
		
		this.editService.uploadTempFiles(file).subscribe(
		        (result: UploadedResult) => {		        	
		            console.log("upload invoice file result", result);
		            this.loadingService.hideLoading();
		            
		            if(result.status){
		    			if(result.status === "done"){

		    				var uploaded :UploadedFile = new UploadedFile;
		    				 
			    			uploaded.fileName = result.fileName;
			    			uploaded.scanedPdfPath = result.fileHash;
			    			uploaded.scanedHocrPath = result.hocrFileHash;
			    			uploaded.fileIsPdf = result.isFilePdf;
			    			uploaded.fileIsImage = result.isFileImage;
			    			//uploaded.imageSizeX = result.imageWidth;
			    			//uploaded.imageSizeY = result.imageHeight;
			    			uploaded.uploadResult = result;

			    			this.uploadedFiles.push(uploaded);
		    	            
		    			}
		    			if(result.status === "error" && result.errorMessage){
		    				this.unsubscribe();
		    				this.errorService.showError(result.errorMessage , result.errorDetail);			
		    			}
		    		}		            
		            
		         		            
		            
		            
		        },
		        response => {
		        	console.log("Error in upload invoice file", response);
		        	this.loadingService.hideLoading();
		        },
		        () => {
		        }
		    );	
		

	}
	
	removeUploadedFile(uploaded){
		var index = this.uploadedFiles.indexOf(uploaded);
		if(index > -1){
			this.uploadedFiles.splice(index , 1);
		}
	}
	
	ocrUploadedFile(uploaded){
		
		var index = this.uploadedFiles.indexOf(uploaded);
		if(index > -1){
			this.scanningFileIndex = index;
			this.scanningFile = this.uploadedFiles[index];
			
			this.loadingService.showLoading();
			
			this.subscribe();
	        
			console.log("ocrUploadedFile : ", this.scanningFile);
			
	        this._stompService.publish('/socketapp/ocrprocess', JSON.stringify(uploaded.uploadResult));
		}
		
		
        
	}
	
	showScanResults(uploaded){
		
		var index = this.uploadedFiles.indexOf(uploaded);
		if(index > -1){
			this.scanningFileIndex = index;
			this.scanningFile = this.uploadedFiles[index];
	    	this.showOcrDetailsDialog = true;
	    	
			console.log("showScanResults : ", this.scanningFile);

		}
		
	}
	
	showFilePreview(uploaded){
		
		this.showFilePreviewDialog = false;
		var index = this.uploadedFiles.indexOf(uploaded);
		if(index > -1){
			this.previewFile = this.uploadedFiles[index];
	    	this.showFilePreviewDialog = true;
	    	
			console.log("preview file : ", this.previewFile);

		}

	}
	
	onFilePreviewDialogClosed(closed: boolean) {
		this.showFilePreviewDialog = false;
		
	}
	
	public onRecevieResponse = (message: Message) => {

		if(this.listening === false){
			return;
		}

		var uploaded = this.uploadedFiles[this.scanningFileIndex ];
			
		this.loadingService.hideLoading();
		console.log("Message Received: " , message.body);
		var parsedMessage = JSON.parse(message.body);
		
		if(parsedMessage.status){
			if(parsedMessage.status === "done"){
				this.unsubscribe();

	            if(parsedMessage.words){

	            	this.showOcrDetailsDialog = true;
	            	
	            	this.uploadedFiles[this.scanningFileIndex].foundWords = <OcrWord[]>parsedMessage.words;
	            	this.uploadedFiles[this.scanningFileIndex].isScanned = true;
	            	this.uploadedFiles[this.scanningFileIndex].imageSizeX = parsedMessage.imageWidth;
	            	this.uploadedFiles[this.scanningFileIndex].imageSizeY = parsedMessage.imageHeight;
	    			
	            	console.log("Received Words: " , this.uploadedFiles[this.scanningFileIndex].foundWords);
	            }
	            
			}
			if(parsedMessage.status === "error" && parsedMessage.errorMessage){
				this.unsubscribe();
				this.errorService.showError(parsedMessage.errorMessage , parsedMessage.errorDetail);			
			}
		}
				
	}	
	
	subscribe() {
		
		if (this.subscribed) {
		      this.unsubscribe();
		}

		this.messages = this._stompService.subscribe('/user/socket/ocrprocess');

	    this.subscription = this.messages.subscribe(this.onRecevieResponse);

	    this.setConnected(true);
		this.listening = true;
	}

	unsubscribe() {
		this.listening = false;
	    if (!this.subscribed) {
	      return;
	    }

	    this.subscription.unsubscribe();
	    this.subscription = null;
	    this.messages = null;

	    this.setConnected(false);
	}

	private setConnected(subscribed) {
		this.subscribed = subscribed;
	
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
	
	hideOcrDetails(){
		this.showOcrDetailsDialog = false;
	}
	
	onApplyScannedValues() {
		
		if(this.scannedSelectedValues["invoice-invoicedate"] && this.scannedSelectedValues["invoice-invoicedate"] != ""){
			
			this.invoiceEditForm.controls["invocieDate"].setValue(parseDate(this.scannedSelectedValues["invoice-invoicedate"], 'dd.mm.yyyy'));
			this.invoiceEditForm.controls["discountEnterDate"].setValue(parseDate(this.scannedSelectedValues["invoice-invoicedate"], 'dd.mm.yyyy'));
			//this.invoiceEditForm.controls["discountDate"].setValue(parseDate(this.scannedSelectedValues["invoice-invoicedate"], 'dd.mm.yyyy'));
			
		}
		
		if(this.scannedSelectedValues["invoice-invoicenumber"] && this.scannedSelectedValues["invoice-invoicenumber"] != ""){
			this.invoiceEditForm.controls["registerNumber"].setValue(this.scannedSelectedValues["invoice-invoicenumber"]);
		}
		
		if(this.scannedSelectedValues["invoice-paymentamount"] && this.scannedSelectedValues["invoice-paymentamount"] != ""){
			var foundPayment = this.scannedSelectedValues["invoice-paymentamount"].replace(/\./g, "").replace(",", ".");
			
			if(isNaN(foundPayment) === false){
				var foundPaymentFloat = parseFloat(foundPayment);
				this.invoiceEditForm.controls["paymentAmount"].setValue(foundPaymentFloat);
			}
			
		}
		
		if(this.scannedSelectedValues["invoice-sender"] && this.scannedSelectedValues["invoice-sender"] != ""){
			this.invoiceEditForm.controls["sender"].setValue(this.scannedSelectedValues["invoice-sender"]);
		}
		
		this.showOcrDetailsDialog = false;
	}	

	private findUploadedByFileName(fileName: string): UploadedFile{
		for(var index in this.uploadedFiles){
			if(this.uploadedFiles[index].fileName === fileName){
				return this.uploadedFiles[index];
			}
		}
		return null;
	}

	private existsUploadedByFileName(fileName: string): boolean{
		
		return this.findUploadedByFileName(fileName) !== null;
	}
}
