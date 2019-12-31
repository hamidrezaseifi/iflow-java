
export interface OcrWord {
	
	box :OcrBox;
	isStrong: boolean;
	text: string;
	id: string;
	title: string;
	className: string;
	value :OcrWord;
	pageIndex :number;

}

export interface OcrBox {
	left :number;
	right :number;
	top :number;
	bottom :number;
	width :number;
	height :number;
}
