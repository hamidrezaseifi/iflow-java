import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { User, LoginResponse, GeneralData } from '../ui-models';
import { ILoginComponent } from '../_components';
import { GlobalService } from '../services/global.service';
import { LoadingServiceService } from './loading-service.service';

@Injectable({ providedIn: 'root' })
export class AuthenticationService implements CanActivate{
    private currentUserSubject: BehaviorSubject<User>;
    isLoggedIn :boolean = false;
    
    constructor(
    		private http: HttpClient,
    		private global: GlobalService,
    		private router: Router,
    		private loadingService: LoadingServiceService,
    ) {
        this.currentUserSubject = new BehaviorSubject<User>(null);
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    public get isLogedIn(): boolean {
        return this.currentUserSubject.value != null;
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
		        	
		        	this.currentUserSubject.next(loginResponse.user);
		        	this.currentUserSubject.complete();
		        	this.isLoggedIn = true;
		        	loginComponent.processLoginResult(<LoginResponse>val);
		            
		        },
		        response => {
		        	this.currentUserSubject.next(null);
		        	this.currentUserSubject.complete();
		        	this.isLoggedIn = false;
		        	loginComponent.processFailedResult(response);
		        },
		        () => {
		        	loginComponent.processEndLoading();		            
		        }
		    );	       	
    	
    }

    checkLoginState(returnUrl :string, router: Router,) {
    	
    	this.loadingService.showLoading();
    	this.global.loadAllSettingObserv().subscribe(
		        (generalData :GeneralData) => {
		            console.log("GET call successful generaldata", generalData);
		            
					var value = generalData.isLogged + "";
					
		            if(value === "true" && generalData.user){
		            	
		            	this.isLoggedIn = true;
		            	this.currentUserSubject.next(generalData.user.currentUser);
			        	this.currentUserSubject.complete();
			        	
			        	this.global.setGeneralData(generalData);
			        	
			        	//alert("from authentication- redirect to : " + returnUrl + ": \n" + JSON.stringify(generalData));
			        	
		            	router.navigate([returnUrl]);
		            }
		            else{
		            	this.isLoggedIn = false;
		            	this.currentUserSubject.next(null);
			        	this.currentUserSubject.complete();
			        	
		            	//alert("from authentication- redirect to login : \n" + JSON.stringify(generalData));
		            	
		            	router.navigate(['auth/login'], { queryParams: { returnUrl: returnUrl } });
		            }
		        	
		        },
		        response => {
		            console.log("Error in read menu list", response);
	            	this.isLoggedIn = false;
	            	this.currentUserSubject.next(null);
		        	this.currentUserSubject.complete();

		            router.navigate(['auth/login'], { queryParams: { returnUrl: returnUrl } });
		        },
		        () => {
		            
		            this.loadingService.hideLoading();
		        }
		); 	
    	
    }

    logout() {
        
        this.global.clear();
        this.currentUserSubject.next(null);
        this.currentUserSubject.complete();
        window.location.assign("/logout");
    }
    
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    	
    	//alert("check authentication: isLoggedIn: " + this.isLoggedIn);
    	
        if (this.isLoggedIn === true) {
        	        	
            return true;
        }

        this.checkLoginState(state.url, this.router);
        
        // not logged in so redirect to login page with the return url
        //this.router.navigate(['auth/login'], { queryParams: { returnUrl: state.url } });
        return false;
    }    

}