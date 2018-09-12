import { Component } from '@angular/core';
import {Combat } from './combat';
import { CombatService } from './combat.service';

@Component({
    selector: 'sopra-app',
    templateUrl: 'app/combat.component.html',
    styleUrls: [ 'app/app.component.css' ]
})
export class CombatComponent {
    constructor(private combatService: CombatService) {

    }

    public getCombats(): Array<Combat> {
      return this.combatService.findAll();
    }

}
