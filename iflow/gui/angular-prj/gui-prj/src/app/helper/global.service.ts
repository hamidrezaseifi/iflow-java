import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User, MenuItem, IComponent } from '../ui-models';
import { TopBarComponent } from '../top-bar/top-bar.component';

export interface GeneralData {
	currectUser: User;
	departments: Object[];
	users: User[];
	menus: MenuItem[];
	
}

@Injectable({
  providedIn: 'root'
})
export class GlobalService {
	private currentUser: User = null;
	private allUsers: User[] = [];
	private menus: MenuItem[] = [];
	private isSettingLoaded = false;
	private departments: Object[] = [];

  constructor(
			private http:HttpClient,	  
  ) { }
  
  loadAllSetting(component :IComponent = null){
	  this.http.get("/general/data/generaldatat").subscribe(
		        val => {
		            console.log("GET call successful value returned in body", 
	                        val);
		            var generalData = <GeneralData>val;
		            this.menus = generalData.menus;
		            this.allUsers = generalData.users;
		            this.departments = generalData.departments;
		            this.currentUser = generalData.currectUser;
		            
		            if(component != null){
		            	component.menus = this.menus;
		            	component.currentUser = this.currentUser;
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
  
  getMenus(component :IComponent = null){
	  if(this.isSettingLoaded == false){
		  this.loadAllSetting(component);
	  }
	  else{
		  if(component != null){
			  component.menus = this.menus;
		  }		  
	  }
  }
}
