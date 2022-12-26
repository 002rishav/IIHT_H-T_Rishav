import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from 'src/app/Services/book.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  bookDetails:any;

  constructor(
    private bookService: BookService,
    private router: Router
    ) { }

  searchForm = new FormGroup({
    category: new FormControl("", [Validators.pattern("^[a-zA-Z ]*$")]),
    title: new FormControl("",[Validators.pattern("^[a-zA-Z ]*$")]),
    price: new FormControl("", [Validators.required, Validators.pattern("^[0-9]+(\.[0-9]+)?$")]),
    author: new FormControl("", [Validators.pattern("^[a-zA-Z ]*$")]),
    publisher: new FormControl("",[Validators.pattern("^[a-zA-Z ]*$")])
  });
  
  get Category(): FormControl{
    return this.searchForm.get("category") as FormControl;
  }
  get Title(): FormControl{
    return this.searchForm.get("title") as FormControl;
  }
  get Author(): FormControl{
    return this.searchForm.get("author") as FormControl;
  }
  get Price(): FormControl{
    return this.searchForm.get("price") as FormControl;
  }
  get Publisher(): FormControl{
    return this.searchForm.get("publisher") as FormControl;
  }
  
  search(searchForm:any){
    this.bookService.search(searchForm.get("category").value,searchForm.get("title").value,searchForm.get("author").value,searchForm.get("price").value,searchForm.get("publisher").value).subscribe(
      (resp) => {
        console.log(resp);
        this.bookService.response = resp;
        this.router.navigate(['/searched_books']);
      },
      (err) => {
        console.log(err);
      }
    );
  }
  
  ngOnInit(): void {
  }
}
