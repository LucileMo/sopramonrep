export class Combat {

    constructor(public id?: number, private date?: string) {

    }

    public getId(): number {
        return this.id;
    }

    public getDate(): string {
        return this.date;
    }



}
