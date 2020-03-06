import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import $ from "jquery";

import { GlobalService } from '../services/global.service';

import { DashboardCube, GeneralData, MenuItem } from '../ui-models';

@Component({
  selector: 'app-root',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
    

		isPresentObs :Observable<boolean> = null;

		isPresent : boolean = true;
		
		totalColumns: number = 10;
		totalRows: number = 6;

		cubes : DashboardCube[][] = [];
		
		menus: MenuItem[] = [];
		
		showSelectMenuDialog : boolean = false;
		showedSubMenu : any[] = [];
		selectedCube :DashboardCube = null;
	
    constructor(private global: GlobalService,) {
      this.isPresentObs = this.global.presensSubject.asObservable();
    }

    ngOnInit() {
      
      this.isPresentObs.subscribe((res: boolean) => {
      	this.isPresent = res;
      });
      
      this.global.currentSessionDataSubject.asObservable().subscribe((res: GeneralData) => {
      	this.menus = res.app.menus;
      });
      
      for(var r = 0; r < this.totalRows; r ++){
        var cubelist : DashboardCube[] = [];
        for(var c = 0; c < this.totalColumns; c ++){
          var cube : DashboardCube = new DashboardCube();
        	cube.text = "Cube " + r + "-" + c;
        	cube.url = "/#" + r + "-" + c;
        	cube.row = r;
        	cube.column = c;
        
          cubelist.push(cube);
        }
        
        this.cubes.push(cubelist);
      }
      
    }
    
    getMenuItemTreeData(){
      
    }
    
    
    selectMenuItem(cube:DashboardCube){
      
      this.selectedCube = cube;
      this.showSelectMenuDialog = true;
    }
    
    showMenuDialog(){
      this.showSelectMenuDialog = true;
    }
    
    hideMenuDialog(){
      this.showSelectMenuDialog = false;
    }
    
    isSubMenuShowed(id: string):boolean{
      
      for(var index in this.showedSubMenu){
        if(this.showedSubMenu[index].id === id){
          
          return this.showedSubMenu[index].show;
        }
      }
      
      this.showedSubMenu.push({"id" : id, "show" : false});
          
      return false;
    }
    
    toggleSubMenuShowed(id: string):boolean{
      
      for(var index in this.showedSubMenu){
        if(this.showedSubMenu[index].id === id){
                 
          this.showedSubMenu[index].show = !this.showedSubMenu[index].show;
          return;
        }
      }
      
      this.showedSubMenu.push({"id" : id, "show" : false});
      
    }
    
    selectMenuItemForCube(menu){
      
      this.hideMenuDialog();
    }
    

}