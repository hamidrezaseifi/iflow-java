import { UserAccessType } from './user-access';
import { UserDepartment } from './user-department';
import { UserDepartmentGroup } from './user-department-group';

﻿export class User {
	identity: string;
	birthDate: string;
	email: string;
    username: string;
	firstName: string;
    lastName: string;
	fullName: string;
	status: number;
	companyIdentity: string;
	userAccess: UserAccessType;
	userAccessLabel: string;
	password: string;

	userDepartments: UserDepartment[] = [];
	userDepartmentGroups: UserDepartmentGroup[] = [];

	groups: string[] = [];
	deputies: string[] = [];

}


