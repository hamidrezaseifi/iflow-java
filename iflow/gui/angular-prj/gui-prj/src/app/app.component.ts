import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

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
 		this.global.currentSessionDataSubject.subscribe(
  				x => {
  					if(x != null){
  			  			this.appMenus = x.app.menus;
  			  			this.appCurrentUser = x.user.currentUser;
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

 		this.router.routeReuseStrategy.shouldReuseRoute = function(){
 	        return false;
 	     }

 	     this.router.events.subscribe((evt) => {
 	        if (evt instanceof NavigationEnd) {
 	           // trick the Router into believing it's last link wasn't previously loaded
 	           this.router.navigated = false;
 	           
 	          if(this.global.currentSessionDataValue && this.global.currentSessionDataValue.isLogged){
 	 			this.appMenus = this.global.currentSessionDataValue.app.menus;
 	 	  		this.appCurrentUser = this.global.currentSessionDataValue.user.currentUser;
 	 	  		this.appIsLogged = this.global.currentSessionDataValue.isLogged; 
 	 	  		
	 	 	  }
 	          else{
				this.appMenus = [];
				this.appCurrentUser = null;
				this.appIsLogged = false;
 	          }
 	          
 	        }
 	    });
 	     
	}
	
	ngOnInit() {
		
	
	}
	
	onLoggingOut(data: boolean) {
		this.autService.logout();
		this.global.clear();
		this.router.navigate(['/auth/login']);
	}	
	
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/