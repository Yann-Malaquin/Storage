import {Product} from "../product/product.model";

export class Storage {
  id?: number;
  name?: string;
  slug?: string;
  products?: Product[];
}
