import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.css']
})
export class PipesComponent implements OnInit {

  employee = {
    "name" : "John Mcmilan",
    "BaseSalary" : 55000000,
    "JoinedOn" : Date.now(),
    "Qualification" : "BTech",
    "About" : "John Wick, a retired hitman, is forced to return to his old ways after a group of Russian gangsters steal his car and kill a puppy gifted to him by his late wife.",
    "WinningPercentage" : 35/100
  }

  param:string = "";

  constructor() { }

  // show(){
  //   if(this.employee.About.length == 30){
  //     return this.employee.About;
  //   }
  //   return this.employee.About.substring(0,30) + "...";
  // }

  ngOnInit(): void {
  }

}
