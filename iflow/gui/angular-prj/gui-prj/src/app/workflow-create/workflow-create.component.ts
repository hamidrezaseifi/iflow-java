import { Component } from '@angular/core';

import { products } from '../products';

@Component({
  selector: 'app-workflow-create',
  templateUrl: './workflow-create.component.html',
  styleUrls: ['./workflow-create.component.css']
})
export class WorkflowCreateComponent {
  products = products;

  share() {
    window.alert('The product has been shared!');
  }
  
  onNotify() {
	  window.alert('You will be notified when the product goes on sale');
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/