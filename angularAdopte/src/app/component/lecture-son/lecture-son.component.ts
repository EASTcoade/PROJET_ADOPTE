import { Observable } from 'rxjs';
import { SonService } from './../../service/crud-son/son.service';
import { Component, OnInit } from '@angular/core';
import { Son } from 'src/app/model/son';

@Component({
  selector: 'app-lecture-son',
  templateUrl: './lecture-son.component.html',
  styleUrls: ['./lecture-son.component.css'],
})
export class LectureSonComponent implements OnInit {
  contenu!: Observable<any[]>;
  strcontenu!: string;
  fichier!: File;
  myUrl = '';
  constructor(private srvSon: SonService) {}

  ngOnInit(): void {
    this.srvSon.getByIdToRead(17).subscribe((data) => {
      this.contenu = data.contenu;
      this.myUrl = URL.createObjectURL(data.contenu);
    });
  }
}
