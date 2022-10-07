import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-connecte',
  templateUrl: './admin-connecte.component.html',
  styleUrls: ['./admin-connecte.component.css'],
})
export class AdminConnecteComponent implements OnInit {
  infoCompte: string = '';
  constructor() {}

  ngOnInit(): void {
    let compte = JSON.parse(sessionStorage.getItem('compte')!);
    if (compte.username) {
      this.infoCompte =
        'Bienvenue admin id #' + compte.id + ' : ' + compte.username;
    }
  }
}
