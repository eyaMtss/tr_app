import { Component } from '@angular/core';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent {

  services: any[] = [
    {id: "remorquage", name: "Remorquage", image: "/assets/client-services/remorquage.png", btn_label: "Passer un ordre", link: "/client/share"},
    {id: "constat", name: "Constat numérique", image: "/assets/client-services/constat.png", btn_label: "Passer un constat", link: "/client/share"},
  
  ]
}
