import { Component, OnInit } from '@angular/core';

import { WorkflowMessage } from '../wf-models';
import { User, MenuItem } from '../ui-models';
import { IGeneralDataComponent, GeneralLoadingComponent } from '../_components';
import { GlobalService } from '../helper/global.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-message-bar',
  templateUrl: './message-bar.component.html',
  styleUrls: ['./message-bar.component.css'],
  providers: [ GlobalService ]
})
export class MessageBarComponent extends GeneralLoadingComponent implements OnInit, IGeneralDataComponent {

	messages: WorkflowMessage[] = [];

	menus: MenuItem[] = [];
	currentUser: User = null;
	isLogged: boolean = false;

  	constructor(protected router: Router, protected global: GlobalService) { 
  		super(router, global);
  		
  	}

	ngOnInit() {
		super.ngOnInit();
		
	}
	
  	showWorkflowView(id){
	  
  	}


}
