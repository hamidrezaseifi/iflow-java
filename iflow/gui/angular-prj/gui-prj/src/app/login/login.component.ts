import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {HttpParams} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry, map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';


interface LoginResponse {
	timestamp: string;
	exception:string;
	message:string;
	res:string;
}

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
		
	  ) { 
		  
		  
	  }
	  

	  ngOnInit() {
		  this.loginForm = this.formBuilder.group({
	            username: ['admin@iflow.de', Validators.required],
	            password: ['', Validators.required],
	            companyid: ['test-company-1', Validators.required],
	        });

		  
		  
		  

	  }
	  
	  get forms() { return this.loginForm.controls; }
	  
	  onTest(){
		  const headers = new HttpHeaders().set("Content-Type", "application/json");
		  this.http.get("/auth/testloginmsg", {headers}).subscribe(
			        val => {
			            console.log("GET call successful value returned in body", 
		                        val);
			            alert("GET call successful value returned in body: "+ 
		                        val);
			            this.loginResponse = <LoginResponse>val;
			        },
			        response => {
			            console.log("GET call in error", response);
			            alert("GET call in error: "+ response);
			        },
			        () => {
			            
			        }
			    );
	  }
	  
	  onSubmit() {
	        this.submitted = true;
	        this.failedLogin = false;

	        // stop here if form is invalid
	        if (this.loginForm.invalid) {
	            return;
	        }

	        this.loading = true;
	        	
	        const params = {
	        		"username": this.loginForm.controls["username"].value,
	    	        "password": this.loginForm.controls["password"].value,
	    	        "companyid": this.loginForm.controls["companyid"].value
	        };
	        
	        const headers = new HttpHeaders().set("Content-Type", "application/json");
			  this.http.post("/auth/login", params, {headers}).subscribe(
				        val => {
				            this.loginResponse = <LoginResponse>val;
				            
				            this.failedLogin = true;
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