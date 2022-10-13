import { Instrument } from './../../model/instrument';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first, Observable } from 'rxjs';
import { InscriptionUtiService } from 'src/app/service/crud-uti/inscription-uti.service';
import { AuthService } from './../../service/auth.service';
import { InstrumentService } from 'src/app/service/crud-instrument/instrument.service';

@Component({
  selector: 'app-choix-instrument',
  templateUrl: './choix-instrument.component.html',
  styleUrls: ['./choix-instrument.component.css'],
})
export class ChoixInstrumentComponent implements OnInit {
  instruments!: Observable<Instrument[]>;
  constructor(
    private srvInscri: InscriptionUtiService,
    private router: Router,
    private srvInstrument: InstrumentService
  ) {}

  ngOnInit(): void {
    this.instruments = this.srvInstrument.getAll();
  }
  send(idIns: number) {
    this.srvInscri
      .insertInstrument({
        //transforme le jSON
        utiins_utilisateur_id: JSON.parse(sessionStorage.getItem('compte')!).id,
        utiins_instrument_id: idIns,
        // utiins_instrument_id: this.ins_id,
      })
      .pipe(first())
      .subscribe(
        (data) => {
          console.log(data);
          // this.router.navigate(['home'])
        },
        (error) => console.log(error)
      );
  }
  suivant() {
    this.router.navigateByUrl('/utilisateur');
  }
}
