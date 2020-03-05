import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';

import { GlobalService } from '../services/global.service';

@Component({selector: 'app-root', templateUrl: 'home.component.html' })
export class HomeComponent implements OnInit {
    

		isPresentObs :Observable<boolean> = null;

		isPresent : boolean = true;

	
    constructor(private global: GlobalService,) {
      this.isPresentObs = this.global.presensSubject.asObservable();
    }

    ngOnInit() {
      this.isPresentObs.subscribe((res: boolean) => {
      	this.isPresent = res;
      });
    }

}