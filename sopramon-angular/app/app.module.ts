import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AscBoldComponent } from './asc-bold.component';
import { AscBoldElementComponent } from './asc-bold-element.component';
import {RouterModule, Routes} from  '@angular/router';
import { HomeComponent } from './home.component';
import { ItemComponent } from './item.component';
import { CombatComponent } from './combat.component';
//import { ItemCrudRowsComponent } from './item-crud-row.component';



@NgModule({
    imports: [
        BrowserModule,
        FormsModule
    ],

    declarations: [
        AppComponent,
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
