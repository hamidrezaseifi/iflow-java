import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';

import { GlobalService } from '../../../services/global.service';

import { WorkflowType } from '../../../wf-models/workflowtype';
import { User, GeneralData } from '../../../ui-models';

@Component({
  selector: 'app-workflow-create',
  templateUrl: './workflow-create.component.html',
  styleUrls: ['./workflow-create.component.css']
})
export class WorkflowCreateComponent implements OnInit {
	worlflowTypes: WorkflowType[] = [];

  
	constructor(
		    private router: Router,
			private global: GlobalService,
			translate: TranslateService,
			
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
     	if(this.global.loadedGeneralData !== null){
     		this.worlflowTypes = this.global.loadedGeneralData.workflow.worlflowTypes;
     	}
     	else{
     		this.subscribeToGeneralData();
     		this.global.loadAllSetting(null);
     	}
		
	}
	
	private subscribeToGeneralData(){
		this.global.currentSessionDataSubject.subscribe((data : GeneralData) => {
	    	
			console.log("set gloabl-data from workflow-create. appIsLogged: ");
			//alert("from app-comp: \n" + JSON.stringify(data));
	    	
			if(data && data !== null){
				
				var value = data.isLogged + "";
				
				if(value === "true" === true){
	 	 			this.worlflowTypes = data.workflow.worlflowTypes;
	 	 	  		
				}
				else{
					this.worlflowTypes =[];
				}
		 	  		
			}
			else{
				this.worlflowTypes =[];
			}
		  });
	}

}

