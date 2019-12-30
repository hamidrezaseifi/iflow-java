
export interface OcrWord {
	
	box :OcrBox;
	isStrong: boolean;
	text: string;
	id: string;
	title: string;
	className: string;
	values :OcrWord[];
}

export interface OcrBox {
	left :number;
	right :number;
	top :number;
	bottom :number;
}
