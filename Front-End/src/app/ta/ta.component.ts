import { Component, ViewChild } from '@angular/core';
import { GoogleMap, MapInfoWindow, MapMarker } from '@angular/google-maps';
import { MatPaginatorIntl } from '@angular/material/paginator';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { Subject } from 'rxjs';
import { Affectation } from '../models/affectation';
import { Camion } from '../models/camion';
import { AffectationService } from '../services/api/affectation.service';
import { CamionService } from '../services/api/camion.service';
import { OrderService } from '../services/api/order.service';


export class MyCustomPaginatorIntl implements MatPaginatorIntl {
  changes = new Subject<void>();

  // For internationalization, the `$localize` function from
  // the `@angular/localize` package can be used.
  firstPageLabel = $localize`First page`;
  itemsPerPageLabel = $localize`Items per page:`;
  lastPageLabel = $localize`Last page`;

  // You can set labels to an arbitrary string too, or dynamically compute
  // it through other third-party internationalization libraries.
  nextPageLabel = 'Next page';
  previousPageLabel = 'Previous page';

  getRangeLabel(page: number, pageSize: number, length: number): string {
    if (length === 0) {
      return $localize`Page 1 of 1`;
    }
    const amountPages = Math.ceil(length / pageSize);
    return $localize`Page ${page + 1} of ${amountPages}`;
  }
}
interface MarkerProperties {
  position: {
    lat: number;
    lng: number;
  }
};
@Component({
  selector: 'app-ta',
  templateUrl: './ta.component.html',
  styleUrls: ['./ta.component.css']
})
export class TaComponent {


  @ViewChild('myGoogleMap', { static: true }) map!: GoogleMap;
  labelOptions = {
    color: '',
    fontFamily: '',
    fontSize: '14px',
    fontWeight: 'bold',
    text: '.',
  }
  
  mapOptions: google.maps.MapOptions = {
    center: { lat: 34.0381, lng: 9.48583 },
    zoom: 6.8,
    
  };
  markers: MarkerProperties[] = [

  ];
  marker: MarkerProperties[] = [

  ];
  ordres = [] as any;
  camions :Camion []=[];
  today = new Date();
  pos = new Map<number, number>();
  camionaffecté:any;
  poscamion = new Map<number, number>();
  constructor(private affectationService: AffectationService,private orderService: OrderService, private camionService: CamionService, config: NgbModalConfig, private modalService: NgbModal) {
    config.backdrop = 'static';
    config.keyboard = false;
  }

  open(content: any) {
    this.modalService.open(content);
  }
  voire(camiondetails: any) {
    this.modalService.open(camiondetails);
  }
  afficher(photos: any) {
    this.modalService.open(photos);
  }
  delete(ordre: any) {
    this.modalService.open(ordre);
  }
  affecter(cam: any) {
    this.modalService.open(cam);
   
  }
  affectercamion(idcamion:number ,idordre:number) {
    let affectation=new Affectation()
    affectation.idCamion=idcamion 
    affectation.idOrdre=idordre
    this.postAffectation(affectation)
  }
  voir(historique: any) {
    this.modalService.open(historique);
  }
  ngOnInit(): void {

    this.getAllOrdres();
    this.getAllCamions();
   
  }
  getAllOrdres() {
    this.orderService.getOrdres().subscribe(data => {
      this.ordres = data;

      data.forEach((order) => {
       
        this.markers.push({ position: { lng: Number(order.positionAAtt), lat: Number(order.positionALong) } })
        this.pos.set(order.id,Math.sqrt((Number(order.positionAAtt))**2 +Number(order.positionALong) **2))
        console.log( this.pos.get(1))

      });
    }
    );

  }
  postAffectation(affectation:Affectation)
  { this.affectationService.postAffectation(affectation).subscribe(data => {
    this.camionaffecté=data;
    console.log("12")
    console.log(data.idCamion)

    }
    );
  }
  getAllCamions() {
    this.camionService.getCamionList().subscribe(datac => {
      this.camions = datac;
       datac.forEach((camion) => {
        //this.markers.push({ position: { lat: Number(camion.positionAtt), lng: Number(camion.positionLong) } })
        this.marker.push({ position: { lat: Number(camion.positionAtt), lng: Number(camion.positionLong) } })
       this.poscamion.set(camion.id,Math.sqrt((Number(camion.positionAtt))**2 +Number(camion.positionLong) **2))
       

     
      });
    }
    );

  }

}
