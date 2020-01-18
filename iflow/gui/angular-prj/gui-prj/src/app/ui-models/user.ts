import { UserAccessType } from './user-access';

﻿export class User {
	identity: string;
	birthDate: string;
	email: string;
    username: string;
    password: string;
	firstName: string;
    lastName: string;
	fullName: string;
	status: number;
	companyIdentity: string;
	userAccess: UserAccessType;
	userAccessLabel: string;

}

