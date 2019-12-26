import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TranslateModule, TranslateLoader} from '@ngx-translate/core';
import { TranslateHttpLoader} from '@ngx-translate/http-loader';
import { ResizableModule } from 'angular-resizable-element';
import { FormsModule } from '@angular/forms';
import { DataTableModule } from 'ng-angular8-datatable';
import { MatNativeDateModule } from '@angular/material/core';
import {StompConfig, StompService} from '@stomp/ng2-stompjs';
import * as SockJS from 'sockjs-client';

import {IFlowMaterialModules} from './material-module';

import { fakeBackendProvider } from './helper';

import { AppComponent } from './app.component';
import { appRoutingModule } from './app.routing';
import { GlobalService } from './services/global.service';
import { AuthenticationService } from './services/authentication.service';
import { WorkflowMessageService } from './services/workflow/workflow-message.service';


import { TopBarComponent } from './top-bar/top-bar.component';
import { FooterComponent } from './footer/footer.component';
import { MessageBarComponent } from './message-bar/message-bar.component';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { LoadingDialogComponent } from './components/loading-dialog/loading-dialog.component';

import { HomeComponent } from './home';
import { AboutComponent } from './about';
import { LoginComponent } from './login';
import { WorkflowListComponent } from './wm-components/workflow-list/workflow-list.component';
import { WorkflowCreateComponent } from './wm-components/create/workflow-create/workflow-create.component';
import { CreateSingletaskComponent } from './wm-components/create/create-singletask/create-singletask.component';
import { CreateInvoiceComponent } from './wm-components/create/create-invoice/create-invoice.component';
import { CreateTestthreetaskComponent } from './wm-components/create/create-testthreetask/create-testthreetask.component';
import { EditInvoiceComponent } from './wm-components/edit/edit-invoice/edit-invoice.component';
import { EditSingleTaskComponent } from './wm-components/edit/edit-single-task/edit-single-task.component';
import { EditTestthreeTaskComponent } from './wm-components/edit/edit-testthree-task/edit-testthree-task.component';
import { WorkflowInlineviewComponent } from './wm-components/workflow-inlineview/workflow-inlineview.component';
import { SelectUserComponent } from './components/select-user/select-user.component';
import { TestComponent } from './test/test.component';

export function createTranslateLoader(http: HttpClient) {
    return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

export function socketProvider() {
	  return new SockJS('/iflow-guide-websocket');
	}

const stompConfig: StompConfig = {
	// Which server?
	url: socketProvider, //'ws://127.0.0.1:15674/ws',

	// Headers
	// Typical keys: login, passcode, host
	headers: {
		login: 'guest',
		passcode: 'guest'
	},

	// How often to heartbeat?
	// Interval in milliseconds, set to 0 to disable
	heartbeat_in: 0, // Typical value 0 - disabled
	heartbeat_out: 20000, // Typical value 20000 - every 20 seconds

	// Wait in milliseconds before attempting auto reconnect
	// Set to 0 to disable
	// Typical value 5000 (5 seconds)
	reconnect_delay: 5000,

	// Will log diagnostics on console
	debug: true
};


@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    appRoutingModule,
    BrowserAnimationsModule,
    ResizableModule,
    DataTableModule,
    MatNativeDateModule,
    IFlowMaterialModules,
    FormsModule,
    TranslateModule.forRoot({
        loader: {
            provide: TranslateLoader,
            useFactory: (createTranslateLoader),
            deps: [HttpClient]
        }
    }),
  ],
  declarations: [
    AppComponent,
    TopBarComponent,
    FooterComponent,
    MessageBarComponent,
    ErrorDialogComponent,
    LoadingDialogComponent,
    HomeComponent,
    AboutComponent,
    LoginComponent,
    WorkflowCreateComponent,
    WorkflowListComponent,
    CreateSingletaskComponent,
    CreateInvoiceComponent,
    CreateTestthreetaskComponent,
    EditInvoiceComponent,
    EditSingleTaskComponent,
    EditTestthreeTaskComponent,
    WorkflowInlineviewComponent,
    SelectUserComponent,
    TestComponent,
    
  ],
  providers: [
	  GlobalService, 
	  AuthenticationService, 
	  WorkflowMessageService, 
	  fakeBackendProvider,
	  StompService,
	    {
	      provide: StompConfig,
	      useValue: stompConfig
	    }
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/