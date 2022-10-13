import { AuthService } from 'src/app/service/auth.service';
import { Observable } from 'rxjs';
import { UtilisateurService } from './../../service/crud-uti/utilisateur.service';
import { Instrument } from './../../model/instrument';
import { Component, OnInit } from '@angular/core';
import { InstrumentService } from 'src/app/service/crud-instrument/instrument.service';
import { Utilisateur } from 'src/app/model/utilisateur';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css'],
})
export class RechercheComponent implements OnInit {
  instruments!: Instrument[];
  utilisateurs!: Utilisateur[];
  constructor(
    private srvInstrument: InstrumentService,
    private srvUtilisateur: UtilisateurService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.srvInstrument.getAll().subscribe((data) => {
      this.instruments = data;
    });
    this.srvUtilisateur.getAllFetchAll().subscribe((data) => {
      this.utilisateurs = data;
    });
  }

  filtrerParInstrument(idIns: number) {
    this.srvInstrument
      .getAllUtilisateurByInstrument(idIns)
      .subscribe((data) => {
        this.utilisateurs = data;
        console.log(this.utilisateurs[0]);
      });
  }
  logout() {
    this.authService.logout();
  }
}
