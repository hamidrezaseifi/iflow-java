import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';

import { LoadingServiceService } from '../loading-service.service';
import { HttpHepler } from '../../helper/http-hepler';
import { HttpErrorResponseHelper } from '../../helper/http-error-response-helper';
import { AuthenticationService } from '../../services';

import { User } from '../../ui-models';

@Injectable({
  providedIn: 'root'
})
export class UserEditService extends HttpErrorResponseHelper {

	loadUsersUrl :string = "/users/data/list";
	createUsersUrl :string = "/users/data/create";
	updateUsersUrl :string = "/users/data/update";
	deleteUsersUrl :string = "/users/data/delete";
 
	constructor(
			protected http: HttpClient,
			protected loadingService: LoadingServiceService,
			protected router: Router, 
			protected route :ActivatedRoute,
			protected autService: AuthenticationService,
	) { 
		super(router, route, autService);
		
	}
	
	listUsers(){
		
	    const httpOptions = { headers: HttpHepler.generateJsonHeader() };
	    
		return this.http.get(this.loadUsersUrl, httpOptions);	    
		
	};
	
	createUser(user: User){
		
	    const httpOptions = { headers: HttpHepler.generateJsonHeader() };
	    
		return this.http.post(this.createUsersUrl, user, httpOptions);	    
		
	};
	
	updateUser(user: User){
		
	    const httpOptions = { headers: HttpHepler.generateJsonHeader() };
	    
		return this.http.post(this.updateUsersUrl, user, httpOptions);	    
		
	};
	
	deleteUser(user: User){
		
	    const httpOptions = { headers: HttpHepler.generateJsonHeader() };
	    
		return this.http.post(this.deleteUsersUrl, user, httpOptions);	    
		
	};
}
