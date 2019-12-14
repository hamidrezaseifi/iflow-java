import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

import { WorkflowMessage } from '../../wf-models/workflowmessage';


@Injectable({
  providedIn: 'root'
})
export class WorkflowMessageService {
	
	loadMessageUrl :string = "/general/data/workflowmessages";
	assignWorkflowUrl :string = "/workflow/data/assignworkflow/";
	
	public workflowMessageListSubject: BehaviorSubject<WorkflowMessage[]>;


	constructor(private http:HttpClient, ) { 
		this.workflowMessageListSubject = new BehaviorSubject<WorkflowMessage[]>([]);
        
	}
	
    public get workflowMessageList(): WorkflowMessage[] {
        return this.workflowMessageListSubject.value;
    }
	
	loadMessages(resetCach: boolean){
    	
    	var url = this.loadMessageUrl + "?reset=" + (resetCach ? "1" : "0");
    	        
        const httpOptions = {
        		  headers: new HttpHeaders({
        		    'Content-Type':  'application/json; charset=UTF-8'
        		  })
        		};
    	
    	this.http.post(url, new HttpParams(), httpOptions).subscribe(
	        val => {
	        	console.log("Read message list", val);
	        	var messageList = <WorkflowMessage[]>val;
	        	messageList = this.buildMessageList(messageList);
	        	this.workflowMessageListSubject.next(messageList);
	            
	        },
	        response => {
	        	//console.log("Error in read message list", response);
	        	this.workflowMessageListSubject.next([]);
	        	
	        },
	        () => {
	        	//console.log("Compelete read message list ");
	        	this.workflowMessageListSubject.complete();            
	        }
    	);	      
    	
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
