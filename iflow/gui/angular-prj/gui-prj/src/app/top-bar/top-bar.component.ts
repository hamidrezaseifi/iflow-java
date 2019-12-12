import { Component, OnInit } from '@angular/core';

import { GlobalService } from '../helper/global.service';
import { User, MenuItem } from '../ui-models';
import { IGeneralDataComponent, GeneralLoadingComponent } from '../_components';
import { Router } from '@angular/router';


@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css'],
  providers: [ GlobalService ]
})
export class TopBarComponent extends GeneralLoadingComponent implements OnInit, IGeneralDataComponent {
  
	menus: MenuItem[] = [];
	currentUser: User = null;
	isLogged: boolean = false;

	constructor(protected router: Router, protected global: GlobalService) { 
  		super(router, global);

	}
	
	ngOnInit() {
		super.ngOnInit();
		
	}
	
	

}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/