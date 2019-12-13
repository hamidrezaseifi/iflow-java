import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { GlobalService } from './helper/global.service';
import { AuthenticationService } from './services';
import { User, MenuItem } from './ui-models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent implements OnInit  {
	
	appMenus: MenuItem[] = [];
	appCurrentUser: User = null;
	appIsLogged: boolean = false;

	constructor(
	    private router: Router,
		private autService: AuthenticationService,
		private global: GlobalService,
	) {
 		this.global.currentSessionDataTopMenu.subscribe(
  				x => {
  					if(x != null){
  			  			this.appMenus = x.menus;
  			  			this.appCurrentUser = x.currentUser;
  			  			this.appIsLogged = x.isLogged;  						
  					}
  					else{
  						this.appMenus = [];
  			  			this.appCurrentUser = null;
  			  			this.appIsLogged = false;
  					}
		  		},
		  		error => {
		  			this.appMenus = [];
		  			this.appCurrentUser = null;
		  			this.appIsLogged = false;
		  		},
		  		() => {
		  			if(this.appIsLogged === false){
		  				this.appMenus = [];
			  			this.appCurrentUser = null;
			  			this.appIsLogged = false;
		  			}
		  		},
  		);

	}
	
	ngOnInit() {

	
	}
	
	logout(){
		this.autService.logout();
		this.global.clear();
		this.router.navigate(['/logout']);
	}		
	
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/