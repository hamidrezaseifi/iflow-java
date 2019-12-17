import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { LoadingServiceService } from '../loading-service.service';

import { WorkflowProcessCommand, Workflow, AssignItem } from '../../wf-models';
import { WorkflowSaveRequest } from '../../wf-models/workflow-save-request';

@Injectable({
  providedIn: 'root'
})
export class WorkflowEditService {

	public workflowSaveRequestSubject: BehaviorSubject<WorkflowSaveRequest> = new BehaviorSubject<WorkflowSaveRequest>(null);

	workflowSaveRequest :WorkflowSaveRequest = null;

	constructor(
			private http: HttpClient,
			private loadingService: LoadingServiceService,
	) { 
		
		
	}
	
	
	loadCreateInitialData(){
		
	}
}
