import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first, Observable } from 'rxjs';
import { StyleMusical } from 'src/app/model/style-musical';
import { StyleMusicalService } from 'src/app/service/crud-style-musical/style-musical.service';
import { InscriptionUtiService } from 'src/app/service/crud-uti/inscription-uti.service';
import { AuthService } from './../../service/auth.service';

@Component({
  selector: 'app-style-musicaux',
  templateUrl: './style-musicaux.component.html',
  styleUrls: ['./style-musicaux.component.css'],
})
export class StyleMusicauxComponent implements OnInit {
  styleMusicaux!: Observable<StyleMusical[]>;
  afficheMsgStyleOk = false;
  constructor(
    private srvInscri: InscriptionUtiService,
    private router: Router,
    private srvStyleMusicaux: StyleMusicalService
  ) {}

  ngOnInit(): void {
    this.styleMusicaux = this.srvStyleMusicaux.getAll();
  }
  send(idStyle: number) {
    console.log(JSON.parse(sessionStorage.getItem('compte')!).id);
    console.log(idStyle);
    this.srvInscri
      .insertStyleMusical({
        styuti_utilisateur_id: JSON.parse(sessionStorage.getItem('compte')!).id,
        styuti_stylemusical_id: idStyle,
      })
      .subscribe({
        next: (data) => {
          // console.log(data);
          // this.router.navigate(['utilisateur']);
          this.afficheMsgStyleOk = true;
        },
        error: (error) => {
          console.log(error);
        },
      });
  }
  suivant() {
    this.router.navigateByUrl('/choix-instrument');
  }
}
