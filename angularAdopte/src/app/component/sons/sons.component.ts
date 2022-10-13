import { AuthService } from './../../service/auth.service';
import { SonService } from './../../service/crud-son/son.service';
import { ActivatedRoute } from '@angular/router';
import { UtilisateurService } from './../../service/crud-uti/utilisateur.service';
import { Utilisateur } from './../../model/utilisateur';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sons',
  templateUrl: './sons.component.html',
  styleUrls: ['./sons.component.css'],
})
export class SonsComponent implements OnInit {
  utilisateur!: Utilisateur;
  afficheLecture = false;
  contenu!: any;
  titre!: any;
  constructor(
    private srvUtilisateur: UtilisateurService,
    private activatedRoute: ActivatedRoute,
    private srvSon: SonService,
    private srvAuth: AuthService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.srvUtilisateur.getByIdFetchSon(params['id']).subscribe((data) => {
          this.utilisateur = data;
        });
      }
    });
  }
  ecouter(id: number) {
    this.srvSon.getByIdToRead(id).subscribe((data) => {
      this.contenu = data.contenu;
      this.titre = data.titre;
      this.afficheLecture = true;
    });
  }
  logout() {
    this.srvAuth.logout();
  }
}
