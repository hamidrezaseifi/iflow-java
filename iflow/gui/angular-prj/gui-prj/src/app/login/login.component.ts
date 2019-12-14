import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {HttpParams} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry, map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

import { User, LoginResponse } from '../ui-models';
import { GlobalService } from '../helper/global.service';
import { ILoginComponent } from '../_components';
import { AuthenticationService } from '../services';


@Component({ templateUrl: 'login.component.html' })
	export class LoginComponent implements OnInit, ILoginComponent {

	
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
		private http:HttpClient,
		private autService: AuthenticationService,
		private global: GlobalService,
		
	  ) { 	  
		  this.loginResponse = new LoginResponse;
		  
		  
	  }
	  

	  ngOnInit() {
		  this.loginForm = this.formBuilder.group({
	            username: ['admin@iflow.de', Validators.required],
	            password: ['', Validators.required],
	            companyid: ['test-company-1', Validators.required],
	        });
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
  			this.router.navigate(['/']);
		}
		
}