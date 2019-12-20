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
	
	isReloadingMessages : boolean = false;

	
	debugData() :string{
		return (this.viewWorkflowModel && this.viewWorkflowModel != null) ? JSON.stringify(this.viewWorkflowModel) : 'no data';
	}
	
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
			
			this.isReloadingMessages = true;
			this.messageService.loadMessages(reset).subscribe(
			        (messageList :WorkflowMessage[]) => {
			        	console.log("Read message list", messageList);
			        	
			        	this.messages = messageList;			            
			        },
			        response => {
			        	console.log("Error in read message list", response);
			        	this.messages = [];	
			        	
			        },
			        () => {
			        	
			        	setTimeout(()=>{ 
			        		this.isReloadingMessages = false;
			        	 }, 500);
			        	
			        	this.messageReloadTimeoutId = setTimeout(() =>{ 			  				
		  					this.reloadMessages(false);		  				 
			        	}, this.messageSearchInterval);			        	
			        }
		    	);
			
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
	
	assignWorkflowMe(){
		
		this.messageService.assignMe(this.viewWorkflowModel.identity).subscribe(
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
	
	editWorkflow(){
		
		this.viewWorkflow = false;
		this.router.navigate(['/workflow/edit/' + this.viewWorkflowModel.workflowType.identity + '/' + this.viewWorkflowModel.identity]);
		
		
  	}
  	
}
