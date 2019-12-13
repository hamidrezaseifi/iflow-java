import { User } from './user';

export class LoginResponse {
	timestamp: string;
	exception:string;
	message:string;
	res:string;
	user:User;
}