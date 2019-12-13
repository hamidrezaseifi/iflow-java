import { Component, OnInit, Input } from '@angular/core';

import { WorkflowMessage } from '../wf-models';
import { User, MenuItem } from '../ui-models';
import { GlobalService } from '../helper/global.service';
import { Router } from '@angular/router';
import * as moment from 'moment'; 

@Component({
  selector: 'app-message-bar',
  templateUrl: './message-bar.component.html',
  styleUrls: ['./message-bar.component.css'],
  providers: [ GlobalService ]
})
export class MessageBarComponent implements OnInit {

	messages: WorkflowMessage[] = [];

	@Input('currentUser') currentUser: User;
	@Input('isLogged') isLogged: boolean;

	constructor(protected router: Router) { 
		
	}
	

	ngOnInit() {
		
	}
	
  	showWorkflowView(id){
	  
  	}


}
