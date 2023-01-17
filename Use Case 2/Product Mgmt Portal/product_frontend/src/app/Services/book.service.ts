import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  PATH_OF_API = 'http://localhost:9090';

  response :any;

  constructor(
    private httpClient: HttpClient,
    private auth: UserAuthService
    ) { }

  public search(category: string,title: string,author: string,price: number,publisher: string){
    // this.auth.setToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBbWV5MTEiLCJleHAiOjE3NzE1NTAxMDEsImlhdCI6MTY3MTUzMjEwMX0.O8hVrzwBtlE-ko85FN2OcYo1RZtPmKYh_GdvMfpvOT6L6svfLqS3JTEcfuW4peDIlMkf-XgQd4aKfEkv3rnP1A");
    // this.auth.setRoles();
    // console.log(this.auth.getToken());
    return this.httpClient.get(this.PATH_OF_API + '/search?category=' + category + '&title=' + 
      title + '&author=' + author +'&price=' + price +  '&publisher=' + publisher);
  }

  public addBook(bookData: any,username:String){
    return this.httpClient.post(this.PATH_OF_API + '/save/' +username, bookData);
  }

  public getallproducts(){
    return this.httpClient.get(this.PATH_OF_API + '/api/v1/AllProducts');
  }

  public updateproduct(productData: any, productId: string){
    return this.httpClient.put(this.PATH_OF_API + '/api/v1/' + productId, productData);
  }

  public delete(productId: string){
    return this.httpClient.delete(this.PATH_OF_API + '/api/v1/' + productId);
  }

  public subscribebook(bookData:any, bookId: string){
    return this.httpClient.post(this.PATH_OF_API + '/api/v1/digitalbooks/' + bookId + '/subscribe',bookData);
  }

  public unsubscribebook(bookData:any, bookId: string, username: String){
    return this.httpClient.post(this.PATH_OF_API + '/api/v1/digitalbooks/readers/' + username + '/books/' + bookId + '/cancel-subscription',bookData);
  }

  public getallsubscriptions(username: String){
    return this.httpClient.get(this.PATH_OF_API + '/api/v1/digitalbooks/readers/' + username + '/books');
  }

  public getsubscription(bookId:String, username: String){
    return this.httpClient.get(this.PATH_OF_API + '/api/v1/digitalbooks/readers/' + username + '/books/' + bookId);
  }

  public read(bookid: String, username: String){
    return this.httpClient.get(this.PATH_OF_API + '/api/v1/digitalbooks/readers/'+ username + '/books/' + bookid + '/read');
  }

}
