import { Component } from '@angular/core';
import {Combat } from './combat';
import { CombatService } from './combat.service';


@Component({
    selector: 'sopra-app',
    templateUrl: 'app/combat.component.html',
    styleUrls: [ 'app/app.component.css' ]
})
export class Combat {
    private combat: Combat = new Combat("Nom du combat", 10);
    private id: number;
    private date: string;
//    private arene: Arene ="";
  //  private type: Type = "";

    constructor(private combatService: CombatService) {
      this.combats.push(new Combat("1",11092018))
          }

    public getCombats(): Array<Combat> {
      return this.combatService.findAll();
    }

}
