import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd, ActivatedRoute  } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {HttpParams} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry, map } from 'rxjs/operators';
import {TranslateService} from '@ngx-translate/core';

import { User, LoginResponse } from '../ui-models';
import { GlobalService } from '../services/global.service';
import { ILoginComponent } from '../_components';
import { AuthenticationService } from '../services';


@Component({ templateUrl: 'login.component.html' })
	export class LoginComponent implements OnInit, ILoginComponent {

	returnUrl :string = "";
	loginForm: FormGroup;
	loading = false;
	submitted = false;
	loginResponse: LoginResponse;
	testparam:object;
	loginMessage:string;
	failedLogin = false;
	
	  constructor(
	  	private formBuilder: FormBuilder,
		private route: ActivatedRoute,
		private router: Router,
		private autService: AuthenticationService,
		private global: GlobalService,
		translate: TranslateService,
	  ) { 	  
		  this.loginResponse = new LoginResponse;		  
	        translate.setDefaultLang('de');
	        translate.use('de');
	        
			this.router.events.subscribe((evt) => {
				if (evt instanceof NavigationEnd) {
				}
			});
	        
		  
	  }
	  
//returnUrl
	  ngOnInit() {
		  this.loginForm = this.formBuilder.group({
	            username: ['admin@iflow.de', Validators.required],
	            password: ['', Validators.required],
	            companyid: [localStorage.getItem('companyId'), Validators.required],
	        });
		  
		  	this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
		  
	  }
	  
	  get forms() { return this.loginForm.controls; }
	  
	  onSubmit() {
	        this.submitted = true;
	        this.failedLogin = false;

	        if (this.loginForm.invalid) {
	            return;
	        }

	        this.loading = true;
	        	        
	        this.autService.login(
	        		this.loginForm.controls["username"].value,
	        		this.loginForm.controls["password"].value,
	        		this.loginForm.controls["companyid"].value,
	        		this
	        		);
	    }	  
	  
	  
	  	processLoginResult(loginResponse: LoginResponse){
            
	  		this.loginResponse = loginResponse;
	  		
            if(this.loginResponse.res === 'ok'){
            	
            	localStorage.setItem('companyId', this.loginForm.controls["companyid"].value);
            	this.global.loadAllSetting(this);
            	
            }
            else{
            	this.failedLogin = true;
            }
		}
		
		processFailedResult(responseObj: Object){
			console.log("GET call in error", responseObj);
            alert("GET call in error: "+ responseObj);
            this.loginResponse.message = "Error in login!";
            this.failedLogin = true;
		}
		
		processEndLoading(){
			this.loading = false;		
		}
	  
		finishGeneralDataLoading(){
  			this.router.navigate([this.returnUrl]);
		}
		
}