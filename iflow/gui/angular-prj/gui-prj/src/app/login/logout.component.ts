import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { GlobalService } from '../helper/global.service';
import { AuthenticationService } from '../services';


@Component({ templateUrl: '' })
	export class LogoutComponent implements OnInit {
	
	  constructor(
		private route: ActivatedRoute,
		private router: Router,
		private autService: AuthenticationService,
		private global: GlobalService,
		
	  ) { 	  
		  this.autService.logout();
		  this.global.clear();
	  }
	  

	  ngOnInit() {
		  this.autService.logout();
		  this.global.clear();
		  this.router.navigate(['/auth/login']);
	  }
	  
}