
export class DashboardCube {
  menuId: string = "";
	text: string = "";
	image: string = "";
	url: string = "";
  row: number = 0;
  column: number = 0;
  status: number = 0;
  version: number = 0;
  	
	hasImage() : boolean{
	  return this.image != null && this.image != '';
	}
}

