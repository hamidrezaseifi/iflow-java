import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, ReplaySubject } from 'rxjs';

import { User, MenuItem } from '../ui-models';
import { TopBarComponent } from '../top-bar/top-bar.component';

export interface GeneralData {
	isLogged: boolean;
	currentUser: User;
	departments: Object[];
	users: User[];
	menus: MenuItem[];
	
}

@Injectable({ providedIn: 'root' })
export class GlobalService {
	
	public currentSessionDataSubject: BehaviorSubject<GeneralData>;
	public currentSessionDataTopMenu :Observable<GeneralData>;		
	public currentSessionDataLogin :Observable<GeneralData>;		

	constructor(private http:HttpClient, ) { 
		this.currentSessionDataSubject = new BehaviorSubject<GeneralData>(JSON.parse(localStorage.getItem('currentSessionData')));
        this.currentSessionDataTopMenu = this.currentSessionDataSubject.asObservable();		
        this.currentSessionDataLogin = this.currentSessionDataSubject.asObservable();		
	}
	
	loadAllSetting(){
	  this.http.get("/general/data/generaldatat").subscribe(
		        val => {
		            console.log("GET call successful generaldata", val);
		            //alert("GET call generaldata");
		            var generalData = <GeneralData>val;
		            
		        	localStorage.setItem('currentSessionData', JSON.stringify(generalData));
		        	this.currentSessionDataSubject.next(generalData);
		        	this.currentSessionDataSubject.complete();
		        },
		        response => {
		            console.log("Error in read menu list", response);
		            //alert("Error in read menu list: "+ response);
		        },
		        () => {
		            
		        }
		    );
  }
  
	clear(){
		localStorage.removeItem('currentSessionData');
		this.currentSessionDataSubject.next(null);
	}
  
}
