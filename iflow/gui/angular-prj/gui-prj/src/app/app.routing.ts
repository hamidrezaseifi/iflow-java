import { Routes, RouterModule } from '@angular/router';

import { AuthenticationService } from './services/authentication.service';

import { HomeComponent } from './home';
import { AboutComponent } from './about';
import { LoginComponent } from './login';

import { WorkflowListComponent } from './wm-components/workflow-list/workflow-list.component';
import { WorkflowCreateComponent } from './wm-components/create/workflow-create/workflow-create.component';
import { CreateSingletaskComponent } from './wm-components/create/create-singletask/create-singletask.component';
import { CreateInvoiceComponent } from './wm-components/create/create-invoice/create-invoice.component';
import { CreateTestthreetaskComponent } from './wm-components/create/create-testthreetask/create-testthreetask.component';

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthenticationService] },
    { path: 'about', component: AboutComponent, canActivate: [AuthenticationService] },
    { path: 'workflow/list', component: WorkflowListComponent, canActivate: [AuthenticationService] },
    { path: 'workflow/create', component: WorkflowCreateComponent, canActivate: [AuthenticationService] },
    { path: 'workflow/singletask/create', component: CreateSingletaskComponent, canActivate: [AuthenticationService] },
    { path: 'workflow/invoice/create', component: CreateInvoiceComponent, canActivate: [AuthenticationService] },
    { path: 'workflow/testthreetask/create', component: CreateTestthreetaskComponent, canActivate: [AuthenticationService] },

    
    
    { path: 'auth/login', component: LoginComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '', canActivate: [AuthenticationService] }
];

export const appRoutingModule = RouterModule.forRoot(routes);