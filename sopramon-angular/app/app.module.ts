import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {RouterModule, Routes} from  '@angular/router';
import { HomeComponent } from './home.component';
import { ItemComponent } from './item.component';
import { CombatComponent } from './combat.component';
//import { ItemCrudRowsComponent } from './item-crud-row.component';
import { HttpModule } from '@angular/http';
import { ItemService } from './item.service';
import { CombatService } from './combat.service';
import { AppConfigService } from './app-config.service';




@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule
    ],

    providers: [
        AppConfigService,
        ItemService,
        CombatService
    ],


    declarations: [
        AppComponent,
        ItemComponent,
        CombatComponent,
        HomeComponent
      //  ItemCrudRowsComponent
    ],

    bootstrap: [ AppComponent ]
})
export class AppModule { }

//Configuration des routes
const routes: Routes = [
{ path: 'home', component: HomeComponent },
{ path: 'item', component: ItemComponent },
{ path: 'combat', component: CombatComponent },
//{ path: 'produit/:id', component: ProduitDetailComponent } ,
{ path: '', redirectTo: 'home', pathMatch: 'full' },
];
