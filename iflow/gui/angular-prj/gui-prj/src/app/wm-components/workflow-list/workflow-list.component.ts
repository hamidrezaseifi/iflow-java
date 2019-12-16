import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';

import { GlobalService } from '../../services/global.service';
import { WorkflowSearchService } from '../../services/workflow/workflow-search.service';

import { WorkflowType, Workflow, WorkflowTypeStep, WorkflowSearchFilter, WorkflowListInitialData } from '../../wf-models';
import { User, GeneralData } from '../../ui-models';

@Component({
  selector: 'app-workflow-list',
  templateUrl: './workflow-list.component.html',
  styleUrls: ['./workflow-list.component.css']
})
export class WorkflowListComponent implements OnInit {
	worlflowTypes		:WorkflowType[] = [];
	resultWorlflows		:Workflow[] = [];
	listInitialData 	:WorkflowListInitialData = new WorkflowListInitialData();



	constructor(
		    private router: Router,
			private global: GlobalService,
			translate: TranslateService,
			private searchService :WorkflowSearchService,
			
	) {
		
		this.router.events.subscribe((evt) => {
		        if (evt instanceof NavigationEnd) {
		        	this.loadInitialData();
		        }
		});
	}
	  
	get isMeAssigned() :boolean{
		if(this.listInitialData && this.listInitialData != null && this.listInitialData.searchFilter != null){
			return this.listInitialData.searchFilter.meAssigned;
		}
		return false;
	}
	set isMeAssigned(assigned :boolean){
		if(this.listInitialData && this.listInitialData != null && this.listInitialData.searchFilter != null){
			this.listInitialData.searchFilter.meAssigned = assigned;
		}
		
	}
	  
	get statusList() :string[]{
		if(this.listInitialData && this.listInitialData != null && this.listInitialData.workflowStatusList != null){
			return this.listInitialData.workflowStatusList;
		}
		return [];
	}
	
	ngOnInit() {
				
		this.loadInitialData();
	
	}
	
	private loadInitialData(){
	 	if(this.searchService.listInitialData !== null){
	 		this.listInitialData = this.searchService.listInitialData;
	 	}
	 	else{
	 		this.subscribeToSearchInitialData();
	 		this.searchService.loadInitialData();
	 	}
		
	}
	
	private subscribeToSearchInitialData(){
		this.searchService.searchInitialDataSubject.subscribe((data : WorkflowListInitialData) => {
	    	
			console.log("set gloabl-data from workflow-create. : ", data);
			//alert("from app-comp: \n" + JSON.stringify(data));
	    	
			if(data && data !== null){
				this.listInitialData = data;
			}
			else{
				this.listInitialData = null;
			}
		  });
	}
	
	reload(){
		
	}
	
	isStatusSelected(wstatus){
		if(this.listInitialData && 
				this.listInitialData != null && 
				this.listInitialData.searchFilter != null && 
				this.listInitialData.searchFilter.statusList != null){
			
			return this.listInitialData.searchFilter.statusList.indexOf(wstatus) > -1;
		}
		return false;
		
	}
	
	toggleStatusSelected(wstatus){
		if(this.listInitialData && 
				this.listInitialData != null && 
				this.listInitialData.searchFilter != null && 
				this.listInitialData.searchFilter.statusList != null){
			
			const index: number = this.listInitialData.searchFilter.statusList.indexOf(wstatus);
		    if (index !== -1) {
		    	this.listInitialData.searchFilter.statusList.splice(index, 1);
		    }
		    else{
		    	this.listInitialData.searchFilter.statusList.push(wstatus);
		    }
	    
		}
		
	}
	
	get debugSearchFilter() :string{
		if(this.listInitialData && 
				this.listInitialData != null && 
				this.listInitialData.searchFilter != null){
			
			return JSON.stringify(this.listInitialData.searchFilter);
		}
		return "";
	}
	
}
