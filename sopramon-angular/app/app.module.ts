import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AscBoldComponent } from './asc-bold.component';
import { AscBoldElementComponent } from './asc-bold-element.component';
import { RouterModule.forRoot(routes) } from '@angular/core';
import { HomeComponent } from './home.component';
import { ProduitComponent } from './produit.component';
import { ProduitDetailsComponent } from './produit-details.component';
import { ProduitCrudRowsComponent } from './produit-crud-row.component';



@NgModule({
    imports: [
        BrowserModule,
        FormsModule
    ],

    declarations: [
        AppComponent,
        AscBoldComponent,
        AscBoldElementComponent,
        ProduitCrudRowsComponent
    ],

    bootstrap: [ AppComponent ]
})
export class AppModule { }

//Configuration des routes
const routes: Routes = [
{ path: 'home', component: HomeComponent },
{ path: 'produit', component: ProduitComponent },
{ path: 'produit/:id', component: ProduitDetailComponent } ,
{ path: '', redirectTo: 'home', pathMatch: 'full' },
];
