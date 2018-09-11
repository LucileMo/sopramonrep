import { Component } from '@angular/core';
import {Combat } from './combat';


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

    private combats: Array<Combat> = new Array<Combat>();

    constructor() {
      this.combats.push(new Combat())
    }

}
