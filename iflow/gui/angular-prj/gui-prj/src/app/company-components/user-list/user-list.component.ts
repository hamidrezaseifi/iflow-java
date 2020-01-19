import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { DateAdapter } from '@angular/material/core';

import { GlobalService } from '../../services/global.service';
import { UserEditService } from '../../services/company/user-edit.service';
import { LoadingServiceService } from '../../services/loading-service.service';
import { ErrorServiceService } from '../../services/error-service.service';
import { GermanDateAdapter, parseDate, formatDate } from '../../helper';
import { UserAccessTypeControllValidator } from '../../custom-validators/user-access-type-controll-validator';

import { User, UserAccessType } from '../../ui-models';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  providers: [{provide: DateAdapter, useClass: GermanDateAdapter}]
})
export class UserListComponent implements OnInit {

	users :User[] = [];

	displayedColumns = ['user-fullname', 'user-email', 'user-access', 'user-status', 'actions'];

	isCreating :boolean = false;
	showEditModal :boolean = false;
	editingUser :User = new User;

	userEditForm: FormGroup;
	
	deleteMessageBase :string = "";
	deleteMessage :string = "";
	delitingUser :User = new User;
	showDeleteModal :boolean = false;

	constructor(
		    private router: Router,
			private global: GlobalService,
			translate: TranslateService,
			private editService :UserEditService,
			private loadingService: LoadingServiceService,
			private errorService: ErrorServiceService,
			private route :ActivatedRoute,
			private formBuilder: FormBuilder,
			private dateAdapter: DateAdapter<Date>,
			
	) {
		this.dateAdapter.setLocale('de');
		
        translate.get('user-delete-message').subscribe((res: string) => {
        	this.deleteMessageBase = res;
        });

	}

	ngOnInit() {
		this.userEditForm = this.formBuilder.group({
			
			email: ['', Validators.email],
		    password: ['', Validators.required],
			firstName: ['', Validators.required],
		    lastName: ['', Validators.required],
		    birthDate: ['', Validators.required],
		    status: ['1', Validators.required],
			userAccess: [UserAccessType.NONE, [UserAccessTypeControllValidator]],
		
			
        });
		
		this.reload();
	}

	debug(){
		var s = "";
		for(var cnt in this.userEditForm.controls){
			var ctl = this.userEditForm.controls[cnt];
			//JSON.stringify(ctl.ValidationErrors)
			s += cnt + ": " + ctl.value +  " \n ";
		}
		return s;
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

	showCreateUser() {
		var passwordCtrl:AbstractControl = this.userEditForm.get('password');
		passwordCtrl.enable();

		this.isCreating = true;
		this.editingUser = new User;
		this.setToControlValues();
		
		this.showEditModal = true;
		
	}

	showEditUser(user: User) {
		
		var passwordCtrl:AbstractControl = this.userEditForm.get('password');
		passwordCtrl.disable();

		this.isCreating = false;
		this.editingUser = user;
		this.setToControlValues();
		
		
		this.showEditModal = true;
	}

	showViewUser(user: User) {
		
	}

	showDeleteUser(user: User) {
		
		this.delitingUser = user;
		this.deleteMessage = this.deleteMessageBase;
		this.deleteMessage = this.deleteMessage.replace("%" , user.fullName);

		this.showDeleteModal = true;
	}
	
	hideDeleteUserDialog(){
		this.showDeleteModal = false;
	}
	
	hideEditUserDialog(){
		this.showEditModal = false;
	}

	deleteUser(){
		this.loadingService.showLoading();
		

		this.editService.deleteUser(this.delitingUser).subscribe(
		        (result) => {		        	
		            console.log("Delete user result success.");
		            this.showDeleteModal = false;
		            this.reload();
		            
		        },
		        response => {
		        	console.log("Error in create user", response);
		        	
		        	this.errorService.showErrorResponse(response);
		        	this.loadingService.hideLoading();	 
		        },
		        () => {
		        	
		        	this.loadingService.hideLoading();	 
		        }
		);	     
		

	}
	
	saveUser() {
		this.setFormControlValues();
				
		this.loadingService.showLoading();
		
		if(this.isCreating){
			this.editService.createUser(this.editingUser).subscribe(
			        (result) => {		        	
			            console.log("Create user result", result);
			            this.showEditModal = false;
			            this.reload();
			            
			        },
			        response => {
			        	console.log("Error in create user", response);
			        	
			        	this.errorService.showErrorResponse(response);
			        	this.loadingService.hideLoading();	 
			        },
			        () => {
			        	
			        	this.loadingService.hideLoading();	 
			        }
			);	     
		}
		else{
			this.editService.updateUser(this.editingUser).subscribe(
			        (result) => {		        	
			            console.log("Update user result", result);
			            this.showEditModal = false;
			            this.reload();
			            
			        },
			        response => {
			        	console.log("Error in update user", response);
			        	
			        	this.errorService.showErrorResponse(response);
			        	this.loadingService.hideLoading();	 
			        },
			        () => {
			        	
			        	this.loadingService.hideLoading();	 
			        }
			);	     
			
		}
		
		
		
		
	}


	setToControlValues(){
		if(this.editingUser && this.editingUser){
			this.userEditForm.controls["email"].setValue(this.editingUser.email);
			this.userEditForm.controls["password"].setValue(this.editingUser.password);
			this.userEditForm.controls["firstName"].setValue(this.editingUser.firstName);
			this.userEditForm.controls["lastName"].setValue(this.editingUser.lastName);
			this.userEditForm.controls["userAccess"].setValue(this.editingUser.userAccess);
			this.userEditForm.controls["status"].setValue(this.editingUser.status + '');			
			this.userEditForm.controls["birthDate"].setValue(parseDate(this.editingUser.birthDate, 'dd.mm.yyyy'));

		}
	}
	
	setFormControlValues(){
				
		this.editingUser.email = this.userEditForm.controls["email"].value;
		this.editingUser.password = this.userEditForm.controls["password"].value;
		this.editingUser.firstName = this.userEditForm.controls["firstName"].value;
		this.editingUser.lastName = this.userEditForm.controls["lastName"].value;
		this.editingUser.userAccess = this.userEditForm.controls["userAccess"].value;
		this.editingUser.status = this.userEditForm.controls["status"].value;			
		this.editingUser.birthDate = formatDate(this.userEditForm.controls["birthDate"].value, 'dd.mm.yyyy');
	}
	
	
}
