import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodoComponentComponent } from './components/todo-component/todo-component.component';
import { Todo } from './models/Todo';

const routes: Routes = [
  {path: 'todo', component: TodoComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
