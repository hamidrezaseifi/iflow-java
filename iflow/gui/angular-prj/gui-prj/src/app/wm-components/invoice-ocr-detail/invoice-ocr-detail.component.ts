import { Component, EventEmitter, Input, Output, OnInit, ViewChild, ElementRef, AfterViewInit  } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

import { OcrWord } from '../../ui-models';

@Component({
  selector: 'app-invoice-ocr-detail',
  templateUrl: './invoice-ocr-detail.component.html',
  styleUrls: ['./invoice-ocr-detail.component.css']
})
export class InvoiceOcrDetailComponent implements OnInit, AfterViewInit  {

	@ViewChild('scannedItemPreviewContainer', {static: false})previewContainer: ElementRef;
	
	private _foundWords :OcrWord[] = [];
	propertyLabels :string[] = [];
	
	@Input('showOcrDetails') showOcrDetails :boolean = false;
	@Input('scanedPdfPath') scanedPdfPath :string = "";
	@Input('scanedHocrPath') scanedHocrPath :string = "";
	@Input('fileIsPdf') fileIsPdf: boolean = true;
	@Input('fileIsImage') fileIsImage: boolean = false;
	@Input('imageSizeX') imageSizeX :number = 300;
	@Input('imageSizeY') imageSizeY :number = 500;

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
	
	pdfZoom :number = 1;
	showAllPages :boolean = true;
	pdfPageIndex :number = 1;
	showSelectedArea :boolean = false;
	selectedAreaWidth :number = 200;
	selectedAreaHeight :number = 100;
	selectedAreaLeft :number = 400;
	selectedAreaTop :number = 200;
	
	previewWidth :number = 600;
	previewHeight :number = 1100;
	
	private yScale :number = 1;
	private previewLeft :number = 1;
	private previewTop :number = 1;
	
	get foundWords():OcrWord[] {
		    return this._foundWords;
	}
		
	get keys() {
	    return Object.keys(this._foundWords);
	}
	
	get fileViewUrl():string {
		return 'url(/general/data/file/view/' + this.scanedPdfPath + ')';
		//return 'url()';
	}
		
	
	@Output() applyValues = new EventEmitter<boolean>();

	constructor(protected translate: TranslateService,) { 
		
	}

	ngOnInit() {
		
	}
	
	ngAfterViewInit() {
		
		setTimeout(()=>{
			this.previewLeft = this.previewContainer.nativeElement.offsetLeft + 10;
			this.previewTop = this.previewContainer.nativeElement.offsetTop;
			this.yScale = this.previewWidth / this.imageSizeX;
			this.previewHeight = this.yScale * this.imageSizeY;
		 }, 100);
		
	}

	applySelectedValues() {
		this.applyValues.emit(true);
	}
	
	selectFoundWord(foundWord :OcrWord){
		
		//alert(this.previewContainer.nativeElement.offsetHeight);
		//alert(this.previewContainer.nativeElement.offsetWidth);
		
		this.pdfPageIndex = foundWord.pageIndex;
		
		var wordBox = foundWord.box;
		var valueBox = foundWord.value.box;
		var selectWidth = valueBox.right - wordBox.left;
		var selectHeight = valueBox.bottom - wordBox.top;
		
		this.showSelectedArea = true;
		this.selectedAreaWidth = selectWidth * this.yScale + 8;
		this.selectedAreaHeight = selectHeight * this.yScale + 8;
		this.selectedAreaLeft = this.previewLeft + (wordBox.left * this.yScale) - 4;
		this.selectedAreaTop = this.previewTop + (wordBox.top * this.yScale) - 4;
	}
	
	selectDetailItem(key :string){
		
		
		this.showSelectedArea = false;
		
	}

}
