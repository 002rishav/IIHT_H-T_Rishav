import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { TodoAdd } from 'src/app/actions/todo.action';
import { Todo } from 'src/app/models/Todo';

@Component({
  selector: 'app-add-todo-component',
  templateUrl: './add-todo-component.component.html',
  styleUrls: ['./add-todo-component.component.css']
})
export class AddTodoComponentComponent implements OnInit {

  constructor(private store:Store<{todos:Todo[]}>) { }

  AddTodo(todo:string) {
    const newTodo = new Todo();
    newTodo.title= todo;
    this.store.dispatch(new TodoAdd(newTodo));
  }


  ngOnInit(): void {
  }

}
