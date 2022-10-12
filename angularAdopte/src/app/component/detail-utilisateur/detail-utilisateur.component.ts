import { Observable } from 'rxjs';
import { Utilisateur } from 'src/app/model/utilisateur';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UtilisateurService } from 'src/app/service/crud-uti/utilisateur.service';

@Component({
  selector: 'app-detail-utilisateur',
  templateUrl: './detail-utilisateur.component.html',
  styleUrls: ['./detail-utilisateur.component.css'],
})
export class DetailUtilisateurComponent implements OnInit {
  utilisateur!: Utilisateur;
  constructor(
    private activatedRoute: ActivatedRoute,
    private srvUtilisateur: UtilisateurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.srvUtilisateur.getByIdFetchAll(params['id']).subscribe((data) => {
          this.utilisateur = data;
        });
      }
    });
  }
}
