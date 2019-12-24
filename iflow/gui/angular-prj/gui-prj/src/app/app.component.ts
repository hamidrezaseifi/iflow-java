import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import { Title } from '@angular/platform-browser';
import { Observable } from 'rxjs';

import { GlobalService } from './services/global.service';
import { AuthenticationService } from './services';

import { environment } from '../environments/environment';


import { User, MenuItem, GeneralData } from './ui-models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ],
  providers: [ GlobalService ]
})
export class AppComponent implements OnInit  {
	
	generalDataObs :Observable<GeneralData> = null;
	
	//appMenus: MenuItem[] = [];
	//appCurrentUser: User = null;
	//appIsLogged: boolean = false;
	
	appShowLoading: boolean = false;
	

	constructor(
	    private router: Router,
		private autService: AuthenticationService,
		private global: GlobalService,
		translate: TranslateService,
		private titleService: Title,
		
	) {
		
        translate.setDefaultLang('de');

        translate.use('de');
        
        translate.get('site.title').subscribe((res: string) => {
        	this.titleService.setTitle( res );
        });
                		
		this.router.routeReuseStrategy.shouldReuseRoute = function(){
 	        return false;
		}

		this.router.events.subscribe((evt) => {
 	        if (evt instanceof NavigationEnd) {
 	        	
 	        	//if(this.autService.isLoggedIn === true && this.appCurrentUser === null){
 	        		//this.subscribeToGeneralData();
 	        		this.global.loadAllSetting(null);
 	        		//alert("nav end from app-comp");
 	        	//}
 	           
 	        }
		});

		this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
		
	}
	
	ngOnInit() {
		
		
		this.global.loadAllSetting(null);
		
		//this.subscribeToGeneralData();
		//this.global.loadAllSetting(null);
	}

	/*private subscribeToGeneralData(){
		alert("subscribe");
		
		this.global.currentSessionDataSubject.subscribe((data : GeneralData) => {
        	
			console.log("set gloabl-data from app-comp. appIsLogged: " + this.appIsLogged);
			alert("from app-comp: \n" + JSON.stringify(data));
        	
			if(data && data !== null){
				
				var value = data.isLogged + "";
				
				if(value === "true" === true){
	 	 			this.appMenus = data.app.menus;
	 	 	  		this.appCurrentUser = data.user.currentUser;
	 	 	  		this.appIsLogged = true; 
	 	 	  		
				}
				else{
					this.appMenus = [];
					this.appCurrentUser = null;
					this.appIsLogged = false;					
				}
 	 	  		
			}
			else{
				this.appMenus = [];
				this.appCurrentUser = null;
				this.appIsLogged = false;
			}
		  });
	}*/
	
	showLoading(){
		
		this.appShowLoading = true;
	}
	
	
	onLoggingOut(data: boolean) {
		this.autService.logout();
		this.global.clear();
		this.router.navigate(['/auth/login']);
	}	
	
}


