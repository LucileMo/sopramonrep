export class Produit {
    constructor(private nom?: string, private prix?: number) {

    }

    public getNom(): string {
      return this.nom;
    }
}
