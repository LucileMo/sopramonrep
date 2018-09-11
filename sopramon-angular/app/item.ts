export class Item {
//  public gamme;
  public _links;


    constructor(public nom?: string, private prix?: number) {

    }

    public getNom(): string {
        return this.nom;
    }
}
