import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { appRoutingModule } from './app.routing';
import { GlobalService } from './helper/global.service';


import { AlertComponent } from './_components';
import { TopBarComponent } from './top-bar/top-bar.component';
import { FooterComponent } from './footer/footer.component';
import { MessageBarComponent } from './message-bar/message-bar.component';

import { HomeComponent } from './home';
import { AboutComponent } from './about';
import { LoginComponent, LogoutComponent } from './login';
import { WorkflowCreateComponent } from './workflow-create/workflow-create.component';
import { WorkflowListComponent } from './workflow-list/workflow-list.component';

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    appRoutingModule,
    BrowserAnimationsModule
  ],
  declarations: [
    AppComponent,
    TopBarComponent,
    FooterComponent,
    AlertComponent,
    MessageBarComponent,
    HomeComponent,
    AboutComponent,
    LoginComponent,
    LogoutComponent,
    WorkflowCreateComponent,
    WorkflowListComponent,
    
  ],
  providers: [GlobalService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/