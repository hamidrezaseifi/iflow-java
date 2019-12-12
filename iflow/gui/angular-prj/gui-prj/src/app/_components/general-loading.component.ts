import { Component, OnInit } from '@angular/core';

import { User, MenuItem } from '../ui-models';
import { IGeneralDataComponent } from '../_components';
import { GlobalService } from '../helper/global.service';
import { Router,NavigationEnd  } from '@angular/router';

@Component({
	  providers: [ GlobalService ]
	})
export class GeneralLoadingComponent implements OnInit, IGeneralDataComponent {

  	constructor(protected router: Router, protected global: GlobalService) { 
  		
  	}

	menus: MenuItem[] = [];
	currentUser: User = null;
	isLogged: boolean = false;

	ngOnInit() {
		this.router.events
	    .subscribe((event) => {
	    	if(event instanceof NavigationEnd){
	    		this.global.loadAllSetting(this);
	    	}
	    });
		
	}
  

	setGeneralData(menus: MenuItem[], currentUser: User, departments: Object[], allUsers: User[], isLogged: boolean){
		this.menus = menus;
		this.currentUser = currentUser;
		this.isLogged = isLogged;
		
	}
	
  	

	get isLogedIn() { return this.currentUser != null && this.isLogged; }

}
