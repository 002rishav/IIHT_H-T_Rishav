import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  PATH_OF_API = 'http://ec2-44-202-27-100.compute-1.amazonaws.com:9090';

  response :any;

  constructor(
    private httpClient: HttpClient,
    private auth: UserAuthService
    ) { }

  public addProduct(productData: any){
    return this.httpClient.post(this.PATH_OF_API + '/api/v1/product' , productData);
  }

  public getallproducts(){
    return this.httpClient.get(this.PATH_OF_API + '/api/v1/product');
  }

  public updateproduct(productData: any, productId: string){
    return this.httpClient.put(this.PATH_OF_API + '/api/v1/product/' + productId, productData);
  }

  public delete(productId: string){
    return this.httpClient.delete(this.PATH_OF_API + '/api/v1/product/' + productId);
  }

}
