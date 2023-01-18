import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Components/login/login.component';
import { AdminComponent } from './Components/admin/admin.component';
import { ForbiddenComponent } from './Components/forbidden/forbidden.component';
import { AuthGuard } from './Auth/auth.guard';
import { RegisterUserComponent } from './Components/register-user/register-user.component';
import { GetallbooksComponent } from './Components/getallbooks/getallbooks.component';

const routes: Routes = [
  { path: 'admin', component: AdminComponent, canActivate:[AuthGuard], data:{roles:['Merchant']} },
  { path: '', component: LoginComponent },
  { path: 'forbidden', component: ForbiddenComponent },
  { path: 'register_user', component: RegisterUserComponent },
  { path: 'getallbooks', component: GetallbooksComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
