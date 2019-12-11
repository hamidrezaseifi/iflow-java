import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from './services';
import { User } from './ui-models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
	currentUser: User;

	constructor(
	    private router: Router,
	    private authenticationService: AuthenticationService
	) {
	    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
	}
	
	logout() {
	    this.authenticationService.logout();
	    this.router.navigate(['/login']);
	}	
	
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/