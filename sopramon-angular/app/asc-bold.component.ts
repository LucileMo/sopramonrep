import { Component, HostListener } from '@angular/core';


@Component({
    selector: '[asc-bold]',
    templateUrl: 'app/asc-bold.component.html'
})
export class AscBoldComponent {
    @HostListener('click')
    public onClick() {
        alert("Vous avez cliqué !")
    }
}
