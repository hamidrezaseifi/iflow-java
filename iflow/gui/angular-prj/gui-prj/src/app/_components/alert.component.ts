import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';


@Component({ selector: 'alert', templateUrl: 'alert.component.html' })
export class AlertComponent implements OnInit, OnDestroy {
    message: any;

    constructor() { }

    ngOnInit() {
    	
    }

    ngOnDestroy() {
       
    }
}