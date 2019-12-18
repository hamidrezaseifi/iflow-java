import { Component, OnInit, Input } from '@angular/core';
import * as moment from 'moment'; 
import { ResizeEvent } from 'angular-resizable-element';

import { Workflow } from '../wf-models';
import { WorkflowMessage } from '../wf-models';
import { User, MenuItem } from '../ui-models';
import { Router, NavigationEnd } from '@angular/router';

import { WorkflowMessageService } from '../services/workflow/workflow-message.service';
import { ErrorServiceService } from '../services/error-service.service';

@Component({
  selector: 'app-message-bar',
  templateUrl: './message-bar.component.html',
  styleUrls: ['./message-bar.component.css'],
  providers: [ WorkflowMessageService ]
})
export class MessageBarComponent implements OnInit {

	messages: WorkflowMessage[] = [];
	viewWorkflowModel :Workflow;
	viewWorkflow :boolean = false;

	messageSearchInterval = 60000;
	messageReloadTimeoutId = 0;
	messagePanelHeight = 170;
	messagePanelShowed :boolean= true;

	
	closeMessages(){
		//$('#message-panel-container').height(25);
		document.getElementById("message-panel-container").style.height = "25px";
		this.messagePanelShowed = false;
    };

	showMessages(){
		//$('#message-panel-container').height(this.messagePanelHeight);
		//alert("show pabel");
		document.getElementById("message-panel-container").style.height = this.messagePanelHeight + "px";
		this.messagePanelShowed = true;
    };
    
	@Input('currentUser') currentUser: User;
	
	private _isLogged: boolean = false;
	
	@Input('isLogged')
	set isLogged(value: boolean) {
	    
		this._isLogged = value;
		
	    this.reloadMessages(true);	    
	}
	
	
	get isAppLogged(): boolean { 
		return this._isLogged; 
	}	

	
	get isReloadingMessages(): boolean { 
		return this.messageService.isReloadingMessages; 
	}	

	
	constructor(protected router: Router, 
			private messageService :WorkflowMessageService,
			private errorService: ErrorServiceService,) { 
		
	}
	

	ngOnInit() {		
		
		if(this._isLogged == true){
	    	console.log("start read message list from comp.");
	    	this.reloadMessages(true);
	    }
	}
	
	onResizeEnd(event: ResizeEvent): void {
		this.messagePanelHeight = event.rectangle.height;
		document.getElementById("message-panel-container").style.height = this.messagePanelHeight + "px";
		//alert(this.messagePanelHeight);
	}
	
	reloadMessages(reset: boolean){
		
		clearTimeout(this.messageReloadTimeoutId);
		//console.log("start reloadMessages.  _isLogged:" + (this._isLogged === true));
		if(this._isLogged === true){
			
			this.subscribeService();
			this.messageService.loadMessages(reset);
			
		}
				
	}
	
	showWorkflowView(identity){
	  
		for(var index in this.messages){
			if(this.messages[index].workflowIdentity == identity){
				this.viewWorkflowModel = this.messages[index].workflow;
				this.viewWorkflow = true;
				break;
			}
		}
  		
  	}
	
	hideViewModal(){
		this.viewWorkflow = false;
  	}
	
	assignWorkflowMe(workflowIdentity){
		
		this.messageService.assignMe(workflowIdentity).subscribe(
		        val => {
		        	console.log("Workflow assigned to me");
		        	this.reloadMessages(true);
		            
		        },
		        response => {
		        	console.log("Error in assigning workflow", response);
		  			this.errorService.showErrorResponse(response);
		        	
		        },
		        () => {
		        	this.viewWorkflow = false;
		        }
	    	);	      
		
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
  					
		  		},
		  		error => {
		  			//console.log("Error in read message list.", error);
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
