import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';

import { LoadingServiceService } from '../loading-service.service';
import { HttpHepler } from '../../helper/http-hepler';
import { HttpErrorResponseHelper } from '../../helper/http-error-response-helper';
import { AuthenticationService } from '../../services';

import { CompanyWorkflowtypeItemOcrSetting, GeneralData } from '../../ui-models';

@Injectable({
  providedIn: 'root'
})
export class WorkflowtypePropertySettingService extends HttpErrorResponseHelper {
	listWorkflowTypesUrl :string = "/company/data/readworkflowtypeitemocrsettings";
	updateWorkflowTypesUrl :string = "/company/data/saveworkflowtypeitemocrsettings/";
	listWorkflowTypePtopertiesUrl :string = "/company/data/readworkflowtypeitems/";

	constructor(
			protected http: HttpClient,
			protected loadingService: LoadingServiceService,
			protected router: Router, 
			protected route :ActivatedRoute,
			protected autService: AuthenticationService,
	) { 
		super(router, route, autService);
		
	}
	
	listWorkflowTypes(){
		
	    const httpOptions = { headers: HttpHepler.generateJsonHeader() };
	    
		return this.http.get(this.listWorkflowTypesUrl, httpOptions);	    
		
	};
	
	listWorkflowTypePtoperties(workflowTypeIdentity:string){
		
	    const httpOptions = { headers: HttpHepler.generateJsonHeader() };
	    
		return this.http.get(this.listWorkflowTypePtopertiesUrl + workflowTypeIdentity, httpOptions);	    
		
	};


	updateWorkflowTypes(properties: CompanyWorkflowtypeItemOcrSetting[], workflowTypeIdentity:string){
		
	    const httpOptions = { headers: HttpHepler.generateJsonHeader() };
	    
		return this.http.post(this.updateWorkflowTypesUrl + workflowTypeIdentity, properties, httpOptions);	    
		
	};
	
}
