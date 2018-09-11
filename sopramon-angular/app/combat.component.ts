import { Component } from '@angular/core';
import {Combat } from './combat';
import { CombatService } from './combat.service';


@Component({
    selector: 'sopra-app',
    templateUrl: 'app/combat.component.html',
    styleUrls: [ 'app/app.component.css' ]
})
export class Combat {
    private id: int;
    public getId(): int {
      return this.id;
    }
    private date: Date;
    public getDate(): Date {
      return this.date;
    }
    private arene: Arene;
    public getArene(): arene {
      return this.arene;
    }
    private type: Type;
    public getType(): type {
      return this.type;
    }



    constructor(private combatService: CombatService) {
    }

    public getCombats(): Array<Combat> {
      return this.combatService.findAll();
    }

}
