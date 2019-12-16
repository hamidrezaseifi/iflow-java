import { Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoadingServiceService } from '../services/loading-service.service';
import { GlobalService } from '../services/global.service';

import { AuthenticationService } from '../services';
import { User, MenuItem } from '../ui-models';


@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css'],
})
export class TopBarComponent implements OnInit {
  
	@Input('menus') menus: MenuItem[];
	@Input('currentUser') currentUser: User;
	@Input('isLogged') isLogged: boolean;
	
	@Output() loggingOut = new EventEmitter<boolean>();

	constructor(
		    private router: Router,
		    private global: GlobalService,
		) { 
  		
 	}
	
	ngOnInit() {

	}
	

	logout(){
		this.loggingOut.emit(true);
		
	}		

	showProfile(){
		
	}
	
	test(){
		this.global.loadAllSetting(null);
		
	}		
}
