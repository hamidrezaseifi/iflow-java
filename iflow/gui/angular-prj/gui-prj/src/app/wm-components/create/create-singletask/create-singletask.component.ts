import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';

import { GlobalService } from '../../../services/global.service';
import { WorkflowEditService } from '../../../services/workflow/workflow-edit.service';
import { LoadingServiceService } from '../../../services/loading-service.service';

import { WorkflowProcessCommand, Workflow, AssignItem } from '../../../wf-models';
import { WorkflowSaveRequest } from '../../../wf-models/workflow-save-request';

@Component({
  selector: 'app-create-singletask',
  templateUrl: './create-singletask.component.html',
  styleUrls: ['./create-singletask.component.css']
})
export class CreateSingletaskComponent implements OnInit {

	workflowSaveRequest :WorkflowSaveRequest = null;


	showDebug : boolean = false;


	constructor(
		    private router: Router,
			private global: GlobalService,
			translate: TranslateService,
			private editService :WorkflowEditService,
			private loadingService: LoadingServiceService,
			
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
	 	if(this.editService.workflowSaveRequest !== null){
	 		this.workflowSaveRequest = this.editService.workflowSaveRequest;
	 	}
	 	else{
	 		this.subscribeToSearchInitialData();
	 		this.editService.loadCreateInitialData();
	 	}
		
	}
	
	private subscribeToSearchInitialData(){
		this.editService.workflowSaveRequestSubject.subscribe((data : WorkflowSaveRequest) => {
	    	
			console.log("set gloabl-data from workflow-create. : ", data);
			//alert("from app-comp: \n" + JSON.stringify(data));
	    	
			if(data && data !== null){
				this.workflowSaveRequest = data;
			}
			else{
				this.workflowSaveRequest = null;
			}
		  });
	}
	
}
