import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

import { User, MenuItem, GeneralData } from '../ui-models';
import { TopBarComponent } from '../top-bar/top-bar.component';
import { ILoginComponent } from '../components';
import { LoadingServiceService } from './loading-service.service';
import { HttpHepler } from '../helper/http-hepler';

@Injectable({ providedIn: 'root' })
export class GlobalService {
	
	loadGeneralDataUrl :string = "/general/data/generaldatat";
	public currentSessionDataSubject: BehaviorSubject<GeneralData> = new BehaviorSubject<GeneralData>(null);
	//public currentSessionDataObs :Observable<GeneralData>;		

	public loadedGeneralData : GeneralData = null;
	
	constructor(private http:HttpClient, private loadingService: LoadingServiceService,) { 
		//this.currentSessionDataSubject = new BehaviorSubject<GeneralData>(null);
        //this.currentSessionDataObs = this.currentSessionDataSubject.asObservable();		
	}
	
   /* public get currentSessionDataValue(): GeneralData {
        return this.currentSessionDataSubject.value;
    }*/
	
	loadAllSetting(login: ILoginComponent, ){
		this.loadingService.showLoading();
		
        const httpOptions = { headers: HttpHepler.generateFormHeader() };

		this.http.get(this.loadGeneralDataUrl, httpOptions).subscribe(
				(generalData :GeneralData) => {
		            console.log("GET call successful generaldata", generalData);
		            
		            var islogged = generalData.isLogged + "";
		            generalData.isLogged = islogged === "true";
		            
		            this.loadedGeneralData = <GeneralData> JSON.parse(JSON.stringify(generalData));
		            
		        	this.currentSessionDataSubject.next(generalData);
		        	
		        	this.loadingService.hideLoading();
		        },
		        response => {
		            console.log("Error in read general list", response);
		            this.loadingService.hideLoading();
		        },
		        () => {
		            if(login != null){
		            	login.finishGeneralDataLoading();
		            }
		            
		            //this.currentSessionDataSubject.complete();
		            
		            this.loadingService.hideLoading();
		        }
		);
	}
	
	/*setGeneralData(generalData :GeneralData){
		this.currentSessionDataSubject.next(generalData);
		//this.currentSessionDataSubject.complete();
	}*/
  
	loadAllSettingObserv(){		
        const httpOptions = { headers: HttpHepler.generateFormHeader() };
        
		return this.http.get(this.loadGeneralDataUrl, httpOptions);
	}
  
	/*clear(){	
		
		//alert("clear global");
		this.currentSessionDataSubject.next(null);
		//this.currentSessionDataSubject.complete();
	}*/
  
}
