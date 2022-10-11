import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs';
import { InscriptionUtiService } from 'src/app/service/crud-uti/inscription-uti.service';
import { AuthService } from './../../service/auth.service';


@Component({
  selector: 'app-choix-instrument',
  templateUrl: './choix-instrument.component.html',
  styleUrls: ['./choix-instrument.component.css']
})
export class ChoixInstrumentComponent implements OnInit {
  id =1;
  ins_id=3;
  constructor(private srvInscri: InscriptionUtiService, private router: Router) { }

  ngOnInit(): void {
  }
  send(){

    this.srvInscri.insertInstrument({utiins_utilisateur_id:this.id, utiins_instrument_id:this.ins_id}).pipe(first()).subscribe(
      data =>{
      console.log(data);
     // this.router.navigate(['home'])
    },
    error => console.log(error));;

  }
}
