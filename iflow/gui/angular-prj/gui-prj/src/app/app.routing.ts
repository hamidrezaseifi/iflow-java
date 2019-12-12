import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { AboutComponent } from './about';
import { LoginComponent } from './login';
import { WorkflowCreateComponent } from './workflow-create/workflow-create.component';
import { WorkflowListComponent } from './workflow-list/workflow-list.component';

const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'about', component: AboutComponent },
    { path: 'workflow/list', component: WorkflowListComponent },
    { path: 'workflow/create', component: WorkflowCreateComponent },
    { path: 'auth/login', component: LoginComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const appRoutingModule = RouterModule.forRoot(routes);