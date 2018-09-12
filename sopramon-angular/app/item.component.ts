import { Component } from '@angular/core';
import { Item } from './item';
import { ItemService } from './item.service';


@Component({
    //selector: 'sopra-app',
    templateUrl: 'app/item.component.html',
    //styleUrls: [ 'app/item.component.css' ]
})

export class ItemComponent {
    private id: number;
    private nom: string;

      private prix: number;
        private filtre: string = "";
         private isEditing: boolean =false;
          private items: Array<Item> = new Array<Item>();
          private item: Item = new Item("Saisir le nom", 10);


       constructor(private itemService: ItemService) {}



      public getItems(): Array<Item>{
        return this.itemService.findAll();
      }




      public filtrerItems(): Array<Item> {
          return this.itemService.findAllByNom(this.filtre);
      }
  }
