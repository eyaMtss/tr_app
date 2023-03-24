import { Component, ElementRef, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { CountryISO, SearchCountryField } from "ngx-intl-tel-input";
import { Address } from 'ngx-google-places-autocomplete/objects/address';
import { DOCUMENT } from '@angular/common';
import { map, Observable } from 'rxjs';
import { OrderService } from '../services/api/order.service';
import { OrderRequest } from '../models/order-request';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MapDirectionsService, MapInfoWindow, MapMarker } from '@angular/google-maps';
@Component({
  selector: 'app-share-information',
  templateUrl: './share-information.component.html',
  styleUrls: ['./share-information.component.css']
})
export class ShareInformationComponent implements OnInit {
  isApiLoaded = false;
  markers = [] as any;
  currentAdress = ""
  public lat = 24.799448;
  public lng = 120.979021;

  testRoute = false
  testOrigin = false
  longA!: any
  attA!: any;
  longB!: any
  attB!: any;
  pickUpLocation!: string;
  info!: MapInfoWindow;
  infoContent = ''
  destination!: string;
  phone!: string;
  people!: number;
  situationType!: string;
  time: any;
  isLoaded!: string;
  matricule!: any;
  matriculeConfirm!: any;
  order: OrderRequest = new OrderRequest();
  order1: OrderRequest = new OrderRequest();
  date: Date = new Date();
  message = ""
  messageR = ''
  center!: google.maps.LatLngLiteral;
  center1!: google.maps.LatLngLiteral;
  tel!: any
  SearchCountryField = SearchCountryField;
  CountryISO = CountryISO;
  destinationT1 = 0
  destinationT2 = 0
  originT1 = 0
  originT2 = 0
  serie!: any
  num!: any
  immatType!: any
  isRegistrationTypeSelected: boolean = false;
  registrationTypes = [{ id: 1, value: "Série Normale (TU)" }, { id: 2, value: "Régime Suspensif (RS)" },
  { id: 3, value: "Moto (MOTO)" }, { id: 4, value: "Tracteur (TRAC)" }, { id: 5, value: "Personnel Administratif et Technique (PAT)" },
  { id: 6, value: "Chef de Mission Diplomatique (CMD)" }, { id: 7, value: "Corps Diplomatique (CD)" },
  { id: 8, value: "Misiion Diplomatique (MD)" }, { id: 9, value: "Misiion Consulaire (MC)" },
  { id: 10, value: "Corps Consulaire (CC)" }, { id: 11, value: "Remorque (REM)" },
  { id: 12, value: "Appareil Agricol (AA)" }, { id: 13, value: "Engin Spécial (ES)" }, { id: 14, value: "Propriété de l'Etat (PE)" },
  { id: 15, value: "Immatriculation Temporaire (IT)" }, { id: 16, value: "Immatriculation Etrangère ou Douanière" }]

  directionsResults$!: Observable<google.maps.DirectionsResult | undefined>;

  registerForm!: FormGroup
  submitted = false



  constructor(private router: Router, private orderService: OrderService, private formBuilder: FormBuilder, @Inject(DOCUMENT) private document: Document,
    private elementRef: ElementRef, private mapDirectionsService: MapDirectionsService) {


  }

  ngOnInit(): void {






    this.registerForm = this.formBuilder.group({
      location: ['', []],
      destination: ['', [Validators.required]],

      people: ['', [Validators.required]],

      details: ['', [Validators.required]],
      loaded: ['', [Validators.required]],

      type: ['', [Validators.required,]],



    })

    navigator.geolocation.getCurrentPosition((position) => {

      this.testOrigin = false

      let geocoder = new google.maps.Geocoder;
      this.center = {

        lat: position.coords.latitude,
        lng: position.coords.longitude,

      }
      this.originT1 = position.coords.latitude,
        this.originT2 = position.coords.longitude,
        console.log("originT1", this.originT1)
      console.log("originT2", this.originT2)
      this.attA = position.coords.latitude;
      this.longA = position.coords.longitude;
      if (this.testRoute == false) {
        this.destinationT1 = this.originT1;
        this.destinationT2 = this.originT2;
      }
      const request: google.maps.DirectionsRequest = {
        destination: { lat: this.destinationT1, lng: this.destinationT2 },
        origin: { lat: this.originT1, lng: this.originT2 },
        travelMode: google.maps.TravelMode.DRIVING
      };
      this.directionsResults$ = this.mapDirectionsService.route(request).pipe(map(response => response.result));

      this.testOrigin = true
      this.markers[0] = {
        position: {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        },


        title: 'Your position ',
        info: 'Your position ',
        options: { animation: google.maps.Animation.DROP },

      }
      /*   this.markers.push({
           position: {
             lat: position.coords.latitude,
             lng: position.coords.longitude,
           },
   
   
           title: 'Your position ',
           info: 'Your position ',
           options: { animation: google.maps.Animation.DROP },
   
         });*/
      geocoder
        .geocode({ location: this.center })
        .then((response) => {
          if (response.results[0]) {
            this.currentAdress = response.results[0].formatted_address;
            console.log(this.currentAdress)

          } else {
            window.alert("No results found");
          }
        })
        .catch((e) => window.alert("Geocoder failed due to: " + e));
    }


    )



    this.testOrigin = true





  }


