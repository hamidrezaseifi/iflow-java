import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User, MenuItem } from '../ui-models';
import { IGeneralDataComponent } from '../_components';
import { TopBarComponent } from '../top-bar/top-bar.component';

export interface GeneralData {
	isLogged: boolean;
	currectUser: User;
	departments: Object[];
	users: User[];
	menus: MenuItem[];
	
}

@Injectable()
export class GlobalService {
	private isSettingLoaded = false;

	private isLogged: boolean = false;
	private currentUser: User = null;
	private allUsers: User[] = [];
	private menus: MenuItem[] = [];
	private departments: Object[] = [];

	constructor(private http:HttpClient) { }
	  
	loadAllSetting(component :IGeneralDataComponent = null){
		
	  //alert(component);
	  //alert(this.isSettingLoaded);
	  
	  if(this.isSettingLoaded){
		  if(component != null){
          	component.setGeneralData(this.menus, this.currentUser, this.departments, this.allUsers, this.isLogged);
          }
	  }
	  else{
		  this.http.get("/general/data/generaldatat").subscribe(
			        val => {
			            console.log("GET call successful generaldata", val);
			            alert("GET call generaldata");
			            var generalData = <GeneralData>val;
			            this.isLogged = generalData.isLogged;
			            this.menus = generalData.menus;
			            this.allUsers = generalData.users;
			            this.departments = generalData.departments;
			            this.currentUser = generalData.currectUser;
			            
			            this.isSettingLoaded = true;
			            
			            if(component != null){
			            	component.setGeneralData(this.menus, this.currentUser, this.departments, this.allUsers, this.isLogged);
			            }
			        },
			        response => {
			            console.log("Error in read menu list", response);
			            //alert("Error in read menu list: "+ response);
			        },
			        () => {
			            
			        }
			    );
	  }
	  
  }
  
  
}
