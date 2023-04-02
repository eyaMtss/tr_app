import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientComponent } from './client.component';
import { ShareInformationComponent } from './share-information/share-information.component';
import { SendPictureComponent } from './send-picture/send-picture.component';

const routes: Routes = [
  { path: '', component: ClientComponent },
  { path: 'share', component: ShareInformationComponent },
  { path: 'picture', component: SendPictureComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule { }
