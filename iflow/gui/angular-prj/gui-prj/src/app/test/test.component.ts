import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpParams } from "@angular/common/http";
import { Observable, throwError , Subscription } from 'rxjs';
import { StompService, StompState } from '@stomp/ng2-stompjs';
import { Message } from '@stomp/stompjs';

import { GlobalService } from '../services/global.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit, OnDestroy {

	sending = false;
	status = "Not Connected";
	response = "";
	message = "";
	
	private subscription: Subscription;
	private messages: Observable<Message>;

	public subscribed: boolean;
	public messageQeue: string[] = [];
	
	public state: Observable<StompState>;
	
	stompClient = null;

	constructor(private _stompService: StompService) { 
		
		
	}

	ngOnInit() {
		this.setConnected(false);
		
	}
	
	ngOnDestroy() {
	    this.unsubscribe();
	}

	public on_next = (message: Message) => {

		console.log("My Message: " , message.body);
		this.messageQeue.push(message.body + '\n');
		this.sending = false;
	}	

	subscribe() {
		
		if (this.subscribed) {
		      return;
		}

		this.messages = this._stompService.subscribe('/socket/test');

	    this.subscription = this.messages.subscribe(this.on_next);

	    this.setConnected(true);
		
	}

	unsubscribe() {
	    if (!this.subscribed) {
	      return;
	    }

	    // This will internally unsubscribe from Stomp Broker
	    // There are two subscriptions - one created explicitly, the other created in the template by use of 'async'
	    this.subscription.unsubscribe();
	    this.subscription = null;
	    this.messages = null;

	    this.setConnected(false);
	}

	
	send() {
		this.sending = true;

		this._stompService.publish('/socketapp/start', JSON.stringify({'sentMessage': this.message}));
		
		this.message = "";
	        
	}	 
	
	private setConnected(subscribed) {
		this.subscribed = subscribed;
	    
		this.status = subscribed ? "Connected" : "Not Connected";
		this.response = "";
	}	
	
}
