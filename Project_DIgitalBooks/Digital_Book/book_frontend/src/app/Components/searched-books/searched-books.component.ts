import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from 'src/app/Services/book.service';

@Component({
  selector: 'app-searched-books',
  templateUrl: './searched-books.component.html',
  styleUrls: ['./searched-books.component.css']
})
export class SearchedBooksComponent {

  bookDetails:any = this.bookService.response;

  constructor(
    private bookService: BookService,
    private router : Router
    ) { }

  search(){
    this.bookService.response = null;
    this.router.navigate(['']);
  }
}
