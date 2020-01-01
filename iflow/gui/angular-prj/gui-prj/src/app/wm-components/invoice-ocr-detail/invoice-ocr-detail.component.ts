import { Component, EventEmitter, Input, Output, OnInit, ViewChild, ElementRef, AfterViewInit  } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

import { OcrWord, OcrBox } from '../../ui-models';

@Component({
  selector: 'app-invoice-ocr-detail',
  templateUrl: './invoice-ocr-detail.component.html',
  styleUrls: ['./invoice-ocr-detail.component.css']
})
export class InvoiceOcrDetailComponent implements OnInit, AfterViewInit  {

	@ViewChild('scannedItemPreviewContainer', {static: false})previewContainer: ElementRef;
	
	private _foundWords :OcrWord[] = [];
	propertyLabels :string[] = [];
	isEditing :boolean[] = [];
	
	selectedKey :string = "";
	selectedWord :OcrWord = null;
	
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
		    		this.isEditing[key] = false;
		    		this.editedValues[key] = "";
		        });
	    	}
	    }
	    
	}
	
	@Input('editedValues') editedValues :string[] = [];

	@Output() onApplyValues = new EventEmitter<string[]>();

	
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
		
	isWordSelected(foundWord :OcrWord):boolean{
		if(this.selectedWord != null && foundWord != null && this.selectedWord.id === foundWord.id){
			return true;
		}
		return false;
	}
	
	get debugData():string[]{
		return this.editedValues;
	}
	
	constructor(protected translate: TranslateService,) { 
		
	}

	ngOnInit() {
		
	}
	
	ngAfterViewInit() {
		
		this.yScale = this.previewWidth / this.imageSizeX;
		this.previewHeight = this.yScale * this.imageSizeY;
		
		setTimeout(()=>{
			
		 }, 100);
		
	}
	
	selectFoundWord(foundWord :OcrWord){
		
		this.selectedWord = foundWord;
		
		var previewLeft = this.previewContainer.nativeElement.offsetLeft + 10;
		var previewTop = this.previewContainer.nativeElement.offsetTop + 10;
		
		var xscale = (this.previewContainer.nativeElement.offsetWidth - 20) / this.imageSizeX;
		var yscale = (this.previewContainer.nativeElement.offsetHeight - 20) / this.imageSizeY;
		
		
		this.pdfPageIndex = foundWord.pageIndex;
		
		var wordBox = foundWord.box;
		var valueBox = foundWord.value.box;
		
		var selectBox :OcrBox= this.getSelectBox(foundWord);
		
		this.selectedAreaWidth = selectBox.width * xscale + 8;
		this.selectedAreaHeight = selectBox.height * yscale + 8;
				
		this.selectedAreaLeft = previewLeft + (selectBox.left * xscale) - 4;
		this.selectedAreaTop = previewTop + (selectBox.top * yscale) - 4;
		
		var scalestr = "scale         : " + xscale + " : " +  yscale + "\n";
		scalestr += "wordBox       : " + wordBox.left + " : " + wordBox.top + " : " + wordBox.width + " : " + wordBox.height + "\n";
		scalestr += "valueBox      : " + valueBox.left + " : " + valueBox.top + " : " + valueBox.width + " : " + valueBox.height + " : " + foundWord.value.text + "\n";
		scalestr += "selectBox     : " + selectBox.left + " : " + selectBox.top + " : " + selectBox.width + " : " + selectBox.height + "\n";
		scalestr += "calc dimention: " + this.selectedAreaWidth + " : " + this.selectedAreaHeight + "\n";
		scalestr += "calc position : " + this.selectedAreaLeft + " : " + this.selectedAreaTop + "\n";
		
		console.log(scalestr );
		
		this.showSelectedArea = true;
	}
	
	selectDetailItem(key :string){
		
		this.selectedKey = key;
		
		this.showSelectedArea = false;
		
	}
	
	private getSelectBox(foundWord :OcrWord):OcrBox{
		var wordBox = foundWord.box;
		var valueBox = foundWord.value.box;
		
		var box: OcrBox = new OcrBox;
		
		box.width = Math.abs(valueBox.right - wordBox.left);
		box.height = Math.abs(valueBox.bottom - wordBox.top);
		box.left = Math.min(wordBox.left, valueBox.left);
		box.top = Math.min(wordBox.top, valueBox.top);
		
		box.right = box.left + box.width;
		box.bottom = box.top + box.height;
		
		return box;
	} 
	
	startEditKey(key:string){
		this.isEditing[key] = true;
		document.getElementById("valueeditbox" + key).focus();
	}
	
	useFoundWord(foundWord :OcrWord){
		this.editedValues[this.selectedKey] = foundWord.value.text;
	}
		

}
