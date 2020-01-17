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
		
	}

	reload() {
		
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
