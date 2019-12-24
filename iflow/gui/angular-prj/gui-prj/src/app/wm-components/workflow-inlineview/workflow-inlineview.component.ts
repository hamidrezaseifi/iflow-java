import { Component, OnInit, Input } from '@angular/core';

import { WorkflowType, Workflow, WorkflowTypeStep } from '../../wf-models';
import { User, GeneralData } from '../../ui-models';

@Component({
  selector: 'app-workflow-inlineview',
  templateUrl: './workflow-inlineview.component.html',
  styleUrls: ['./workflow-inlineview.component.css']
})
export class WorkflowInlineviewComponent implements OnInit {

	@Input('workflow') 
	viewWorkflowModel :Workflow;

	constructor() { }

	ngOnInit() {
	}

}
