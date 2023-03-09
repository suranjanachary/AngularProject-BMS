import { HostBinding } from '@angular/core';
import { HostListener } from '@angular/core';
import { Directive } from '@angular/core';

export {Directive} from '@angular/core';

@Directive({
    selector: '[appDropdown]'
})

export class DropdownDirective{
    @HostBinding('class.open') isOpen = false;
    @HostListener('click') toggleOpen(){
        this.isOpen = !this.isOpen;
    }
}