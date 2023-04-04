import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit{
  // image
  selectedFile!: File;
  retrievedImage: any;
  viewedImage: any = "/assets/auth/user.png" // default image
  temporaryRetrievedImage: any;
  base64Data: any;
  retrieveResponse: any;
  message!: string;
  imageName: any;
  isImageViewMode: boolean = true;

  currentUsername!: string;
  currentGivenName!: string;
  currentFamilyName!: string;
  constructor(private authService: AuthService) {

  }
  ngOnInit(): void {
    this.currentUsername = this.authService.getUserDetails()!.preferred_username;
    this.currentGivenName = this.authService.getUserDetails()!.given_name;
    this.currentFamilyName = this.authService.getUserDetails()!.family_name;
  }

  onImageEditButton() {
    this.isImageViewMode = false;
  }

  onImageConfirmButton() {
    this.isImageViewMode = true;
  }

  onImageCancelButton() {
    this.isImageViewMode = true; // view mode
    this.viewedImage = this.retrievedImage; // the viewed image is the retrieved one
  }

  // Image
  //Gets called when the user selects an image
  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0]; //Select File
    console.log(this.selectedFile)
    var reader = new FileReader();
    reader.readAsDataURL(this.selectedFile);
    reader.onload = (_event) => {
      this.temporaryRetrievedImage = reader.result;
      this.viewedImage = this.temporaryRetrievedImage;
    }

  }

  //Gets called when the user clicks on save to upload the image
  onUpload() {
    this.isImageViewMode = true; //activate the view mode
    if (this.selectedFile != undefined) { // if we change the image
      //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
      const uploadImageData = new FormData();
      uploadImageData.append('imageFile', this.selectedFile);
      //uploadImageData.append('profileId', (this.profile.profileId).toString());
      /*this.fileService.uploadImage(uploadImageData).subscribe(response => { // get api
        this.viewedImage = this.temporaryRetrievedImage; // view the new image
      });*/
    }

  }
  // get image 
  getImage() {  //Make a call to Spring Boot to get the Image Bytes.
    /*this.fileService.getImage(this.profile.profileId).subscribe(
      res => {
        this.retrieveResponse = res;
        this.base64Data = this.retrieveResponse.picByte;
        this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        this.viewedImage = this.retrievedImage;
      });*/
  }
}
