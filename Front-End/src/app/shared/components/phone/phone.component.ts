import { Component, EventEmitter, Output } from '@angular/core';
import { Subscription } from 'rxjs';
import { CountryISO, SearchCountryField } from 'ngx-intl-tel-input';

@Component({
  selector: 'app-phone',
  templateUrl: './phone.component.html',
  styleUrls: ['./phone.component.css']
})
export class PhoneComponent {
  CountryISO = CountryISO;
  SearchCountryField = SearchCountryField;
  phone: any;
  @Output() phoneEvent = new EventEmitter<any>();
  private subscription!: Subscription;
  constructor(){}

  onValueChange(){
    this.emitPhone(this.phone);
  }

  emitPhone(value: any) { // emit address value to parent component
    this.phoneEvent.emit(value);
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}

