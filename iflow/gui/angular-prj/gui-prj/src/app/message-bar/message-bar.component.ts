import { Component, OnInit, Input, OnDestroy } from '@angular/core';

import { WorkflowMessage } from '../wf-models';
import { User, MenuItem } from '../ui-models';
import { Router, NavigationEnd } from '@angular/router';
import * as moment from 'moment'; 

import { WorkflowMessageService } from '../services/workflow/workflow-message.service';
import { GlobalService } from '../services/global.service';

@Component({
  selector: 'app-message-bar',
  templateUrl: './message-bar.component.html',
  styleUrls: ['./message-bar.component.css'],
  providers: [ WorkflowMessageService ]
})
export class MessageBarComponent implements OnInit, OnDestroy {

	messages: WorkflowMessage[] = [];
	messageSearchInterval = 60000;
	messageReloadTimeoutId = 0;

	@Input('currentUser') currentUser: User;
	
	private _isLogged: boolean = false;
	
	@Input('isLogged')
	set isLogged(value: string) {
	    
		//console.log("change isLogged inside comp. this: " + this._isLogged + ",   app: " + value); 	    
		this._isLogged = value === 'true';
	    this.reloadMessages(true);	    
	}
	
	
	get isAppLogged(): boolean { 
		return this._isLogged; 
	}	

	constructor(protected router: Router, private messageService :WorkflowMessageService, private global: GlobalService,) { 
	
		
		
	}
	

	ngOnInit() {
		
		
		if(this._isLogged == true){
	    	console.log("start read message list from comp.");
	    	this.reloadMessages(true);
	    }
	}
	
	ngOnDestroy() {
		//this.messageService.workflowMessageListSubject.unsubscribe();
	}
	
	private reloadMessages(reset: boolean){
		
		clearTimeout(this.messageReloadTimeoutId);
		//console.log("start reloadMessages.  _isLogged:" + (this._isLogged === true));
		if(this._isLogged === true){
			
			this.subscribeService();
			this.messageService.loadMessages(reset);
			
		}
				
	}
	
  	showWorkflowView(id){
	  
  	}
  	
  	private subscribeService(){
		
 		this.messageService.workflowMessageListSubject.subscribe(
  				x => {
  					if(x != null){
  			  			this.messages = x;
  					}
  					else{
  						this.messages = [];
  					}
  					//alert("app-comp globaldata change. menus:" + this.appMenus.length);
  					
		  		},
		  		error => {
		  			this.messages = [];
		  		},
		  		() => {
		  			//this.messageService.workflowMessageListSubject.unsubscribe();
		  			//console.log("Compelete read message list from comp. start next timeout");
		  			
		  			this.messageReloadTimeoutId = setTimeout(() =>{ 
		  				
		  					this.reloadMessages(false);
		  				
		  				 
		  			}, this.messageSearchInterval);
		  			
		  		},
  		);
		
  	}


}
