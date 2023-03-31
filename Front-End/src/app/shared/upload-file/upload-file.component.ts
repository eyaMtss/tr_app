import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.css']
})
export class UploadFileComponent {
  selectedFile!: File;
  @Output() fileEvent = new EventEmitter<File>();
  constructor() {

  }

  public onFileChanged(event: any) {  //Gets called when the user selects an image
    //Select File
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile)
    var reader = new FileReader();
    reader.readAsDataURL(this.selectedFile);

    this.emitFile(this.selectedFile);
  }

  emitFile(value: File) {
    this.fileEvent.emit(value);
  }
}
