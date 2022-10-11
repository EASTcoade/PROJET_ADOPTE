import { ImageService } from './../../service/crud-image/image.service';
import { HttpClient } from '@angular/common/http';
import { Instrument } from './../../model/instrument';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { InstrumentService } from 'src/app/service/crud-instrument/instrument.service';
import { Image } from 'src/app/model/image';

@Component({
  selector: 'app-edit-instrument',
  templateUrl: './edit-instrument.component.html',
  styleUrls: ['./edit-instrument.component.css'],
})
export class EditInstrumentComponent implements OnInit {
  instrument: Instrument = new Instrument();
  monFormData = new FormData();
  theImage!: Image;
  constructor(
    private activatedRoute: ActivatedRoute,
    private srvInstrument: InstrumentService,
    private router: Router,
    private httpClient: HttpClient,
    private srvImage: ImageService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.srvInstrument.getById(params['id']).subscribe((data) => {
          this.instrument = data;
        });
      }
    });
  }

  save() {
    if (this.instrument.id) {
      //update
    } else {
      this.srvInstrument.create(this.instrument).subscribe((data) => {
        console.log('instrument créé !');
      });
    }
  }
  public onFileSelected(event: any) {
    const file: File = event.target.files[0];
    if (file) {
      this.monFormData.append('file', file);
      this.monFormData.append('titre', file.name.split('.')[0]);
      this.monFormData.append('format', file.name.split('.')[1].toUpperCase());
    }
  }
  public EnregistrerImage() {
    console.log(this.monFormData.get('titre'));
    // const upload$ = this.httpClient.post(
    //   'http://localhost:8080/adopte/api/image',
    //   this.monFormData
    // );
    const laConst = this.srvImage.create(this.monFormData);
    laConst.subscribe((data) => {
      this.instrument.image = data;
    });
    // upload$.subscribe((data) => {
    //   this.imageID=data.id;
    // });
  }
}
