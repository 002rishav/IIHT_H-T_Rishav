import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { UserComponent } from './Components/user/user.component';
import { AdminComponent } from './Components/admin/admin.component';
import { ForbiddenComponent } from './Components/forbidden/forbidden.component';
import { AuthGuard } from './Auth/auth.guard';
import { SearchedBooksComponent } from './Components/searched-books/searched-books.component';
import { RegisterUserComponent } from './Components/register-user/register-user.component';
import { GetallbooksComponent } from './Components/getallbooks/getallbooks.component';
import { GetallsubscriptionsforuserComponent } from './Components/getallsubscriptionsforuser/getallsubscriptionsforuser.component';
import { SearchSubscriptionComponent } from './Components/search-subscription/search-subscription.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AdminComponent, canActivate:[AuthGuard], data:{roles:['Merchant']} },
  { path: 'user', component: UserComponent ,  canActivate:[AuthGuard], data:{roles:['User']} },
  { path: '', component: LoginComponent },
  { path: 'forbidden', component: ForbiddenComponent },
  { path: 'searched_books', component: SearchedBooksComponent },
  { path: 'register_user', component: RegisterUserComponent },
  { path: 'getallbooks', component: GetallbooksComponent },
  { path: 'getallsubscriptions', component: GetallsubscriptionsforuserComponent},
  { path: 'searchsubscriptions', component: SearchSubscriptionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
