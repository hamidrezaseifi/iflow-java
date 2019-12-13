import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { AboutComponent } from './about';
import { LoginComponent, LogoutComponent } from './login';
import { WorkflowCreateComponent } from './workflow-create/workflow-create.component';
import { WorkflowListComponent } from './workflow-list/workflow-list.component';
import { AuthGuard } from './helper';

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'about', component: AboutComponent, canActivate: [AuthGuard] },
    { path: 'workflow/list', component: WorkflowListComponent, canActivate: [AuthGuard] },
    { path: 'workflow/create', component: WorkflowCreateComponent, canActivate: [AuthGuard] },
    { path: 'auth/login', component: LoginComponent },
    { path: 'logout', component: LogoutComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '', canActivate: [AuthGuard] }
];

export const appRoutingModule = RouterModule.forRoot(routes);