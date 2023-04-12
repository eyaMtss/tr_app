import { Component, ViewChild } from '@angular/core';
import { GoogleMap } from '@angular/google-maps';
import { AffectationService } from '../services/api/affectation.service';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { OrderService } from '../services/api/order.service';

@Component({
  selector: 'app-drivercamion',
  templateUrl: './drivercamion.component.html',
  styleUrls: ['./drivercamion.component.css']
})
export class DrivercamionComponent {
  @ViewChild('myGoogleMap', { static: true }) map!: GoogleMap;
  labelOptions = {
    color: '',
    fontFamily: '',
    fontSize: '14px',
    fontWeight: 'bold',
    text: '.',
  }
  constructor(private affectationService: AffectationService,private orderService: OrderService , config: NgbModalConfig, private modalService: NgbModal) {
    config.backdrop = 'static';
    config.keyboard = false;
  }
  lat:any;
  lng:any;

  position = [] as any;
  affectations=[]as any;
  ordreaffect=[]as any;

  mapOptions: google.maps.MapOptions = {
    center: { lat: 36.1742400, lng: 8.7048600 },
    zoom: 6.9,
  };  
  afficher(affect:any,id:number ){
    
    this.modalService.open(affect);

  }
  ngOnInit(): void {
    this.position.push({ position: { lat:36.1742400, lng:  8.7048600} })
    this.getAllAffectations();
   
  }
  getAllAffectations() {
    this.affectationService.getAffectatons().subscribe(data => {
      this.affectations = data;
      data.forEach((affec) => {
        console.log( affec.id)

      });
     
    }
    );

  }
  getOrdre(id:number) {
    this.orderService.getOrdre(id).subscribe(data => {
      this.ordreaffect = data;     
    }
    );

  }
 
  

}
