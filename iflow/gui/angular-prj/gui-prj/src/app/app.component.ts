import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

import { GlobalService } from './services/global.service';
import { AuthenticationService } from './services';
import { User, MenuItem } from './ui-models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ],
providers: [ GlobalService ]
})
export class AppComponent implements OnInit, OnDestroy  {
	
	appMenus: MenuItem[] = [];
	appCurrentUser: User = null;
	appIsLogged: boolean = false;

	constructor(
	    private router: Router,
		private autService: AuthenticationService,
		private global: GlobalService,
	) {
		
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
 	 	  		console.log("set gloabl-data from app-comp. appIsLogged: " + this.appIsLogged);
	 	 	  }
 	          else{
				this.appMenus = [];
				this.appCurrentUser = null;
				this.appIsLogged = false;
 	          }
 	         //alert("app-comp globaldata navigate. menus:" + this.appMenus.length);
 	        }
		});
 	     
	}
	
	ngOnInit() {
		if(this.global.currentSessionDataValue && this.global.currentSessionDataValue.isLogged){
			this.appMenus = this.global.currentSessionDataValue.app.menus;
	  		this.appCurrentUser = this.global.currentSessionDataValue.user.currentUser;
	  		this.appIsLogged = this.global.currentSessionDataValue.isLogged; 
	  		console.log("set gloabl-data from app-comp. appIsLogged: " + this.appIsLogged);
		}
		else{
			this.appMenus = [];
			this.appCurrentUser = null;
			this.appIsLogged = false;
		}
		
	
	}
	
	ngOnDestroy() {
		//this.global.currentSessionDataSubject.unsubscribe();
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