import { Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

import { OcrWord } from '../../ui-models';

@Component({
  selector: 'app-invoice-ocr-detail',
  templateUrl: './invoice-ocr-detail.component.html',
  styleUrls: ['./invoice-ocr-detail.component.css']
})
export class InvoiceOcrDetailComponent implements OnInit {

	private _foundWords :OcrWord[] = [];
	propertyLabels :string[] = [];

	@Input('showOcrDetails') showOcrDetails :boolean = false;
	@Input('scanedPdfPath') scanedPdfPath :string = "";
	@Input('scanedHocrPath') scanedHocrPath :string = "";
	
	@Input('foundWords')
	set foundWords(foundWordsInput :OcrWord[]) {
	    this._foundWords = foundWordsInput;
	    
	    this.propertyLabels = [];
	    
	    if(this._foundWords){
	    	for(var key in  this._foundWords){
	    		this.translate.get(key).subscribe((res: string) => {
		    		this.propertyLabels[key] = res;
		        });
	    	}
	    }
	    
	}
	// /general/data/file/view/YzovdXBsb2FkL3RlbXAvMjAyMC8xMi8zMC90ZW1wXzE1Nzc3NDE5NjE5MDEuanBn
	
	
	get foundWords():OcrWord[] {
	    return this._foundWords;
	}
	
	get keys() {
	    return Object.keys(this._foundWords);
	}
	
	get fileViewUrl():string {
		return '/general/data/file/view/' + this.scanedPdfPath;
	}
		
	
	@Output() applyValues = new EventEmitter<boolean>();

	constructor(protected translate: TranslateService,) { 
		
	}

	ngOnInit() {
		
	}

	applySelectedValues() {
		this.applyValues.emit(true);
	}

}
