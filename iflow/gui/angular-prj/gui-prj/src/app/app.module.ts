import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {TranslateModule, TranslateLoader} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import { ResizableModule } from 'angular-resizable-element';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { appRoutingModule } from './app.routing';
import { GlobalService } from './services/global.service';
import { AuthenticationService } from './services/authentication.service';
import { WorkflowMessageService } from './services/workflow/workflow-message.service';


import { AlertComponent } from './_components';
import { TopBarComponent } from './top-bar/top-bar.component';
import { FooterComponent } from './footer/footer.component';
import { MessageBarComponent } from './message-bar/message-bar.component';
import { ErrorDialogComponent } from './_components/error-dialog/error-dialog.component';
import { LoadingDialogComponent } from './_components/loading-dialog/loading-dialog.component';

import { HomeComponent } from './home';
import { AboutComponent } from './about';
import { LoginComponent } from './login';
import { WorkflowCreateComponent } from './workflow-create/workflow-create.component';
import { WorkflowListComponent } from './workflow-list/workflow-list.component';

export function createTranslateLoader(http: HttpClient) {
    return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    appRoutingModule,
    BrowserAnimationsModule,
    ResizableModule,
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
    AlertComponent,
    MessageBarComponent,
    ErrorDialogComponent,
    LoadingDialogComponent,
    HomeComponent,
    AboutComponent,
    LoginComponent,
    WorkflowCreateComponent,
    WorkflowListComponent,
    
  ],
  providers: [GlobalService, AuthenticationService, WorkflowMessageService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/