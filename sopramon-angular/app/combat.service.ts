
import { Injectable } from '@angular/core';
import { Combat } from './combat';
import { Http } from '@angular/http';
import { Headers} from '@angular/http';
import { RequestOptions } from '@angular/http';
import { AppConfigService} from './app-config.service';

@Injectable ()

export class CombatService  {

  private combats: Array<Combat> = new Array<Combat>();
  private RequestOptions: RequestOptions;

  constructor(private http: Http, private appConfigService: AppConfigService) {
    let myHeaders: Headers = new Headers();

    myHeaders.append('Authorization', this.appConfigService.getApiBasic());
    this.RequestOptions = new RequestOptions({ headers: myHeaders });

      this.http
            .get(this.appConfigService.getApiUrl() + "combats", this.RequestOptions)
            .subscribe(resp => this.combats = resp.json()._embedded.combats);
}

  public  findAll(): Array<Combat> {

    return this.combats;
  }

  // public findAllById(id: number): Array<Combat> {
  //     return this.combats.sopramon.id.filter(combat =>
  //     combat.id
  //       .toLowerCase()
  //       .indexOf(id.toLowerCase()) !== -1
  //     );
  // }

  }
