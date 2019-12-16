import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { AboutComponent } from './about';
import { LoginComponent } from './login';
import { WorkflowCreateComponent } from './workflow-create/workflow-create.component';
import { WorkflowListComponent } from './workflow-list/workflow-list.component';
//import { AuthGuard } from './helper';
import { AuthenticationService } from './services/authentication.service';

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthenticationService] },
    { path: 'about', component: AboutComponent, canActivate: [AuthenticationService] },
    { path: 'workflow/list', component: WorkflowListComponent, canActivate: [AuthenticationService] },
    { path: 'workflow/create', component: WorkflowCreateComponent, canActivate: [AuthenticationService] },
    { path: 'auth/login', component: LoginComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '', canActivate: [AuthenticationService] }
];

export const appRoutingModule = RouterModule.forRoot(routes);