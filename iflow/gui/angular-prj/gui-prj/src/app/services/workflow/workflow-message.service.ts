import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

import { WorkflowMessage } from '../../wf-models/workflowmessage';

import { ErrorServiceService } from '../error-service.service';
import { HttpHepler } from '../../helper/http-hepler';


@Injectable({
  providedIn: 'root'
})
export class WorkflowMessageService {
	
	loadMessageUrl :string = "/general/data/workflowmessages";
	assignWorkflowUrl :string = "/general/data/workflow/assign/";

	isReloadingMessages : boolean = false;
	
	public workflowMessageListSubject: BehaviorSubject<WorkflowMessage[]>;


	constructor(
			private http:HttpClient, 
			private errorService: ErrorServiceService,) { 
		this.workflowMessageListSubject = new BehaviorSubject<WorkflowMessage[]>([]);
        
	}
	
    public get workflowMessageList(): WorkflowMessage[] {
        return this.workflowMessageListSubject.value;
    }
	
	loadMessages(resetCach: boolean){
    	
    	this.isReloadingMessages = true;
    	var url = this.loadMessageUrl + "?reset=" + (resetCach ? "1" : "0");
    	        
        const httpOptions = { headers: HttpHepler.generateJsonHeader() };
    	
    	this.http.post(url, new HttpParams(), httpOptions).subscribe(
	        val => {
	        	console.log("Read message list", val);
	        	var messageList = <WorkflowMessage[]>val;
	        	messageList = this.buildMessageList(messageList);
	        	this.workflowMessageListSubject.next(messageList);
	            
	        },
	        response => {
	        	console.log("Error in read message list", response);
	        	this.workflowMessageListSubject.next([]);
	  			this.errorService.showErrorResponse(response);
	        	
	        },
	        () => {
	        	this.workflowMessageListSubject.complete();  
	        	
	        	setTimeout(()=>{ 
	        		this.isReloadingMessages = false;
	        	 }, 500);
	        	
	        }
    	);	      
    	
	}
	
	assignMe(workflowIdentity: string){
    	
    	this.isReloadingMessages = true;
    	var url = this.assignWorkflowUrl + workflowIdentity;
    	       
        const httpOptions = { headers: HttpHepler.generateJsonHeader() };
    	
    	return this.http.post(url, new HttpParams(), httpOptions);	      
	}
    
    
	private buildMessageList(messages){
		var messageList = [];
		for(var index in messages){
			var message = messages[index];
			messageList.push(message);
		}
		
		return messageList;
	}
    
	
}
