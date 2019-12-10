import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DOCUMENT } from '@angular/common'; 

@Component({ templateUrl: 'login.component.html' })
	export class LoginComponent implements OnInit {

	loginForm: FormGroup;
	loading = false;
	submitted = false;
	form: HTMLFormElement; 

	  constructor(
	  	private formBuilder: FormBuilder,
		private route: ActivatedRoute,
		private router: Router,
		
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
	  
	  onSubmit() {
	        this.submitted = true;

	        // stop here if form is invalid
	        if (this.loginForm.invalid) {
	            return;
	        }

	        this.loading = true;
	        
	        
	        	
	        this.form = document.forms.namedItem("formlogin"); //.getElementById("formlogin");
	        
	        this.form.submit();
	        
	        /*this.authenticationService.login(this.f.username.value, this.f.password.value)
	            .pipe(first())
	            .subscribe(
	                data => {
	                    this.router.navigate([this.returnUrl]);
	                },
	                error => {
	                    this.alertService.error(error);
	                    this.loading = false;
	                });*/
	    }	  

}