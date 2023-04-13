import { Component, ElementRef, EventEmitter, NgZone, Output, ViewChild } from '@angular/core';
import { GoogleMap } from '@angular/google-maps';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-address-map',
  templateUrl: './address-map.component.html',
  styleUrls: ['./address-map.component.css']
})
export class AddressMapComponent {
  @Output() addressMapEvent = new EventEmitter<string>();
  private subscription!: Subscription;
  zoom = 12;
  center!: google.maps.LatLngLiteral;
  options: google.maps.MapOptions = { //google.maps.MapOptions
    mapTypeId: google.maps.MapTypeId.TERRAIN,
    zoomControl: true,
    scrollwheel: false,
    disableDoubleClickZoom: false,
    maxZoom: 15,
    minZoom: 8,
  };
  showMarker = false;
  markerPosition!: google.maps.LatLngLiteral;
  searchLocation!: string;
  //@ViewChild('mapSearchField') searchField!: ElementRef;
  @ViewChild(GoogleMap) map!: GoogleMap;
  @ViewChild('search') public searchElementRef!: ElementRef;
  
  latitude!: any;
  longitude!: any;

  address!: string;
  constructor(private ngZone: NgZone){
    // position enabled
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        position => {
          this.center = {
            lat: position.coords.latitude,
            lng: position.coords.longitude
          };
          this.markerPosition = this.center;
          this.showMarker = true;
          this.reverseGeocode(this.center); // call reverseGeocode function with the center coordinates
         
        }
      );
    }
  }
  ngOnInit(): void {
    
  }

  ngAfterViewInit(): void {
    // search location from input
    // Binding autocomplete to search input control
    let autocomplete = new google.maps.places.Autocomplete(
      this.searchElementRef.nativeElement
    );
    // Align search box to center
    /*this.map.controls[google.maps.ControlPosition.TOP_CENTER].push(
      this.searchElementRef.nativeElement
    );*/
    autocomplete.addListener('place_changed', () => {
      this.ngZone.run(() => {
        //get the place result
        let place: google.maps.places.PlaceResult = autocomplete.getPlace();

        //verify result
        if (place.geometry === undefined || place.geometry === null) {
          return;
        }

        //console.log({ place }, place.geometry.location?.lat());

        //set latitude, longitude and zoom
        this.latitude = place.geometry.location?.lat();
        this.longitude = place.geometry.location?.lng();
        this.center = {
          lat: this.latitude,
          lng: this.longitude,
        };
        this.markerPosition = this.center;
        this.reverseGeocode(this.center); // call reverseGeocode function with the center coordinates
       
      });
    });
  }
  //not used yet
  onMapClick(event: google.maps.MapMouseEvent) {
    this.markerPosition = event.latLng!.toJSON();
    this.showMarker = true;
  }

  //convert latitude and longitude coordinates into a human-readable address (reverse geocoding)
  reverseGeocode(coords: google.maps.LatLngLiteral) {
    const geocoder = new google.maps.Geocoder();
    geocoder.geocode({ location: coords }, (results, status) => {
      if (status === google.maps.GeocoderStatus.OK) {
        if (results![0]) {
          //console.log(results![0])
          this.address = results![0].formatted_address; // set the address property to the first formatted address in the results
          this.emitAddress(this.address);
        } else {
          this.address = 'No results found';
        }
      } else {
        this.address = 'Geocoder failed due to: ' + status;
      }
    });
  }

  emitAddress(value: string) { // emit address value to parent component
    this.addressMapEvent.emit(value);
  }
  
  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
