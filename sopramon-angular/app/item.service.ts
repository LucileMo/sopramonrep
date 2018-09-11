import { Injectable } from '@angular/core';
import {Produit} from './produit';
import { Http } from '@angular/http';
import { AppConfigService } from './app-config.service';
import { Headers } from '@angular/http';
import { RequestOptions } from '@angular/http';

@Injectable()
export class ProduitService {
private produits: Array<Produit> = new Array<Produit>();
private requestOptions: RequestOptions;

constructor (private http: Http, private appConfigService: AppConfigService){
  let myHeaders: Headers = new Headers();

  myHeaders.append('Authorization', this.appConfigService.getApiBasic());
this.requestOptions = new RequestOptions({ headers: myHeaders });

this.http
.get(this.appConfigService.getApiUrl() + "produits", this.requestOptions)
.subscribe(resp =>this.produits = resp.json()._embedded.produits);
}

public save(produit : Produit) {
  if(this.produits.indexOf(produit) === -1){
    produit.gamme = this.appConfigService.getApiUrl() + "gammes/1";
  this.http.post(this.appConfigService.getApiUrl() + "produits", produit, this.requestOptions)
  .subscribe(resp =>this.produits.push(resp.json()),
  err => alert(err));
}
else {
  this.http.put(produit._links.self.href, produit, this.requestOptions).subscribe();
}
}
public delete(produit: Produit){
  let myIndex: number = this.produits.indexOf(produit);
  this.http.delete(produit._links.self.href, this.requestOptions)
  .subscribe(resp =>this.produits.splice(myIndex, 1));
}


public findAll(): Array<Produit>{
  return this.produits;
}
public findAllByNom(nom: string): Array<Produit> {

    return this.produits.filter(p => p.nom.toLowerCase().indexOf(nom.toLowerCase()) !== -1);
  }
// p.nom à remplacer par p.getNom

public getProduits(): Array<Produit>{
  return this.produits;
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
