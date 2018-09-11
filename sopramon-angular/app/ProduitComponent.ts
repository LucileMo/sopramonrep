import { Component } from '@angular/core';
import { Produit } from './produit';


@Component({
    selector: 'eshop-app',
    templateUrl: 'app/produit.component.html',
    styleUrls: [ 'app/produit.component.css' ]
})
export class ProduitComponent {
    private prenom: string = "Jérémy";
    private produit: Produit = new Produit();
    private produits: Array<Produit> = new Array<Produit>();
    private filtre: string = "";

    constructor() {
      this.produits.push(new Produit("GoPRO HERO 6",499,99))
    }

    public changePrenom() {
        this.prenom = "AUTRE PRÉNOM";
    }

    produit.addProduit() {
      this.produits.push(this.produit);
      this.produit = new Produit();     // réinitialise le nouveau produit
    }

    public filtrerProduits(): Array<Produit> {
      return this.produits.filter(produit => produit.getNom()
        .toLowerCase()
        .indexOf(this.filtre.toLowerCase()) !== -1
      )   // pas contenu retourne -1 1position retourne 0 5e position retourne 4
    }
}
