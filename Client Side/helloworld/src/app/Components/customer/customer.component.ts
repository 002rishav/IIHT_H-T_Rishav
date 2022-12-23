import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customers : string[] = [];
  name="";
  constructor() { }

  ngOnInit(): void {
  }
  addCustomer(value:any){
    if(value === ""){
      console.log("empty name");
    }else{
      this.customers.push(value);
      this.name=""; 
    }
  }

}
