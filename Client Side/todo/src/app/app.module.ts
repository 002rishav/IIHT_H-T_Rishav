import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StoreModule } from '@ngrx/store';
import { TodoReducer } from './reducers/todo.reducers';
import { TodoComponentComponent } from './components/todo-component/todo-component.component';
import { AddTodoComponentComponent } from './components/add-todo-component/add-todo-component.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponentComponent,
    AddTodoComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    StoreModule.forRoot({todos:TodoReducer})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
