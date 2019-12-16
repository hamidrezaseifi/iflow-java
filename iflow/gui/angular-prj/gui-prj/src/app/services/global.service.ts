import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { User, MenuItem, GeneralData } from '../ui-models';
import { TopBarComponent } from '../top-bar/top-bar.component';
import { ILoginComponent } from '../_components';
import { LoadingServiceService } from './loading-service.service';

@Injectable({ providedIn: 'root' })
export class GlobalService {
	
	public currentSessionDataSubject: BehaviorSubject<GeneralData> = new BehaviorSubject<GeneralData>(null);
	//public currentSessionDataObs :Observable<GeneralData>;		

	constructor(private http:HttpClient, private loadingService: LoadingServiceService,) { 
		//this.currentSessionDataSubject = new BehaviorSubject<GeneralData>(null);
        //this.currentSessionDataObs = this.currentSessionDataSubject.asObservable();		
	}
	
    /*public get currentSessionDataValue(): GeneralData {
        return this.currentSessionDataSubject.value;
    }*/
	
	loadAllSetting(login: ILoginComponent, ){
		this.loadingService.showLoading();
		
		this.http.get("/general/data/generaldatat").subscribe(
				(generalData :GeneralData) => {
		            console.log("GET call successful generaldata", generalData);
		            
		        	this.currentSessionDataSubject.next(generalData);
		        	
		        },
		        response => {
		            console.log("Error in read menu list", response);
		            
		        },
		        () => {
		            if(login != null){
		            	login.finishGeneralDataLoading();
		            }
		            
		            this.currentSessionDataSubject.complete();
		            
		            this.loadingService.hideLoading();
		        }
		);
	}
	
	setGeneralData(generalData :GeneralData){
		this.currentSessionDataSubject.next(generalData);
		this.currentSessionDataSubject.complete();
	}
  
	loadAllSettingObserv(){		
		return this.http.get("/general/data/generaldatat");
	}
  
	clear(){	
		//alert("clear global");
		this.currentSessionDataSubject.next(null);
		this.currentSessionDataSubject.complete();
	}
  
}
