import { Component, OnInit } from '@angular/core';
import {StorageService} from "../../services/storage/storage.service";
import {ProductService} from "../../services/product/product.service";
import {Product} from "../../models/product/product.model";
import {Subject} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public storage: Storage[] = [];
  public products: Product[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject<any>();

  constructor(private storageService: StorageService,
              private productService: ProductService) {

  }

  ngOnInit(): void {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2
    };
    this.getStorages();
    this.getProducts();
  }

  getStorages(){
    return this.storageService.getStorages().subscribe(data => {
      this.storage = data;
      console.table(this.storage);
    })
  }

  getProducts(){
    return this.productService.getProducts().subscribe(data => {
      this.products = data;
      this.dtTrigger.next(this.products);
      console.table(this.products);
    })
  }


  ngOnDestroy(): void {
    // Do not forget to unsubscribe the event
    this.dtTrigger.unsubscribe();
  }

}
