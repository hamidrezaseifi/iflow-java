import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';

import { GlobalService } from '../../services/global.service';
import { UserEditService } from '../../services/company/user-edit.service';
import { LoadingServiceService } from '../../services/loading-service.service';
import { ErrorServiceService } from '../../services/error-service.service';

import { User } from '../../ui-models';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

	users :User[] = [];

	displayedColumns = ['user-fullname', 'user-email', 'user-access', 'actions'];


	constructor(
		    private router: Router,
			private global: GlobalService,
			translate: TranslateService,
			private editService :UserEditService,
			private loadingService: LoadingServiceService,
			private errorService: ErrorServiceService,
			private route :ActivatedRoute,
			
	) {
		
		
	}

	ngOnInit() {
		this.reload();
	}

	reload() {
		this.loadingService.showLoading();
		
		this.editService.listUsers().subscribe(
	        (results :User[]) => {
	        	
	            console.log("User list", results);
	        	
	            this.users = results;
	        },
	        response => {
	        	console.log("Error in get user list", response);
	        	this.loadingService.hideLoading();	 
	        	this.errorService.showErrorResponse(response);
	        },
	        () => {
	        	
	        	this.loadingService.hideLoading();	            
	        }
		);	       	
	}

	create() {
		
	}

	editUser(user: User) {
		
	}

	viewUser(user: User) {
		
	}

	deleteUser(user: User) {
		
	}

}
