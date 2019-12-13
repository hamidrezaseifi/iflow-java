import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

import { User, LoginResponse } from '../ui-models';
import { ILoginComponent } from '../_components/ilogincomponent';
import { GlobalService } from '../helper/global.service';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
    //public currentUser: Observable<User>;
    //public currentUser: User;

    constructor(
    		private http: HttpClient,
    		private global: GlobalService,
    ) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        //this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
        //return this.currentUser;
    }

    public get isLogedIn(): boolean {
        return this.currentUserSubject.value != null;
        //return this.currentUser;
    }

    login(username, password, companyid, loginComponent: ILoginComponent) {
    	
    	const loginData = new HttpParams()
        .set('username', username)
        .set('password', password)
        .set('companyid', companyid);
        
        const httpOptions = {
        		  headers: new HttpHeaders({
        		    'Content-Type':  'application/x-www-form-urlencoded',
        		    'Authorization': 'my-auth-token'
        		  })
        		};
        
    	this.http.post("/auth/authenticate", loginData, httpOptions).subscribe(
		        val => {
		        	var loginResponse :LoginResponse = <LoginResponse>val;
		        	localStorage.setItem('currentUser', JSON.stringify(loginResponse.user));
		        	this.currentUserSubject.next(loginResponse.user);
		        	this.currentUserSubject.complete();
		        	//this.global.loadAllSetting();
		        	loginComponent.processLoginResult(<LoginResponse>val);
		            
		        },
		        response => {
		        	this.currentUserSubject.next(null);
		        	this.currentUserSubject.complete();
		        	loginComponent.processFailedResult(response);
		        },
		        () => {
		        	loginComponent.processEndLoading();		            
		        }
		    );	       	
    	
    }

    logout() {
        localStorage.removeItem('currentUser');
        this.global.clear();
        this.currentUserSubject.next(null);
    }
}