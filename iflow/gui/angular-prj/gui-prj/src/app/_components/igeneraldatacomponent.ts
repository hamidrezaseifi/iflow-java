
import { User, MenuItem } from '../ui-models';


export interface IGeneralDataComponent {
  
	setGeneralData(menus: MenuItem[], currentUser: User, departments: Object[], allUsers: User[], isLogged:any);

}


//menus: MenuItem[], currentUser: User, departments: Object[], allUsers: User[]