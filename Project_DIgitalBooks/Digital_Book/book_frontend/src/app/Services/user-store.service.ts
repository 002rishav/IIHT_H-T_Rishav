import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserStoreService {

  private userName$ = new BehaviorSubject<string>("");
  constructor() { }

  public getuserNameFromStore(){
    return this.userName$.asObservable();
  }

  public setuserNameForStore(username: string){
    this.userName$.next(username);
  }

}
