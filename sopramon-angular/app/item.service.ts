import { Injectable } from '@angular/core';
import {Item} from './item';
import { Http } from '@angular/http';
import { AppConfigService } from './app-config.service';
import { Headers } from '@angular/http';
import { RequestOptions } from '@angular/http';

@Injectable()
export class ItemService {
private produits: Array<Produit> = new Array<Produit>();
private requestOptions: RequestOptions;

constructor (private http: Http, private appConfigService: AppConfigService){
  let myHeaders: Headers = new Headers();

  myHeaders.append('Authorization', this.appConfigService.getApiBasic());
this.requestOptions = new RequestOptions({ headers: myHeaders });

this.http
.get(this.appConfigService.getApiUrl() + "items", this.requestOptions)
.subscribe(resp =>this.items = resp.json()._embedded.produits);
}

public save(item : Item) {
  if(this.items.indexOf(item) === -1){
    //item.gamme = this.appConfigService.getApiUrl() + "gammes/1";
  this.http.post(this.appConfigService.getApiUrl() + "items", item, this.requestOptions)
  .subscribe(resp =>this.items.push(resp.json()),
  err => alert(err));
}
else {
  this.http.put(item._links.self.href, item, this.requestOptions).subscribe();
}
}
public delete(item: Item){
  let myIndex: number = this.items.indexOf(item);
  this.http.delete(item._links.self.href, this.requestOptions)
  .subscribe(resp =>this.items.splice(myIndex, 1));
}


public findAll(): Array<Item>{
  return this.items;
}
public findAllByNom(nom: string): Array<Item> {

    return this.items.filter(p => p.nom.toLowerCase().indexOf(nom.toLowerCase()) !== -1);
  }
// p.nom à remplacer par p.getNom

public getItems(): Array<Item>{
  return this.items;
}

// public delete(produit: Produit){
//   let myIndex: number = this.produits.indexOf(produit);
//   this.produits.splice(myIndex, 1);
// }

// public save(produit: Produit) {
//   if(this.produits.indexOf(produit) === -1) {
//     this.produits.push(produit);
//   }
// }

 }
