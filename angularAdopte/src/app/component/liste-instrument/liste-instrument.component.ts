import { Observable } from 'rxjs';
import { InstrumentService } from './../../service/crud-instrument/instrument.service';
import { Component, OnInit } from '@angular/core';
import { Instrument } from 'src/app/model/instrument';
import { ImageService } from 'src/app/service/crud-image/image.service';
import { Image } from 'src/app/model/image';

@Component({
  selector: 'app-liste-instrument',
  templateUrl: './liste-instrument.component.html',
  styleUrls: ['./liste-instrument.component.css'],
})
export class ListeInstrumentComponent implements OnInit {
  instruments!: Observable<Instrument[]>;
  contenu!: Observable<any>;
  voirImage = false;
  imageAAfficher!: Image;
  constructor(
    private srvInstrument: InstrumentService,
    private srvImage: ImageService
  ) {}

  ngOnInit(): void {
    this.instruments = this.srvInstrument.getAll();
  }

  public getContenuImage(id: number): Observable<any> {
    console.log(id);
    this.srvImage.getByIdToRead(id).subscribe((data) => {
      // console.log('fini');
      this.contenu = data.contenu;
    });
    return this.contenu;
    // this.contenu = this.srvImage.getByIdToRead(id);
    // return this.contenu;
  }
  public afficheImage(image: Image) {
    this.voirImage = true;
    return (this.imageAAfficher = image);
  }
}
