import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, ReplaySubject } from 'rxjs';

import { User, MenuItem, GeneralData } from '../ui-models';
import { TopBarComponent } from '../top-bar/top-bar.component';
import { ILoginComponent } from '../_components';



@Injectable({ providedIn: 'root' })
export class GlobalService {
	
	public currentSessionDataSubject: BehaviorSubject<GeneralData>;
	public currentSessionDataObs :Observable<GeneralData>;		

	constructor(private http:HttpClient, ) { 
		this.currentSessionDataSubject = new BehaviorSubject<GeneralData>(JSON.parse(localStorage.getItem('currentSessionData')));
        this.currentSessionDataObs = this.currentSessionDataSubject.asObservable();		
	}
	
    public get currentSessionDataValue(): GeneralData {
        return this.currentSessionDataSubject.value;
    }
	
	loadAllSetting(login: ILoginComponent){
	  this.http.get("/general/data/generaldatat").subscribe(
		        val => {
		            console.log("GET call successful generaldata", val);
		            //alert("GET call generaldata");
		            var generalData = <GeneralData>val;
		            
		        	localStorage.setItem('currentSessionData', JSON.stringify(generalData));
		        	this.currentSessionDataSubject.next(generalData);
		        	
		        },
		        response => {
		            console.log("Error in read menu list", response);
		            //alert("Error in read menu list: "+ response);
		        },
		        () => {
		            if(login != null){
		            	login.finishGeneralDataLoading();
		            }
		            //alert("Finish call successful generaldata");
		            this.currentSessionDataSubject.complete();
		        }
		    );
	}
  
	clear(){
		localStorage.removeItem('currentSessionData');
		this.currentSessionDataSubject.next(null);
		this.currentSessionDataSubject.complete();
	}
  
}
