
import { User, LoginResponse } from '../ui-models';


export interface ILoginComponent {
  
	processLoginResult(loginResponse: LoginResponse);
	
	processFailedResult(responseObj: Object);
	
	processEndLoading();
	
}


//menus: MenuItem[], currentUser: User, departments: Object[], allUsers: User[]