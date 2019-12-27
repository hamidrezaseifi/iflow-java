import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import * as moment from 'moment'; 
import { ResizeEvent } from 'angular-resizable-element';
import { Observable, throwError , Subscription } from 'rxjs';
import { StompService, StompState } from '@stomp/ng2-stompjs';
import { Message } from '@stomp/stompjs';

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
export class MessageBarComponent implements OnInit, OnDestroy {

	messages: WorkflowMessage[] = [];
	viewWorkflowModel :Workflow;
	viewWorkflow :boolean = false;

	messageSearchInterval = 60000;
	messageReloadTimeoutId = 0;
	messagePanelHeight = 170;
	messagePanelShowed :boolean= true;
	
	isReloadingMessages : boolean = false;

	private subscription: Subscription;

	public status = "Not Connected";
	public subscribed: boolean;
	public requesting : boolean = false;
	private socketMessages: Observable<Message>;
	private state: Observable<StompState>;
	
	private stompClient = null;
	
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
		
		if(this._isLogged === true){			
			this.subscribe();
			this.readMessageList(true);
	    }
		else{
			this.unsubscribe();
		}
		
	}
	
	
	get isAppLogged(): boolean { 
		return this._isLogged; 
	}	

	
	constructor(protected router: Router, 
			private messageService :WorkflowMessageService,
			private errorService: ErrorServiceService,
			private _stompService: StompService,) { 
		
	}
	

	ngOnInit() {		
		
		if(this._isLogged === true){
			this.subscribe();
			this.readMessageList(true);
	    }
	}
	
	ngOnDestroy() {
	    this.unsubscribe();
	}
	
	onResizeEnd(event: ResizeEvent): void {
		this.messagePanelHeight = event.rectangle.height;
		document.getElementById("message-panel-container").style.height = this.messagePanelHeight + "px";
	}
	
	private readMessageList(reset: boolean){
		
		clearTimeout(this.messageReloadTimeoutId);
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
			        	this.isReloadingMessages = false;
			        },
			        () => {
			        	
			        	setTimeout(()=>{ 
			        		this.isReloadingMessages = false;
			        	 }, 500);
			        	
			        	/*this.messageReloadTimeoutId = setTimeout(() =>{ 			  				
		  					this.reloadMessages(false);		  				 
			        	}, this.messageSearchInterval);	*/		        	
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
	
	private setConnected(subscribed) {
		this.subscribed = subscribed;
	    
		this.status = subscribed ? "Connected" : "Not Connected";
	}	
	
	private subscribe() {
		
		if (this.subscribed) {
		      return;
		}

		this.socketMessages = this._stompService.subscribe('/user/socket/messages');

		console.log("Subscribe Message: " , this.socketMessages);
		
	    this.subscription = this.socketMessages.subscribe(this.receiveMessage);

	    this.setConnected(true);
		
	}
	
	public receiveMessage = (message: Message) => {

		this.requesting = false;
		
		console.log("Socket Message: " , message.body);
		var parsedMessage = JSON.parse(message.body);
		console.log("Parsed Message: " , parsedMessage);
		
		if(parsedMessage.action && parsedMessage.action === "message-reload"){
			this.readMessageList(false);			
		}
	}	

	reloadMessages(){
		this.readMessageList(true);
	}
	
	private unsubscribe() {
	    if (!this.subscribed) {
	      return;
	    }

	    this.subscription.unsubscribe();
	    this.subscription = null;
	    this.messages = null;

	    this.setConnected(false);
	}
  	
}
