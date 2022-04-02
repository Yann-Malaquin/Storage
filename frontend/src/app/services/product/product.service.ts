import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../models/product/product.model";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  public getProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(`${environment.url}/products`);
  }

  public getProductByStorage(id:number): Observable<Product[]>{
    return this.http.get<Product[]>(`${environment.url}/productByStorage/${id}`);
  }
}
