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


@Component({ templateUrl: 'login.component.html' })
	export class LoginComponent implements OnInit {

	
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

	        // stop here if form is invalid
	        if (this.loginForm.invalid) {
	            return;
	        }

	        this.loading = true;
	        	        
	        const loginData = new HttpParams()
	        .set('username', this.loginForm.controls["username"].value)
	        .set('password', this.loginForm.controls["password"].value)
	        .set('companyid', this.loginForm.controls["companyid"].value);
	        
	        const httpOptions = {
	        		  headers: new HttpHeaders({
	        		    'Content-Type':  'application/x-www-form-urlencoded',
	        		    'Authorization': 'my-auth-token'
	        		  })
	        		};
	        
	        
	        this.http.post("/auth/authenticate", loginData, httpOptions).subscribe(
			        val => {
			            this.loginResponse = <LoginResponse>val;
			            
			            if(this.loginResponse.res === 'ok'){
			            	this.global.loadAllSetting();
			            	this.router.navigate(['/']);
			            }
			            else{
			            	this.failedLogin = true;
			            }
			            
			        },
			        response => {
			            console.log("GET call in error", response);
			            alert("GET call in error: "+ response);
			            this.loginResponse.message = "Error in login!";
			            this.failedLogin = true;
			        },
			        () => {
			            this.loading = false;				            
			        }
			    );	        
			  
	    }	  

}