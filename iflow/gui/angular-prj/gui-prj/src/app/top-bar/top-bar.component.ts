import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

import { GlobalService } from '../helper/global.service';
import { AuthenticationService } from '../services';
import { User, MenuItem } from '../ui-models';


@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css'],
  providers: [ GlobalService ]
})
export class TopBarComponent implements OnInit {
  
	@Input('menus') menus: MenuItem[];
	@Input('currentUser') currentUser: User;
	@Input('isLogged') isLogged: boolean;

	constructor(
		    private router: Router,
			private autService: AuthenticationService,
			private global: GlobalService,
		) { 
  		
 	}
	
	ngOnInit() {

	}
	

	logout(){
		this.autService.logout();
		this.global.clear();
		this.router.navigate(['/logout']);
	}		
}
