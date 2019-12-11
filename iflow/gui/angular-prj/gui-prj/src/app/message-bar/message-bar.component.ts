import { Component, OnInit } from '@angular/core';

import { WorkflowMessage } from '../wf-models';
import { User, MenuItem, IComponent } from '../ui-models';
import { GlobalService } from '../helper/global.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-message-bar',
  templateUrl: './message-bar.component.html',
  styleUrls: ['./message-bar.component.css']
})
export class MessageBarComponent implements OnInit, IComponent {

	messages: WorkflowMessage[] = [];
  	constructor(private router: Router, private global: GlobalService) { }

	menus: MenuItem[] = [];
	currentUser: User = null;


	ngOnInit() {
		
		this.router.events
	    .subscribe((event) => {
	      this.global.getMenus(this);
	    });
		
	}
  
  	showWorkflowView(id){
	  
  	}

	get isLogedIn() { return this.currentUser != null; }

}
