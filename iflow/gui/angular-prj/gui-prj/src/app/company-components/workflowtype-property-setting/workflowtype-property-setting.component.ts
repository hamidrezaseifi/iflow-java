import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { DateAdapter } from '@angular/material/core';
import { Observable } from 'rxjs';
import $ from "jquery";

import { GlobalService } from '../../services/global.service';
import { WorkflowtypePropertySettingService } from '../../services/company/workflowtype-property-setting.service';
import { LoadingServiceService } from '../../services/loading-service.service';
import { ErrorServiceService } from '../../services/error-service.service';
import { GermanDateAdapter, parseDate, formatDate } from '../../helper';
import { UserAccessTypeControllValidator } from '../../custom-validators/user-access-type-controll-validator';

import { CompanyWorkflowtypeItemOcrSetting, GeneralData } from '../../ui-models';
import { WorkflowType } from '../../wf-models/workflowtype';

@Component({
  selector: 'app-workflowtype-property-setting',
  templateUrl: './workflowtype-property-setting.component.html',
  styleUrls: ['./workflowtype-property-setting.component.css']
})
export class WorkflowtypePropertySettingComponent implements OnInit {

	workflowtypeItemOcrSettings :CompanyWorkflowtypeItemOcrSetting[][] = [];
	//workflowtypeItemNames :string[][] = [];
	
	worlflowTypes: WorkflowType[] = [];

	selectedWorlflowType :WorkflowType = null;
	
	selectedWorlflowTypeChanged :boolean = false;

	generalDataObs :Observable<GeneralData> = null;
	
	showList: boolean = true;

	showDetail: boolean = false;

	constructor(
		    private router: Router,
			private global: GlobalService,
			translate: TranslateService,
			private editService :WorkflowtypePropertySettingService,
			private loadingService: LoadingServiceService,
			private errorService: ErrorServiceService,
			private route :ActivatedRoute,
			private formBuilder: FormBuilder,
			private dateAdapter: DateAdapter<Date>,
			
	) {
		this.dateAdapter.setLocale('de');
		
       /* translate.get('user-delete-message').subscribe((res: string) => {
        	this.deleteMessageBase = res;
        });*/

        
		this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
		this.generalDataObs.subscribe(data => {
			   
			this.worlflowTypes = data.workflow.worlflowTypes;
			
			for(var id in this.worlflowTypes){
				var type:WorkflowType = this.worlflowTypes[id];
				//this.workflowtypeItemNames[type.identity] = null;
				
				if(this.workflowtypeItemOcrSettings[type.identity] === undefined){
					this.workflowtypeItemOcrSettings[type.identity] = [];
				}
			}
		});
		
	}

	ngOnInit() {
		
		
		this.global.loadAllSetting(null);
		
		this.reload();
	}

	debug():string{
		
		return JSON.stringify(this.workflowtypeItemOcrSettings);
	}
	
	reload() {
		this.loadingService.showLoading();
		
		this.editService.listWorkflowTypes().subscribe(
	        (results :CompanyWorkflowtypeItemOcrSetting[][]) => {
	        	
	            console.log("CompanyWorkflowtypeItemOcrSetting list", results);
	        	
	            this.workflowtypeItemOcrSettings = results;
	        },
	        response => {
	        	console.log("Error in get CompanyWorkflowtypeItemOcrSetting list", response);
	        	this.loadingService.hideLoading();	 
	        	this.errorService.showErrorResponse(response);
	        },
	        () => {
	        	
	        	this.loadingService.hideLoading();	            
	        }
		);	       	
	}
	
	showWorkflowType(type :WorkflowType){
		this.selectedWorlflowType = type;

		if(this.workflowtypeItemOcrSettings[type.identity] === undefined){
			this.workflowtypeItemOcrSettings[type.identity] = [];
		}
		
		/*if(this.workflowtypeItemNames[type.identity] === null){
			
			this.reloadSelectedWorkflowTypeProprties();
		}*/
		
		this.showList = false;
		this.showDetail = true;
		this.selectedWorlflowTypeChanged = false;
	}
	
	/*reloadSelectedWorkflowTypeProprties(){
		
		this.loadingService.showLoading();
		
		this.editService.listWorkflowTypePtoperties(this.selectedWorlflowType.identity).subscribe(
	        (results :string[]) => {
	        	
	            console.log("WorkflowtypeItemName list", results);
	        	
	            this.workflowtypeItemNames[this.selectedWorlflowType.identity] = results;
	            
	            for(var id in results){
					var name = results[id];
					
					if(this.workflowtypeItemOcrSettings[this.selectedWorlflowType.identity][name] === undefined){
						var prop:CompanyWorkflowtypeItemOcrSetting = new CompanyWorkflowtypeItemOcrSetting();
						prop.workflowIdentity = this.selectedWorlflowType.identity;
						prop.propertyName = name;
						prop.value = "";
						prop.status = 1;
						prop.version = 1;
						
						this.workflowtypeItemOcrSettings[this.selectedWorlflowType.identity][name] = prop;
						
						//alert(name + " created :" + JSON.stringify(prop));
						//alert(name + " created :" + JSON.stringify(this.workflowtypeItemOcrSettings[this.selectedWorlflowType.identity][name]));
					}
					
				}
	            
	        },
	        response => {
	        	console.log("Error in get WorkflowtypeItemName list", response);
	        	this.loadingService.hideLoading();	 
	        	this.errorService.showErrorResponse(response);
	        },
	        () => {
	        	
	        	this.loadingService.hideLoading();	            
	        }
		);	 					
	}*/
	
	closeWorkflowType(){

		this.showList = true;
		this.showDetail = false;
		this.selectedWorlflowTypeChanged = false;
		this.reload();
	}
	
	setWorkflowtypeItemOcrSettings(identity:string, name:string, newVal:string){
		
		for(var id in this.workflowtypeItemOcrSettings[identity]){
			
			var prop:CompanyWorkflowtypeItemOcrSetting = this.workflowtypeItemOcrSettings[identity][id];
		
			if(prop.propertyName === name){
				prop.value = newVal;
			}
		}
		
		//this.workflowtypeItemOcrSettings[identity][name].value = newVal;
		this.selectedWorlflowTypeChanged = true;
	}
	
	saveWorkflowType(){
		
		
		this.loadingService.showLoading();
		
		this.editService.updateWorkflowTypes(this.workflowtypeItemOcrSettings[this.selectedWorlflowType.identity], 
				this.selectedWorlflowType.identity).subscribe(
	        (results :CompanyWorkflowtypeItemOcrSetting[][]) => {
	        	
	            console.log("Update CompanyWorkflowtypeItemOcrSetting result list", results);
	        	
	            this.workflowtypeItemOcrSettings = results;
	            
	            this.showList = true;
	    		this.showDetail = false;
	    		this.selectedWorlflowTypeChanged = false;
	    		
	    		this.reload();
	    		
	        },
	        response => {
	        	console.log("Error in Update CompanyWorkflowtypeItemOcrSetting list", response);
	        	this.loadingService.hideLoading();	 
	        	this.errorService.showErrorResponse(response);
	        },
	        () => {
	        	
	        	this.loadingService.hideLoading();	            
	        }
		);	   
		
		
		//this.reload();
	}
	
}
