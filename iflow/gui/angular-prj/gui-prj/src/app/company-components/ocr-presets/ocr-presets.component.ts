import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { FormBuilder } from '@angular/forms';
import { DateAdapter } from '@angular/material/core';
import { Observable } from 'rxjs';

import { GlobalService } from '../../services/global.service';
import { OcrPresetsService } from '../../services/company/ocr-presets.service';
import { LoadingServiceService } from '../../services/loading-service.service';
import { ErrorServiceService } from '../../services/error-service.service';

import { CompanyWorkflowtypeItemOcrSettingPreset, CompanyWorkflowtypeItemOcrSettingPresetItem, GeneralData } from '../../ui-models';
import { WorkflowType } from '../../wf-models/workflowtype';

@Component({
  selector: 'app-ocr-presets',
  templateUrl: './ocr-presets.component.html',
  styleUrls: ['./ocr-presets.component.css']
})
export class OcrPresetsComponent implements OnInit {

	displayedColumns = ['preset-name', 'workflow-type', 'preset-status', 'actions'];

	ocrSettingPresets : CompanyWorkflowtypeItemOcrSettingPreset[] = [];

	ocrTypeList :any[] = [];

	worlflowTypes: WorkflowType[] = [];
	worlflowTypeItems: string[][] = [];

  selectedPreset :CompanyWorkflowtypeItemOcrSettingPreset = new CompanyWorkflowtypeItemOcrSettingPreset();
  selectedPresetItems :CompanyWorkflowtypeItemOcrSettingPresetItem[] = [];
	
	selectedPresetChanged :boolean = false;

	generalDataObs :Observable<GeneralData> = null;
	
  showEditDialog: boolean = false;

  createNewPreset: boolean = false;
	newPresetTitle :string = "";
	
	showTextListDialog :boolean = false;
	
	textSeparator :string = ";";
	selectedTextToMakeList :string = "";
	selectedPropertyName :string= "";

	constructor(
		    private router: Router,
			private global: GlobalService,
			translate: TranslateService,
			private editService :OcrPresetsService,
			private loadingService: LoadingServiceService,
			private errorService: ErrorServiceService,
			private route :ActivatedRoute,
			private formBuilder: FormBuilder,
			private dateAdapter: DateAdapter<Date>,
			
	) {
		this.dateAdapter.setLocale('de');
		
    translate.get('ocr-preset.new-preset').subscribe((res: string) => {
    	this.newPresetTitle = res;
    });

    for(var type=0; type<3; type++){
      translate.get('ocr-preset.ocrtype-' + type).subscribe((res: string) => {
      	this.ocrTypeList.push({value: type, title: res});
      });
    }
    
        
		this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
		this.generalDataObs.subscribe(data => {
			   
			this.worlflowTypes = data.workflow.worlflowTypes;
			
			for(var id in this.worlflowTypes){
				var type:WorkflowType = this.worlflowTypes[id];
				//this.workflowtypeItemNames[type.identity] = null;
				
				if(this.ocrSettingPresets[type.identity] === undefined){
					this.ocrSettingPresets[type.identity] = [];
				}
			}
		});
		
	}

	ngOnInit() {
		
		
		this.global.loadAllSetting(null);
		
		this.reload();
	}

	debug():string{
		
		return JSON.stringify(this.ocrSettingPresets);
	}
	
