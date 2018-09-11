import { Component, HostListener, Input } from '@angular/core';


@Component({
    selector: 'asc-bold-element',
    templateUrl: 'app/asc-bold-element.component.html'
})
export class AscBoldElementComponent {
    @Input()
    private prefix: string;

    @Input('nom')
    private nomProduit: string;

    @HostListener('click')
    public onClick() {
        alert(this.nomProduit);
    }
}
