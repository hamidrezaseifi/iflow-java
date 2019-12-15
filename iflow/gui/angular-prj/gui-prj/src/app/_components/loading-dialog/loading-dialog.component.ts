import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-loading-dialog',
  templateUrl: './loading-dialog.component.html',
  styleUrls: ['./loading-dialog.component.css']
})
export class LoadingDialogComponent implements OnInit {

	_showLoading : boolean = false;

	@Input('appShowLoading')
	set appShowLoading(value: string) {
	    
		this._showLoading = value === 'true';
		
	}
	
	
	get showLoading(): boolean { 
		return this._showLoading; 
	}	

	
	constructor() { }

	ngOnInit() {
	}

}
