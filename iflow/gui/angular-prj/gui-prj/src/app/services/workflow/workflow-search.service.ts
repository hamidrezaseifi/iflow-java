import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { LoadingServiceService } from '../loading-service.service';

import { WorkflowSearchFilter, WorkflowListInitialData } from '../../wf-models';


@Injectable({
  providedIn: 'root'
})
export class WorkflowSearchService {

	public searchInitialDataSubject: BehaviorSubject<WorkflowListInitialData> = new BehaviorSubject<WorkflowListInitialData>(null);
	
	loadInitialUrl :string = "/workflow/general/data/initsearch";
	loadUrl :string = "/workflow/general/data/search";
	listInitialData :WorkflowListInitialData = null;

	constructor(
			private http: HttpClient,
			private loadingService: LoadingServiceService,
	) { 
		
		
	}
	

    loadInitialData() {
    	        
    	this.loadingService.showLoading();
    	
        const httpOptions = {
        		  headers: new HttpHeaders({
        		    'Content-Type':  'application/x-www-form-urlencoded',
        		    'Authorization': 'my-auth-token'
        		  })
        		};
        
    	this.http.post(this.loadInitialUrl, new HttpParams(), httpOptions).subscribe(
		        (initialData :WorkflowListInitialData) => {
		        	
		            console.log("GET successful search inital data", initialData);
		            
		            this.listInitialData = <WorkflowListInitialData> JSON.parse(JSON.stringify(initialData));
		            
		            this.searchInitialDataSubject.next(initialData);
		        	
		            
		        },
		        response => {
		        	console.log("Error in read search inital data", response);
		        },
		        () => {
		        	this.searchInitialDataSubject.complete();
		        	this.loadingService.hideLoading();	            
		        }
		    );	       	
    	
    }

}
