
import { DepartmentGroup } from './department-group';

export interface Department {
	identity: string;
	title: string;
	status: number;

	departmentGroups : DepartmentGroup[]; 
  	
}