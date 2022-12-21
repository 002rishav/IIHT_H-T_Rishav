import { ActionParent } from "../actions/todo.action";
import { Todo } from "../models/Todo";
import { TodoActionType } from "../shared/todo-action-types.enums";


const initialState:Todo [] =[
    {title:"title 1"},
    {title:"title 2"},
    {title:"title 3"}
];


export function TodoReducer(state = initialState, action: ActionParent) {
    switch (action.type) {
        case TodoActionType.Add:
            return [...state, action.payload];
        case TodoActionType.Remove:
            let newState = [...state];
            newState.splice(action.payload, 1);
            return newState;
        default:
            return state;
    }
}