  onRegistrationTypeChange(e: any) {
    this.isRegistrationTypeSelected = true;
    this.immatType = e.target.value
    console.log(this.immatType);
    console.log(this.registrationTypes[this.immatType - 1].value)

  }
  confirm() {
    /* console.log(this.pickUpLocation)
     console.log(this.destination)
     console.log(this.people)
     console.log(this.phone)
     console.log(this.situationType)
     console.log(this.matricule);*/
    console.log(this.tel.nationalNumber);



    this.router.navigate(['/sendPicture']);
  }
  saveOrder() {




    if (this.registerForm.invalid || this.currentAdress == '' && this.attA == null && this.longA == null) {
      this.messageR = "location required"
      return
    }
    else {
      this.messageR = ''
      this.order.positionALong = this.longA;
      this.order.typeImmatriculation = this.registrationTypes[this.immatType - 1].value


      this.order.positionAAtt = this.attA
      this.order.positionBLong = this.longB
      this.order.positionBAtt = this.attB
      this.order.positionCLong = "ToDO";
      this.order.positionCAtt = "todo"
      const whitespaceRemoved = this.tel.nationalNumber.replace(/\s/g, '');

      this.order.telephone = Number(whitespaceRemoved);
      console.log(this.order.telephone);
      console.log(this.order.numImmatriculation);
      if (whitespaceRemoved.length == 8) {
        this.orderService.createOrder(this.order).subscribe(data => {
          localStorage.setItem('id', data.id)
          console.log(localStorage.getItem('id'))

          console.log(data)
          this.router.navigate(['/picture']);


        },
          error => {
            console.log(error),
              this.message = "il y'a une erreur "
          });
      }
      else {
        console.log("le numéro est invalide ou matricule non confirmée ")
      }
    }
  }
  phoneForm = new FormGroup({
    phone: new FormControl('', [Validators.required])
  });


  options: any = {
    zoom: 1000,

  }



  handleAddressChangeLocation(address: Address) {
    this.testOrigin = false
    this.attA = address.geometry.location.lat()
    this.longA = address.geometry.location.lng()
    console.log(address.formatted_address)
    console.log(typeof address.geometry.location.lat())
    console.log(address.geometry.location.lng())
    this.originT1 = address.geometry.location.lat(),
      this.originT2 = address.geometry.location.lng(),

      this.markers[0] = {
        position: {
          lat: address.geometry.location.lat(),
          lng: address.geometry.location.lng(),
        },

        title: "Your destination ",
        info: "Your destination ",
        options: { animation: google.maps.Animation.DROP },
      }
    if (this.testRoute == false) {
      this.destinationT1 = this.originT1;
      this.destinationT2 = this.originT2;
    }

    const request: google.maps.DirectionsRequest = {
      destination: { lat: this.destinationT1, lng: this.destinationT2 },
      origin: { lat: this.originT1, lng: this.originT2 },
      travelMode: google.maps.TravelMode.DRIVING
    };
    this.directionsResults$ = this.mapDirectionsService.route(request).pipe(map(response => response.result));

    this.testOrigin = true
  }
  handleAddressChangeDestination(address: Address) {
    this.testRoute = false
    this.attB = address.geometry.location.lat()
    this.longB = address.geometry.location.lng()
    console.log(address.formatted_address)
    this.destinationT1 = address.geometry.location.lat(),
      this.destinationT2 = address.geometry.location.lng(),


      console.log(typeof address.geometry.location.lat())
    console.log(address.geometry.location.lng())
    this.markers[1] = {
      position: {
        lat: address.geometry.location.lat(),
        lng: address.geometry.location.lng(),
      }


      ,
      title: "Your destination ",
      info: "Your destination ",
      options: { animation: google.maps.Animation.DROP },
    }
    if (this.testOrigin == false) {
      this.originT1 = this.destinationT1;
      this.originT2 = this.destinationT2;
    }

    const request: google.maps.DirectionsRequest = {
      destination: { lat: this.destinationT1, lng: this.destinationT2 },
      origin: { lat: this.originT1, lng: this.originT2 },
      travelMode: google.maps.TravelMode.DRIVING
    };
    this.directionsResults$ = this.mapDirectionsService.route(request).pipe(map(response => response.result));
    this.testRoute = true
  }


  openInfo(marker: MapMarker, content: string) {
    this.infoContent = content;
    this.info.open(marker)
  }








}
