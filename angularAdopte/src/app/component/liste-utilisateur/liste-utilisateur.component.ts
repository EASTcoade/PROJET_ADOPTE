import { Utilisateur } from 'src/app/model/utilisateur';
import { Observable } from 'rxjs';
import { UtilisateurService } from './../../service/crud-uti/utilisateur.service';
import { UtilisateurConnecteComponent } from './../utilisateur-connecte/utilisateur-connecte.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-liste-utilisateur',
  templateUrl: './liste-utilisateur.component.html',
  styleUrls: ['./liste-utilisateur.component.css'],
})
export class ListeUtilisateurComponent implements OnInit {
  utilisateurs!: Utilisateur[];
  constructor(private srvUtilisateur: UtilisateurService) {}

  ngOnInit(): void {
    this.srvUtilisateur.getAll().subscribe((data) => {
      this.utilisateurs = data;
    });
  }
}
