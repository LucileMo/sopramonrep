export class Combat {

    constructor(public id?: int, private date?: string) {

    }

    public getId(): int {
        return this.id;
    }

    public getDate(): string {
        return this.date;
    }



}