	reload() {
		this.loadingService.showLoading();
		
		this.editService.listPresets().subscribe(
	        (results :CompanyWorkflowtypeItemOcrSettingPreset[]) => {
	        	
	            console.log("CompanyWorkflowtypeItemOcrSetting list", results);
	        	
	            this.ocrSettingPresets = results;
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
	
	addPreset(){
	  this.selectedPreset = new CompanyWorkflowtypeItemOcrSettingPreset();
	  this.selectedPreset.presetName = this.newPresetTitle;
	  
		this.selectedPresetItems = this.selectedPreset.items;
		
		this.showEditDialog = true;
		this.selectedPresetChanged = true;
	  this.createNewPreset = true;
	}
	
	editPreset(preset :CompanyWorkflowtypeItemOcrSettingPreset){
	  
	  this.selectedPreset = JSON.parse(JSON.stringify(preset))

	  this.verifyWorlflowTypeItems(this.selectedPreset.workflowTypeIdentity);
	  
		this.selectedPresetItems = preset.items;
		
		this.showEditDialog = true;
		this.selectedPresetChanged = false;
		this.createNewPreset = false;
	}
	
	showPreset(preset :CompanyWorkflowtypeItemOcrSettingPreset){
	  
	  this.selectedPreset = JSON.parse(JSON.stringify(preset))

	  this.verifyWorlflowTypeItems(this.selectedPreset.workflowTypeIdentity);
	  
		this.selectedPresetItems = preset.items;
		
		this.showEditDialog = false;
		this.selectedPresetChanged = false;
		this.createNewPreset = false;
	}
	
	deletePreset(preset :CompanyWorkflowtypeItemOcrSettingPreset){
	  
	  this.selectedPreset = JSON.parse(JSON.stringify(preset))

	  this.verifyWorlflowTypeItems(this.selectedPreset.workflowTypeIdentity);
	  
		this.selectedPresetItems = preset.items;
		
		this.showEditDialog = false;
		this.selectedPresetChanged = false;
		this.createNewPreset = false;
	}
	
	hideEditPresetDialog(){

		this.showEditDialog = false;
		this.selectedPresetChanged = false;
	}
	
	setPresetName(newVal:string){
	  this.selectedPreset.presetName = newVal;
	}
	
	setPresetWorkflowIdentity(newVal:string){
	  this.selectedPreset.workflowTypeIdentity = newVal;
	  
	  this.verifyWorlflowTypeItems(newVal);
	}
	
	verifyWorlflowTypeItems(workflowTypeIdentity: string){
		if(this.worlflowTypeItems[workflowTypeIdentity] === undefined){
	    
	    this.loadingService.showLoading();
			
			this.editService.listWorkflowTypeItems(workflowTypeIdentity).subscribe(
		        (results :string[]) => {
		        	
		            console.log("Workflowtype Items for " + workflowTypeIdentity, results);
		        	
		            this.worlflowTypeItems[workflowTypeIdentity] = results;
		                
		            this.selectedPresetItems = this.resetPresetItems(this.selectedPreset);
		        },
		        response => {
		        	console.log("Error in get Workflowtype Items for " + workflowTypeIdentity, response);
		        	this.loadingService.hideLoading();	 
		        	this.errorService.showErrorResponse(response);
		        },
		        () => {
		        	
		        	this.loadingService.hideLoading();	            
		        }
			);	   
			
	  }
	}
	
	resetPresetItems(preset :CompanyWorkflowtypeItemOcrSettingPreset): CompanyWorkflowtypeItemOcrSettingPresetItem[]{
	  //this.selectedPreset = new CompanyWorkflowtypeItemOcrSettingPreset();
	  
	  var items: CompanyWorkflowtypeItemOcrSettingPresetItem[] = [];
	  
	  for(var index in this.worlflowTypeItems[preset.workflowTypeIdentity]){
	  	var itemName = this.worlflowTypeItems[preset.workflowTypeIdentity][index];  
	  	var item :CompanyWorkflowtypeItemOcrSettingPresetItem = this.findItemByName(preset, itemName);
	  	if(item === null){
	  	  item = new CompanyWorkflowtypeItemOcrSettingPresetItem();
	  	  item.propertyName = itemName;
	  	  item.value = "";
	  	  item.ocrType = 0;
	  	}
	  	items.push(item);
	  }
	  
	  return items;
	  
		//this.selectedPresetItems = this.selectedPreset.items;
	}
	
	private findItemByName(preset :CompanyWorkflowtypeItemOcrSettingPreset, propertyName: string)
		:CompanyWorkflowtypeItemOcrSettingPresetItem{
	  for(var index in preset.items){
	    if(preset.items[index].propertyName === propertyName){
	      return preset.items[index];
	    }
	  }
	  return null;
	}
	
	setPresetItemValue(name:string, newVal:string){
		
	  for(var index in this.selectedPresetItems){
	    if(this.selectedPresetItems[index].propertyName === name){
	      this.selectedPresetItems[index].value = newVal;
	      this.selectedPresetChanged = true;
	      break;
	    }
	  }

		
	}
	
	setPresetItemOcrType(name:string, newVal:number){
		
	  for(var index in this.selectedPresetItems){
	    if(this.selectedPresetItems[index].propertyName === name){
	      this.selectedPresetItems[index].ocrType = newVal;
	      this.selectedPresetChanged = true;
	      break;
	    }
	  }

		
	}
	
	savePreset(){
		
	  this.selectedPreset.items = this.selectedPresetItems;
	  
		this.loadingService.showLoading();
		
		this.editService.updatePreset(this.selectedPreset).subscribe(
	        (results :CompanyWorkflowtypeItemOcrSettingPreset[]) => {
	        	
	            console.log("Update CompanyWorkflowtypeItemOcrSetting result list", results);
	        	
	            this.ocrSettingPresets = results;
	            
	            this.showEditDialog = false;
    	    		this.selectedPresetChanged = false;
    	    		
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
	
	selectValueList(prop:CompanyWorkflowtypeItemOcrSettingPresetItem){
		this.selectedTextToMakeList = prop.value;
		this.selectedPropertyName = prop.propertyName;
		
		this.showTextListDialog = true;
	}
	
	selectedTextChanged(text:string){

		this.selectedTextToMakeList = text;
	}
	
	applySelectexTextChanged(){

	  for(var index in this.selectedPresetItems){
	    if(this.selectedPresetItems[index].propertyName === this.selectedPropertyName){
	      this.selectedPresetItems[index].value = this.selectedTextToMakeList;
	      this.selectedPresetChanged = true;
	      break;
	    }
	  }

		this.showTextListDialog = false;
	}
	
	hideTextListDialog(){
		this.showTextListDialog = false;
	}
	
	getWorkflowTypeTitle(identity:string):string{
	  
	  for(var index in this.worlflowTypes){
	    if(this.worlflowTypes[index].identity === identity){
	      return this.worlflowTypes[index].title;
	    }
	  }
	  return "";
	}
	
	getSelectedPresetName(): string{
	  return this.createNewPreset ? this.newPresetTitle : this.selectedPreset.presetName;
	}

	isSelectedPresetValid():boolean{
	  return this.selectedPreset.presetName !== "" && this.selectedPreset.workflowTypeIdentity !== "";
	}
	
	

}