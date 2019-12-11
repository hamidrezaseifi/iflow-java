import { Component, OnInit } from '@angular/core';

import { GlobalService } from '../helper/global.service';
import { User, MenuItem, IComponent } from '../ui-models';
import { Router } from '@angular/router';


@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit, IComponent {
  
	menus: MenuItem[] = [];
	currentUser: User = null;

	constructor(private router: Router, private global: GlobalService) { 
	}

	ngOnInit() {
		
		this.router.events
	    .subscribe((event) => {
	      this.global.getMenus(this);
	    });
		
	}
	
	get isLogedIn() { return this.currentUser != null; }

}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/