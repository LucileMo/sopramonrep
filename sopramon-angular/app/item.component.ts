import { Component } from '@angular/core';
import { Item } from './item';
import { ItemtService } from './item.service';


@Component({
    //selector: 'sopra-app',
    templateUrl: 'app/item.component.html',
    styleUrls: [ 'app/item.component.css' ]
})

export class Item {
    private id: int;
    private nom: String;
      private prix: float;
        private capacite: capacite;
        private filtre: string = "";
         private isEditing: boolean =false;


       constructor(private itemService: ItemService) {}

    private items: Array<Item> = new Array<Produit>();

    public addItem() {
          this.itemService.save(this.item);
          this.item = new Item();
          this.isEditing = false;
      }

      public modifierItem (item: Item) {
        this.item = item;
        this.isEditing = true;
      }

      public getItems(): Array<Item>{
        return this.itemService.findAll();
      }

      public supprimerItem (item: Item){
      this.produitItem.delete(item);
      }


      public filtrerItems(): Array<Item> {
          return this.itemService.findAllByNom(this.filtre);
      }
  }
