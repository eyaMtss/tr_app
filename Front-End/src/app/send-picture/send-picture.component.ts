import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Observable, Subject } from 'rxjs';
import { NgxImageCompressService } from 'ngx-image-compress';
import { OrderService } from '../services/api/order.service';
import { WebcamImage } from 'ngx-webcam';
@Component({
  selector: 'app-send-picture',
  templateUrl: './send-picture.component.html',
  styleUrls: ['./send-picture.component.css']
})
export class SendPictureComponent implements OnInit {
  test = 0;
  load = true;
  file: any;
  id!: any;
  url = '';
  private trigger: Subject<any> = new Subject();
  public webcamImage!: WebcamImage;
  private nextWebcam: Subject<any> = new Subject();
  liste: string[] = []
  listeFile: File[] = []
  enum = [0, 3]
  sysImage = '';
  imageOk: boolean = false;


  constructor(private router: Router, private orderService: OrderService, private imageCompress: NgxImageCompressService) { }

  ngOnInit(): void {
  }
  confirm() {
    this.test = 5;

  }
  public getSnapshot(): void {
    this.trigger.next(void 0);
  }
  public captureImg(webcamImage: WebcamImage): void {
    this.webcamImage = webcamImage;
    this.sysImage = webcamImage!.imageAsDataUrl;
    if (this.liste.length < 3) {
      this.liste.push(this.sysImage)
      let blob = new Blob([this.sysImage])

      let file = new File([blob], "filename", { type: "image/jpg" });

      this.listeFile.push(file)
      console.log(this.listeFile)
    }
    //console.info('got webcam image', this.sysImage);
  }
  public get invokeObservable(): Observable<any> {
    return this.trigger.asObservable();
  }
  public get nextWebcamObservable(): Observable<any> {
    return this.nextWebcam.asObservable();
  }
  change() {
    this.test = 2;
    console.log(this.test);
  }
  switch() {
    this.test = 1;
  }
  delete(c: string) {
    let ind = this.liste.indexOf(c);
    console.log(ind)
    if (ind == 0) {
      this.liste.shift()
      this.listeFile.shift()

    }
    else {

      this.liste.splice(ind, ind);
      this.listeFile.splice(ind, ind);

    }
    console.log(this.listeFile)
  }

  onselectFile(e: any) {
    this.imageOk = false;
    if (e.target.files) {
      this.file = e.target.files[0];
      console.log(this.file)
      var reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload = (event: any) => {
        this.url = event.target.result;
        this.imageOk = true;
        if (this.liste.length < 3) {
          this.liste.push(this.url)
          this.listeFile.push(this.file)
          console.log(this.listeFile)
        }

      }


    }
  }
  updatePhotos() {
    this.id = localStorage.getItem('id');
    console.log(this.id)
    //this.formData.set("file", this.file);
    this.orderService.updatePhotos(this.listeFile[0], this.listeFile[1], this.listeFile[2], this.id).subscribe(
      data => {
        console.log("response received")
        //  this.router.navigate(['']);

      },
      error => {
        console.log("error accured")
        //this.errorMessage="";
      }
    );
    this.test = 4;



  }

  cancel() {
    this.id = localStorage.getItem('id')
    this.orderService.deleteOrder(this.id).subscribe(
      data => {
        console.log("response received")
        //  this.router.navigate(['']);

      },
      error => {
        console.log("error accured")
        //this.errorMessage="";
      }
    );
    this.test = 6
  }

}

