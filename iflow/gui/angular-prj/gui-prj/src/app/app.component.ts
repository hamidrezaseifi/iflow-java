import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import { Title } from '@angular/platform-browser';

import { GlobalService } from './services/global.service';
import { AuthenticationService } from './services';


import { User, MenuItem } from './ui-models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ],
providers: [ GlobalService ]
})
export class AppComponent implements OnInit  {
	
	appMenus: MenuItem[] = [];
	appCurrentUser: User = null;
	appIsLogged: boolean = false;

	appShowLoading: boolean = false;
	

	constructor(
	    private router: Router,
		private autService: AuthenticationService,
		private global: GlobalService,
		translate: TranslateService,
		private titleService: Title,
		
	) {
		
        // this language will be used as a fallback when a translation isn't found in the current language
        translate.setDefaultLang('de');

         // the lang to use, if the lang isn't available, it will use the current loader to get them
        translate.use('de');
        
        translate.get('site.title').subscribe((res: string) => {
        	this.titleService.setTitle( res );
        });
		
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

	showLoading(){
		
		this.appShowLoading = true;
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