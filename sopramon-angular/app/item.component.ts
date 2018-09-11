import { Component } from '@angular/core';
import { Item } from './item';


@Component({
    selector: 'sopra-app',
    templateUrl: 'app/item.component.html',
    styleUrls: [ 'app/item.component.css' ]
})
export class Item {
    private id: int;
    private nom: String;
    public getNom(): string {
      return this.nom;
    }
    private prix: float;
    public getPrix(): float {
      return this.prix;
    }

    private capacite: capacite;
    public getCapacite(): capacite {
      return this.capacite;
    }

    private items: Array<Item> = new Array<Produit>();



    constructor() {
      this.items.push(new Item())
    }

    item.addItem() {
      this.items.push(this.item);
      this.item = new Item();     // réinitialise le nouveau produit
    }

    public filtrerItems(): Array<Item> {
      return this.items.filter(item => item.getNom()
        .toLowerCase()
        .indexOf(this.filtre.toLowerCase()) !== -1
      )   // pas contenu retourne -1 1position retourne 0 5e position retourne 4
    }


}
