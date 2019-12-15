﻿
import { WorkflowType } from '../wf-models/workflowtype';
import { User } from './user';
import { MenuItem } from './menuitem';
import { Company } from './company';


	  
export interface UserGeneralData {
	currentUser: User;
	
}

export interface AppGeneralData {
	menus: MenuItem[];
	
}

export interface CompanyGeneralData {
	departments: Object[];
	users: User[];
	company: Company;
	
}

export interface WorkflowGeneralData {
	worlflowTypes: WorkflowType[];
	
}

export interface GeneralData {
	isLogged: boolean;
	Workflow: WorkflowGeneralData;
	company: CompanyGeneralData;
	app: AppGeneralData;
	user: UserGeneralData;
	
}
