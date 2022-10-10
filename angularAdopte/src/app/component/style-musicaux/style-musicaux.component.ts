import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs';
import { InscriptionUtiService } from 'src/app/service/crud-uti/inscription-uti.service';
import { AuthService } from './../../service/auth.service';

@Component({
  selector: 'app-style-musicaux',
  templateUrl: './style-musicaux.component.html',
  styleUrls: ['./style-musicaux.component.css']
})
export class StyleMusicauxComponent implements OnInit {
  id=1;
  style_id=3;

  constructor(private srvInscri: InscriptionUtiService, private router: Router) { }

  ngOnInit(): void {
  }
send(){

  this.srvInscri.insertStyleMusical({styuti_utilisateur_id:this.id, styuti_stylemusical_id:this.style_id}).pipe(first()).subscribe(
    data =>{
    console.log(data);
   // this.router.navigate(['home'])
  },
  error => console.log(error));;

}
}
