import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor( private http: HttpClient) { }

  public getStorages():Observable<Storage[]>{
    return this.http.get<Storage[]>(`${environment.url}/storages`);
  }

}
