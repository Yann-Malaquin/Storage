import {Storage} from "../storage/storage.model";

export class Product {
  id?: number;
  name?: string;
  quantity?: string;
  slug?: string;
  storage?: Storage;
}
