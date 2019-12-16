
import { User, LoginResponse } from '../ui-models';


export interface ILoginComponent {
  
	processLoginResult(loginResponse: LoginResponse);
	
	processFailedResult(responseObj: Object);
	
	processEndLoading();
	
	finishGeneralDataLoading();
}


//menus: MenuItem[], currentUser: User, departments: Object[], allUsers: User[]